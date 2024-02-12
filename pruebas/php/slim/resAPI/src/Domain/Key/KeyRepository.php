<?php

declare(strict_types=1);

namespace App\Domain\Key;

interface KeyRepository
{
    /**
     * @return Key[]
     */
    public function findAll(): array;

    /**
     * @param int $id
     * @return Key
     * @throws KeyNotFoundException
     */
    public function findKeyOfId(int $id): Key;
}
