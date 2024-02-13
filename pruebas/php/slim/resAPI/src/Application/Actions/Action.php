<?php

declare(strict_types=1);

namespace App\Application\Actions;

use App\Domain\DomainException\DomainRecordNotFoundException;
use Psr\Http\Message\ResponseInterface as Response;
use Psr\Http\Message\ServerRequestInterface as Request;
use Psr\Log\LoggerInterface;
use Slim\Exception\HttpBadRequestException;
use Slim\Exception\HttpNotFoundException;

abstract class Action
{
    /**
     * Logger service for logging purposes.
     */
    protected LoggerInterface $logger;

    /**
     * The HTTP request object.
     */
    protected Request $request;

    /**
     * The HTTP response object.
     */
    protected Response $response;

    /**
     * Route parameters passed to the action.
     */
    protected array $args;

    /**
     * Constructor method that initializes the logger.
     *
     * @param LoggerInterface $logger Logger service for logging within the action.
     */
    public function __construct(LoggerInterface $logger)
    {
        $this->logger = $logger;
    }

    /**
     * Magic invoke method called when the action is executed. Sets up the request,
     * response, and args properties. It then delegates to the `action()` method for
     * the specific action logic.
     *
     * @param Request $request The request object.
     * @param Response $response The response object.
     * @param array $args Route parameters.
     * @return Response The response object.
     * @throws HttpNotFoundException When a domain record is not found.
     * @throws HttpBadRequestException For bad requests.
     */
    public function __invoke(Request $request, Response $response, array $args): Response
    {
        $this->request = $request;
        $this->response = $response;
        $this->args = $args;

        try {
            return $this->action();
        } catch (DomainRecordNotFoundException $e) {
            throw new HttpNotFoundException($this->request, $e->getMessage());
        }
    }

    /**
     * Abstract action method that contains the logic of the action. Must be implemented
     * by child classes.
     *
     * @return Response The response object.
     * @throws DomainRecordNotFoundException When a specific domain record is not found.
     * @throws HttpBadRequestException For bad requests.
     */
    abstract protected function action(): Response;

    /**
     * Retrieves form data from the request body. The method supports both JSON and
     * form-encoded input.
     *
     * @return array|object|null The parsed request payload.
     */
    protected function getFormData()
    {
        return $this->request->getParsedBody();
    }

    /**
     * Resolves and returns the value of a specific named route argument.
     *
     * @param string $name The name of the route argument to resolve.
     * @return mixed The value of the route argument.
     * @throws HttpBadRequestException When the named route argument is not present.
     */
    protected function resolveArg(string $name)
    {
        if (!isset($this->args[$name])) {
            throw new HttpBadRequestException($this->request, "Could not resolve argument `{$name}`.");
        }

        return $this->args[$name];
    }

    /**
     * Constructs a JSON response with the given data.
     *
     * @param array|object|null $data Data to be included in the response body.
     * @param int $statusCode HTTP status code for the response.
     * @return Response The response object with the data and status code.
     */
    protected function respondWithData($data = null, int $statusCode = 200): Response
    {
        $payload = new ActionPayload($statusCode, $data);

        return $this->respond($payload);
    }

    /**
     * Helper method to construct a JSON response from an ActionPayload object.
     *
     * @param ActionPayload $payload The payload to respond with.
     * @return Response The response object.
     */
    protected function respond(ActionPayload $payload): Response
    {
        $json = json_encode($payload, JSON_PRETTY_PRINT);
        $this->response->getBody()->write($json);

        return $this->response
                    ->withHeader('Content-Type', 'application/json')
                    ->withStatus($payload->getStatusCode());
    }
}
