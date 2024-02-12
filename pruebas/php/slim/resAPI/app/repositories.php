<?php

declare(strict_types=1);

use App\Domain\Key\KeyRepository;
use App\Domain\Taxon\TaxonRepository;
use App\Domain\User\UserRepository;
use App\Infrastructure\Persistence\Key\InMemoryKeyRepository;
use App\Infrastructure\Persistence\Taxon\InMemoryTaxonRepository;
use App\Infrastructure\Persistence\User\InMemoryUserRepository;
use DI\ContainerBuilder;

return function (ContainerBuilder $containerBuilder) {
    // Here we map our UserRepository interface to its in memory implementation
    $containerBuilder->addDefinitions([
        UserRepository::class => \DI\autowire(InMemoryUserRepository::class),
        TaxonRepository::class => \DI\autowire(InMemoryTaxonRepository::class),
        KeyRepository::class => \DI\autowire(InMemoryKeyRepository::class),
    ]);
};
