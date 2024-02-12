<?php

declare(strict_types=1);

namespace App\Application\Actions\Taxon;

use Psr\Http\Message\ResponseInterface as Response;

class ListTaxonsAction extends TaxonAction
{
    /**
     * {@inheritdoc}
     */
    protected function action(): Response
    {
        $taxons = $this->taxonRepository->findAll();

        $this->logger->info("Taxon list was viewed.");

        return $this->respondWithData($taxons);
    }
}
