<?php

declare(strict_types=1);

namespace App\Application\Actions\Taxon;

use App\Application\Actions\Action;
use App\Domain\Taxon\TaxonRepository;
use Psr\Log\LoggerInterface;

abstract class TaxonAction extends Action
{
    protected TaxonRepository $taxonRepository;

    public function __construct(LoggerInterface $logger, TaxonRepository $taxonRepository)
    {
        parent::__construct($logger);
        $this->taxonRepository = $taxonRepository;
    }
}
