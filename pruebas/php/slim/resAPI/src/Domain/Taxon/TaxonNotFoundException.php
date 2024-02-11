<?php

declare(strict_types=1);

namespace App\Domain\Taxon;

use App\Domain\DomainException\DomainRecordNotFoundException;

class TaxonNotFoundException extends DomainRecordNotFoundException
{
    public $message = 'The taxon you requested does not exist.';
}
