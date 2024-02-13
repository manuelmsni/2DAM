<?php

namespace App\Infrastructure\Persistence\JWT;

class InvalidTokenException extends \Exception
{
    public $message = 'Provided token is invalid.';
}