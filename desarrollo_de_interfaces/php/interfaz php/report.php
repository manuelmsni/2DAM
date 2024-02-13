<?php
require_once "config.php";

if ($_SERVER["REQUEST_METHOD"] == "POST") {

    $nombre = $_POST["nombre"];
    $precio = $_POST["precio"];
    $imagen = $_POST["imagen"];

    $conn = new mysqli(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);

    if ($conn->connect_error) {
        die("Conexión fallida: " . $conn->connect_error);
    }

    $sql = "INSERT INTO " . TABLE_NAME . "(nombre, precio, imagen) VALUES ('$nombre','$precio','$imagen')";

    if ($conn->query($sql) === TRUE) {
        echo "Registro agregado correctamente";
    } else {
        echo "Error al agregar el registro: " . $conn->error;
    }

    $conn->close();
}
?>
