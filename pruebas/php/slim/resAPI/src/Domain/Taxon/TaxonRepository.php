<?php

declare(strict_types=1);

namespace App\Domain\Taxon;

interface TaxonRepository
{
    /**
     * @return Taxon[]
     */
    public function findAll(): array;

    /**
     * @param int $id
     * @return Taxon
     * @throws TaxonNotFoundException
     */
    public function findTaxonOfId(int $id): Taxon;
}
