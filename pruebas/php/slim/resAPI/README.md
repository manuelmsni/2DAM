# Slim Framework 4

## Install the Application

* Point the virtual host document root to the application's `public/` directory.
* Ensure `logs/` is web writable.

Command to run with docker (cmd in the application directory):
```bash
cd resAPI
docker-compose up -d
```
Api domain `http://localhost:6969`.

## Run the tests

Command to run the test suite (cmd in the application directory):

```bash
composer test
```
