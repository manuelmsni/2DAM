<?php

namespace App\Application\Middleware;

use App\Infrastructure\Persistence\JWT\JWToken;
use Psr\Http\Message\ResponseInterface;
use Psr\Http\Message\ServerRequestInterface;
use Psr\Http\Server\RequestHandlerInterface;
use Psr\Http\Server\MiddlewareInterface;
use Firebase\JWT\JWT;
use Firebase\JWT\Key;
use Slim\Psr7\Response;

class JWTMiddleware implements MiddlewareInterface
{
    // Array de permisos requeridos para acceder a la ruta.
    private $requiredPermissions;

    // Constructor que opcionalmente acepta un array de permisos requeridos.
    public function __construct(array $requiredPermissions = [])
    {
        $this->requiredPermissions = $requiredPermissions;
    }

    // Método requerido por la interfaz Middleware que procesa la solicitud.
    public function process(ServerRequestInterface $request, RequestHandlerInterface $handler): ResponseInterface
    {
        try {
            // Valida el token JWT y lo adjunta a la solicitud como un atributo.
            $request = JWToken::validateToken($request);
            if (!$this->checkPermissions($request)) {
                // Si el token no tiene los permisos requeridos, retorna una respuesta con estado HTTP 403 Forbidden.
                $response = new Response();
                $response->getBody()->write(json_encode(['error' => 'Insufficient permissions']));
                return $response->withStatus(403)->withHeader('Content-Type', 'application/json');
            }
        } catch (\Exception $e) {
            // Si hay un error en la validación del token, retorna una respuesta con estado HTTP 401 Unauthorized.
            $response = new Response();
            $response->getBody()->write(json_encode(['error' => $e->getMessage()]));
            return $response->withStatus(401)->withHeader('Content-Type', 'application/json');
        }

        // Si el token es válido, procesa la siguiente capa del middleware o la ruta.
        return $handler->handle($request);
    }

    private function checkPermissions(ServerRequestInterface $request): bool
    {
        $decodedToken = $request->getAttribute('token');
        if (!empty($this->requiredPermissions)) {
            $tokenPermissions = $decodedToken->perm ?? [];
            $hasPermission = false;
            foreach ($this->requiredPermissions as $requiredPermission) {
                if (in_array($requiredPermission, $tokenPermissions)) {
                    $hasPermission = true;
                    break;
                }
            }
            return $hasPermission;
        }
        return true;
    }

}
