<?php
require_once "config.php";

function checkDatabaseAndTables() {
    try {
        $mysqli = new mysqli(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);

        // Conexión exitosa, verifica si la tabla existe
        if (!tableExists($mysqli, TABLE_NAME)) {
            // La tabla no existe, intenta crearla
            echo "<p>La tabla no existe. Intentando crearla...</p>";
            createTables();
        } else {
            echo "<p>Conexión exitosa, recuperando registros...</p>";
        }
    } catch (mysqli_sql_exception $e) {
        if ($e->getCode() == 1049) {
            echo "<p> La base de datos no existe. Intentando crearla...</p>";
            createDatabase();
        } else if ($e->getCode() == 2002) {
            echo "<p>No se puede establecer conexión con el servidor MySQL. Verifica tus configuraciones.</p>";
        } else {
            echo "<p>Error de conexión:</p> ";
        }
    }
}
function tableExists($mysqli, $tableName) {
    $checkTable = $mysqli->query("SHOW TABLES LIKE '".$tableName."'");
    return $checkTable && $checkTable->num_rows > 0;
}
function createDatabase() {

    $conn = new mysqli(DB_SERVER, DB_USERNAME, DB_PASSWORD);

    if ($conn->connect_error) {
        die("<p>No se puede conectar con el servidor de la base de datos</p");
    }

    $sql = "CREATE DATABASE " . DB_NAME;

    if ($conn->query($sql) === TRUE) {
        createTables();
    } else {
        die();
    }

    $conn->close();
}
function createTables()
{
    try{
        $conn = new mysqli(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);

        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        }

        $sql = "CREATE TABLE ". TABLE_NAME . " ( id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(50) NOT NULL, precio VARCHAR(50) NOT NULL, imagen VARCHAR(250), descripcion VARCHAR(250))";

        if ($conn->query($sql) === TRUE) {
            echo "<p>Se ha creado la tabla " . TABLE_NAME . "</p>";
        } else {
            echo "<p>No se ha podido crear la tabla " . TABLE_NAME . "</p>";
        }
    } catch (Exception $e) {
        echo "Error: " . $e->getMessage();
    } finally {
        if (isset($conn)) {
            $conn->close();
        }
    }
}

checkDatabaseAndTables();