<?php

declare(strict_types=1);

namespace App\Domain\Taxon;

use JsonSerializable;

class Taxon implements JsonSerializable
{
    private ?int $id;
    private string $name;
    private TaxonCategory $category;
    private ?Taxon $father = null;
    /**
     * @var Taxon[]
     */
    private array $children = [];

    public function __construct(?int $id, string $name, TaxonCategory $category, ?Taxon $father = null)
    {
        $this->id = $id;
        $this->name = $name;
        $this->category = $category;
        $this->father = $father;
    }
    public function setParent(Taxon $father): void
    {
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
            'name' => $this->name,
            'category' => $this->category
        ];

        if ($fatherId !== null) {
            $data['father'] = $fatherId;
        }

        if (count($this->children) > 0) {
            $data['children'] = $serializedChildren;
        }

        return $data;
    }
}
