<?php

namespace App\Infrastructure\Persistence\JWT;

use App\Domain\User\User;
use Firebase\JWT\JWT;
use Firebase\JWT\Key;
use Psr\Http\Message\ServerRequestInterface;

class JWToken
{
    /**
     * Get the secret key
     *
     * @return string
     */
    private static function getSecret(): string
    {
        return getenv('JWT_SECRET') ?: 'default_secret';
    }

    /**
     * Create a new token
     *
     * @param User $user
     * @return string
     */
    public static function createToken(User $user): string
    {
        $key = "your_secret_key"; // Mejor almacenarlo en una variable de entorno o configuración segura
        $payload = [
            'iss' => "your_issuer", // Emisor del token
            'aud' => "your_audience", // Audiencia del token
            'iat' => time(), // Tiempo en que el JWT fue emitido
            'exp' => time() + 3600, // Expiración del token, por ejemplo en 1 hora
            'sub' => $user->getId(), // Sujeto del token, podría ser el ID del usuario
            'per' => $user->getPermissions() // Permisos del usuario
        ];

        $token = JWT::encode($payload, JWToken::getSecret(), 'HS256');

        return $token;
    }

    /**
     * Validate a token
     *
     * @param ServerRequestInterface $request
     * @return ServerRequestInterface
     * @throws InvalidTokenException
     */
    public static function validateToken(ServerRequestInterface $request): ServerRequestInterface
    {
        $authorizationHeader = $request->getHeaderLine('Authorization');

        // Check if the authorization header is present and has the expected format
        if (empty($authorizationHeader) || !preg_match('/Bearer\s(\S+)/', $authorizationHeader, $matches)) {
            throw new \Exception('Token not found or invalid');
        }

        $token = $matches[1]; // Extracts the token from the header.

        try {
            $decoded = JWT::decode($token, new Key(JWToken::getSecret(), 'HS256'));
        } catch (InvalidTokenException $e) {
            throw new InvalidTokenException();
        }

        // Si el token es válido, adjunta la información decodificada a la solicitud para su uso posterior.
        return $request->withAttribute('token', $decoded);
    }
}