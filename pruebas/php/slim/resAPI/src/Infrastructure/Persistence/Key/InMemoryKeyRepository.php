<?php

declare(strict_types=1);

namespace App\Infrastructure\Persistence\Key;

use App\Domain\Key\Key;
use App\Domain\Key\KeyNotFoundException;
use App\Domain\Key\KeyRepository;
use App\Domain\Taxon\TaxonNotFoundException;
use App\Infrastructure\Persistence\Taxon\InMemoryTaxonRepository;

class InMemoryKeyRepository implements KeyRepository
{
    /**
     * @var Key[]
     */
    private array $keys;
    /**
     * @param Key[]|null $keys
     */
    public function __construct(array $keys = null)
    {
        $startTaxon = null;
        try {
            $startTaxon = (new InMemoryTaxonRepository())->findTaxonOfId(1);
        } catch (TaxonNotFoundException $e) {
        }
        $this->keys = $keys ?? [
            1 => new Key(1, null, 2, "Clave 1", 0, 0, $startTaxon),
            2 => new Key(2, 1, 2, "Clave 2", 0, 0, $startTaxon)
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function findAll(): array
    {
        return array_values($this->keys);
    }

    /**
     * {@inheritdoc}
     */
    public function findKeyOfId(int $id): Key
    {
        if (!isset($this->keys[$id])) {
            throw new KeyNotFoundException();
        }

        return $this->keys[$id];
    }
}
