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

    //documentación de las rutas
    $app->get('/', function (Request $request, Response $response) {
        $response->getBody()->write('Welcome to the taxogg API!');
        return $response;
    });//->add(new JwtMiddleware(['admin']));

    $app->post('/login', LoginAction::class);

    $app->group('/taxons', function (Group $group) {
        $group->get('', ListTaxonsAction::class);
    })->add(new JwtMiddleware(['admin']));

    $app->group('/keys', function (Group $group) {
        $group->get('', ListKeysAction::class);
    })->add(new JwtMiddleware());

    $app->group('/users', function (Group $group) {
        $group->get('', ListUsersAction::class)->add(new JwtMiddleware(['admin', 'user']));
        $group->get('/{id}', ViewUserAction::class)->add(new JwtMiddleware(['admin']));
    });
};
