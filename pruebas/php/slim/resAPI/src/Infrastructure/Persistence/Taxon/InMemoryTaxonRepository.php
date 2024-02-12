<?php

declare(strict_types=1);

namespace App\Infrastructure\Persistence\Taxon;

use App\Domain\Taxon\Taxon;
use App\Domain\Taxon\TaxonCategory;
use App\Domain\Taxon\TaxonNotFoundException;
use App\Domain\Taxon\TaxonRepository;

class InMemoryTaxonRepository implements TaxonRepository
{
    /**
     * @var Taxon[]
     */
    private array $taxons;

    /**
     * @param Taxon[]|null $taxons
     */
    public function __construct(array $taxons = null)
    {
        if ($taxons === null) {
            $taxons = [
                1 => new Taxon(1, 'Hymenoptera', TaxonCategory::Ordo, null),
                2 => new Taxon(2, 'Apidae', TaxonCategory::Familia, null), // Temporarily set to null
                3 => new Taxon(3, 'Apis', TaxonCategory::Genus, null), // Temporarily set to null
                4 => new Taxon(4, 'Mellifera', TaxonCategory::Species, null) // Temporarily set to null
            ];

            // Set parents after all taxons are instantiated to avoid circular reference issues
            $taxons[2]->setParent($taxons[1]);
            $taxons[3]->setParent($taxons[2]);
            $taxons[4]->setParent($taxons[3]);
        }
        $this->taxons = $taxons;
    }

    /**
     * {@inheritdoc}
     */
    public function findAll(): array
    {
        return array_values($this->taxons);
    }

    /**
     * {@inheritdoc}
     */
    public function findTaxonOfId(int $id): Taxon
    {
        if (!isset($this->taxons[$id])) {
            throw new TaxonNotFoundException();
        }

        return $this->taxons[$id];
    }
}
