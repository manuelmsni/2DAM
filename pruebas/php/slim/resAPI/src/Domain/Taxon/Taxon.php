<?php

declare(strict_types=1);

namespace App\Domain\Taxon;

use JsonSerializable;

class Taxon implements JsonSerializable
{
    private ?int $id;
    private ?Taxon $father = null;
    private array $children = [];

    public function __construct(?int $id, ?Taxon $father = null)
    {
        $this->id = $id;
        $this->father = $father;
    }
    public function addChild(Taxon $child): void
    {
        $this->children[] = $child;
    }
    #[\ReturnTypeWillChange]
    public function jsonSerialize(): array
    {
        $fatherId = $this->father ? $this->father->id : null;
        $serializedChildren = array_map(function ($child) {
            return $child->jsonSerialize();
        }, $this->children);

        $data = [
            'id' => $this->id,
            'father' => $fatherId,
        ];

        if (count($this->children) > 0) {
            $data['children'] = $serializedChildren;
        }

        return $data;
    }
}