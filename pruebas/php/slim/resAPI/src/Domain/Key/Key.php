<?php

declare(strict_types=1);

namespace App\Domain\Key;

use App\Domain\Taxon\Taxon;
use JsonSerializable;

class Key implements JsonSerializable
{
    private ?int $id;
    private ?int $forkedFromKeyId;
    private int $authorId;
    private string $title;
    private int $creationDate;
    private int $lastModified;
    private Taxon $startTaxon;
    /**
     * @var Taxon[]
     */
    private array $endpoints = [];

    public function __construct(
        ?int $id,
        ?int $forkedFromKeyId,
        int $authorId,
        string $title,
        int $creationDate,
        int $lastModified,
        Taxon $startTaxon
    ) {
        $this->id = $id;
        $this->forkedFromKeyId = $forkedFromKeyId;
        $this->authorId = $authorId;
        $this->title = $title;
        $this->creationDate = $creationDate;
        $this->lastModified = $lastModified;
        $this->startTaxon = $startTaxon;
    }

    public function addEndpoint(Taxon $endpoint): void
    {
        $this->endpoints[] = $endpoint;
    }

    #[\ReturnTypeWillChange]
    public function jsonSerialize(): array
    {
        $data = [
            'id' => $this->id,
            'authorId' => $this->authorId,
            'title' => $this->title,
            'creationDate' => $this->creationDate,
            'lastModified' => $this->lastModified,
            'startTaxon' => $this->startTaxon
        ];
        if ($this->forkedFromKeyId !== null) {
            $data['forkedFromKeyId'] = $this->forkedFromKeyId;
        }
        if (count($this->endpoints) > 0) {
            $data['endpoints'] = array_map(function ($endpoint) {
                return $endpoint->jsonSerialize();
            }, $this->endpoints);
        }
        return $data;
    }
}
