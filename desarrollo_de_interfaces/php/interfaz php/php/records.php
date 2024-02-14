<?php
require_once "config.php";
try {
    $conn = new mysqli(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);

    if ($conn->connect_error) {
        die("Conexión fallida: " . $conn->connect_error);
    }

    $sql = "SELECT * FROM " . TABLE_NAME;
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        while($row = $result->fetch_assoc()) {
            echo "<tr data-id='" . $row["id"] . "'><td>" . $row["nombre"] . "</td><td>" . $row["precio"]. "</td><td>" . $row["descripcion"] . "</td><td class='btn-delete' data-id='" . $row["id"] . "'>Eliminar</td></tr>";
        }
    } else {
        echo "<tr><td colspan='4'>0 resultados</td></tr>";
    }
} catch (Exception $e) {
    exit();
} finally {
    if (isset($conn)) {
        $conn->close();
    }
}