<?php

declare(strict_types=1);

namespace App\Domain\Key;

use App\Domain\Taxon\Taxon;
use JsonSerializable;

class Key implements JsonSerializable
{
    private ?int $id;
    private string $author;
    private int $creationDate;
    private int $lastModified;
    private Taxon $taxon;

    public function __construct(?int $id, string $author, int $creationDate, int $lastModified, Taxon $taxon)
    {
        $this->id = $id;
        $this->author = strtolower($author);
        $this->creationDate = $creationDate;
        $this->lastModified = $lastModified;
        $this->taxon = $taxon;
    }

    #[\ReturnTypeWillChange]
    public function jsonSerialize(): array
    {
        return [
            'id' => $this->id,
            'author' => $this->author,
            'creationDate' => $this->creationDate,
            'lastModified' => $this->lastModified,
            'taxon' => $this->taxon
        ];
    }
}