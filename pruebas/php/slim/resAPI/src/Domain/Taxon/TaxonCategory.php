<?php

namespace App\Domain\Taxon;

enum TaxonCategory: string
{
    case Regnum = 'Reino';
    case Phylum = 'Filo';
    case Classis = 'Clase';
    case Subclassis = 'Subclase';
    case Superordo = 'Superorden';
    case Ordo = 'Orden';
    case Subordo = 'Suborden';
    case Infraordo = 'Infraorden';
    case Familia = 'Familia';
    case Subfamilia = 'Subfamilia';
    case Tribus = 'Tribu';
    case Subtribus = 'Subtribu';
    case Genus = 'Género';
    case Species = 'Especie';

    #[\ReturnTypeWillChange]
    public function jsonSerialize(): array
    {
        return [
            'category' => $this->value
        ];
    }
}