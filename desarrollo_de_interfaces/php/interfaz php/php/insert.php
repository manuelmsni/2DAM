<?php
require_once "config.php";

if ($_SERVER["REQUEST_METHOD"] == "POST") {

    // Recoger los valores del formulario
    $nombre = $_POST["nombre"];
    $precio = $_POST["precio"];
    $imagen = $_POST["imagen"];
    $descripcion = $_POST["descripcion"];

    try {
        $conn = new mysqli(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);

        if ($conn->connect_error) {
            throw new Exception("Conexión fallida: " . $conn->connect_error);
        }

        // Preparar la sentencia SQL para insertar los datos, incluyendo la descripción
        $sql = "INSERT INTO " . TABLE_NAME . " (nombre, precio, imagen, descripcion) VALUES (?, ?, ?, ?)";

        // Preparar sentencia
        $stmt = $conn->prepare($sql);

        if ($stmt === false) {
            throw new Exception("Error en la preparación de la sentencia: " . $conn->error);
        }

        // Vincular parámetros para marcadores
        $stmt->bind_param("ssss", $nombre, $precio, $imagen, $descripcion);

        // Ejecutar sentencia
        if ($stmt->execute() === TRUE) {
            echo "Registro agregado correctamente";
        } else {
            echo "Error al agregar el registro: " . $stmt->error;
        }

        // Cerrar sentencia
        $stmt->close();

    } catch (Exception $e) {
        echo "Error: " . $e->getMessage();
        exit();
    } finally {
        if (isset($conn)) {
            // Cerrar conexión
            $conn->close();
        }
    }
}
?>
