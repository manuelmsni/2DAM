<?php

declare(strict_types=1);

namespace App\Domain\User;

interface UserRepository
{
    /**
     * @return User[]
     */
    public function findAll(): array;

    /**
     * @param int $id
     * @return User
     * @throws UserNotFoundException
     */
    public function findUserOfId(int $id): User;

    /**
     * Finds a user by username.
     *
     * @param string $username The username of the user to find.
     * @return User The found user.
     * @throws UserNotFoundException If no user with the given username exists.
     */
    public function findUserOfUsername(string $username): User;

    /**
     * Finds a user by username and password.
     *
     * @param string $username The username of the user to find.
     * @param string $password The password of the user to find.
     * @return ?User The found user.
     * @throws UserNotFoundException If no user with the given username and password exists.
     */
    public function findUserOfUsernameAndPassword(string $username, string $password): ?User;
}
