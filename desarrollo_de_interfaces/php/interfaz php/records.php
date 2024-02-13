<?php
require_once "config.php";

$conn = new mysqli(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);

if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}

$sql = "SELECT * FROM " . TABLE_NAME;
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        echo "<tr><td>" . $row["nombre"] . "</td><td>" . $row["precio"]. "</td><td><img alt='foto' src='" . $row["imagen"] . "'/></td></tr>";
    }
} else {
    echo "<tr><td colspan='3'>0 resultados</td></tr>";
}

$conn->close();
?>