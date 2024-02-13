<?php

namespace App\Application\Actions\Key;

use Psr\Http\Message\ResponseInterface as Response;

class ListKeysAction extends KeyAction
{
    /**
     * @inheritDoc
     */
    protected function action(): Response
    {
        $keys = $this->keyRepository->findAll();

        $this->logger->info("Taxon list was viewed.");

        return $this->respondWithData($keys);
    }
}