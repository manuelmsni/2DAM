<?php

declare(strict_types=1);

namespace App\Infrastructure\Persistence\Key;

use App\Domain\Key\Key;
use App\Domain\Key\KeyNotFoundException;
use App\Domain\Key\KeyRepository;

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
        $this->keys = $keys ?? [
            1 => new Key(1, null, 2, "Clave 1", 0, 0, null),
            2 => new Key(2, 1, 2, "Clave 2", 0, 0, null)
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
