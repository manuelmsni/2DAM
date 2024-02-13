<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Informe</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<div class="container">
    <h1>Informe</h1>
    <?php include 'report.php'; ?>

    <h2>Agregar Nuevo Registro</h2>
    <form action="report.php" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" required>

        <label for="imagen">Url de la imagen:</label>
        <input type="text" name="imagen" required>

        <label for="precio">Precio:</label>
        <input type="text" name="precio" required>

        <button type="submit">Agregar</button>
    </form>

    <table>
        <tr>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Imagen</th>
        </tr>
        <?php include 'records.php'; ?>
    </table>
</div>

</body>
</html>