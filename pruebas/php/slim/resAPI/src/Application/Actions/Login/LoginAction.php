<?php

declare(strict_types=1);

namespace App\Application\Actions\Login;

use App\Application\Actions\Action;
use App\Domain\User\UserNotFoundException;
use App\Infrastructure\Persistence\JWT\JWToken;
use Psr\Http\Message\ResponseInterface as Response;
use Psr\Log\LoggerInterface;
use App\Domain\User\UserRepository;

class LoginAction extends Action
{
    protected UserRepository $userRepository;

    public function __construct(LoggerInterface $logger, UserRepository $userRepository)
    {
        parent::__construct($logger);
        $this->userRepository = $userRepository;
    }

    /**
     * {@inheritdoc}
     */
    protected function action(): Response
    {
        $data = $this->getFormData();
        $username = $data['username'] ?? null;
        $password = $data['password'] ?? null;

        try {
            $user = $this->userRepository->findUserOfUsernameAndPassword($username, $password);
        } catch (UserNotFoundException $e) {
            return $this->respondWithData(['error' => 'Invalid credentials'], 401);
        }

        $token = JWToken::createToken($user);

        $this->logger->info(sprintf("User %s logged in successfully.", $username));

        return $this->respondWithData(['token' => $token]);
    }
}
