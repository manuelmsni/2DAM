<?php

declare(strict_types=1);

namespace App\Infrastructure\Persistence\User;

use App\Domain\User\User;
use App\Domain\User\UserNotFoundException;
use App\Domain\User\UserRepository;

class InMemoryUserRepository implements UserRepository
{
    /**
     * @var User[]
     */
    private array $users;

    /**
     * @param User[]|null $users
     */
    public function __construct(array $users = null)
    {
        $this->users = $users ?? [
            1 => new User(1, 'bill.gates', 'Bill', 'Gates', 'sedargates', ['admin', 'user']),
            2 => new User(2, 'steve.jobs', 'Steve', 'Jobs', 'applejobs'),
            3 => new User(3, 'mark.zuckerberg', 'Mark', 'Zuckerberg', 'facebookzuck'),
            4 => new User(4, 'evan.spiegel', 'Evan', 'Spiegel', 'snapchatspiegel'),
            5 => new User(5, 'jack.dorsey', 'Jack', 'Dorsey', 'twitterdorsey'),
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function findAll(): array
    {
        return array_values($this->users);
    }

    /**
     * {@inheritdoc}
     */
    public function findUserOfId(int $id): User
    {
        if (!isset($this->users[$id])) {
            throw new UserNotFoundException();
        }

        return $this->users[$id];
    }

    /**
     * {@inheritdoc}
     */
    public function findUserOfUsername(string $username): User
    {
        foreach ($this->users as $user) {
            if ($user->getUsername() === $username) {
                return $user;
            }
        }
        throw new UserNotFoundException();
    }

    public function findUserOfUsernameAndPassword(string $username, string $password): ?User
    {
        foreach ($this->users as $user) {
            if ($user->getUsername() === $username  && $password === $user->getPassword()) {
                return $user;
            }
        }

        throw new UserNotFoundException();
    }
}
