<?php

declare(strict_types=1);

use App\Application\Actions\Key\ListKeysAction;
use App\Application\Actions\Login\LoginAction;
use App\Application\Actions\Taxon\ListTaxonsAction;
use App\Application\Actions\User\ListUsersAction;
use App\Application\Actions\User\ViewUserAction;
use App\Application\Middleware\JWTMiddleware;
use Psr\Http\Message\ResponseInterface as Response;
use Psr\Http\Message\ServerRequestInterface as Request;
use Slim\App;
use Slim\Interfaces\RouteCollectorProxyInterface as Group;

return function (App $app) {
    $app->options('/{routes:.*}', function (Request $request, Response $response) {
        // CORS Pre-Flight OPTIONS Request Handler
        return $response;
    });

    $app->get('/', function (Request $request, Response $response) {
        $response->getBody()->write('Welcome to the taxogg API!');
        return $response;
    });

    $app->post('/login', LoginAction::class);

    // Grupo de rutas para taxones, protegido con JWT y requiere permiso 'admin'
    $app->group('/taxons', function (Group $group) {
        $group->get('', ListTaxonsAction::class);
    })->add(new JwtMiddleware(['admin']));

    // Grupo de rutas para claves, abierto a todos los usuarios autenticados
    $app->group('/keys', function (Group $group) {
        $group->get('', ListKeysAction::class);
    })->add(new JwtMiddleware());

    // Grupo de rutas para usuarios, con diferentes niveles de permisos
    $app->group('/users', function (Group $group) {
        $group->get('', ListUsersAction::class)->add(new JwtMiddleware(['admin', 'user']));
        $group->get('/{id}', ViewUserAction::class)->add(new JwtMiddleware(['admin']));
    });
};

/*
return function (App $app) {
    $app->options('/{routes:.*}', function (Request $request, Response $response) {
        // CORS Pre-Flight OPTIONS Request Handler
        return $response;
    });

    $app->get('/', function (Request $request, Response $response) {
        $response->getBody()->write('Wellcome to the taxogg API!');
        return $response;
    });

    $app->group('/taxons', function (Group $group) {
        $group->get('', ListTaxonsAction::class);
    });

    $app->group('/keys', function (Group $group) {
        $group->get('', ListKeysAction::class);
    });

    $app->group('/users', function (Group $group) {
        $group->get('', ListUsersAction::class);
        $group->get('/{id}', ViewUserAction::class);
    });
};
 */
