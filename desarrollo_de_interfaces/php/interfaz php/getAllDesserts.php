<?php
require_once "config.php";

$conn = new mysqli(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);

if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}

$sql = "SELECT nombre, correo FROM " . TABLE_NAME;
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        echo "<li>Nombre: " . $row["nombre"]. " - Correo: " . $row["correo"]. "</li>";
    }
} else {
    echo "0 resultados";
}
