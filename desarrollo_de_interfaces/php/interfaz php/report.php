<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {

    $nombre = $_POST["nombre"];
    $correo = $_POST["correo"];

    $conn = new mysqli(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);

    if ($conn->connect_error) {
        die("Conexión fallida: " . $conn->connect_error);
    }

    $sql = "INSERT INTO tu_tabla (nombre, correo) VALUES ('$nombre','$correo')";

    if ($conn->query($sql) === TRUE) {
        echo "Registro agregado correctamente";

        // obtener datos de la consulta en forma de lista
    } else {
        echo "Error al agregar el registro: " . $conn->error;
    }

    $conn->close();
}
?>
