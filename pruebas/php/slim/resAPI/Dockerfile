FROM php:latest

# Instala las dependencias necesarias
RUN apt-get update && apt-get install -y \
    git \
    zip \
    unzip

# Instala Composer
RUN php -r "copy('https://getcomposer.org/installer', 'composer-setup.php');" \
    && php composer-setup.php --install-dir=/usr/local/bin --filename=composer \
    && php -r "unlink('composer-setup.php');"

WORKDIR /var/www

CMD ["php", "-S", "0.0.0.0:8080", "-t", "public"]