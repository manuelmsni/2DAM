<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Informe</title>
    <link rel="stylesheet" href="assets/styles/styles.css">
</head>
<body>
<div class="container">
    <h1>Informe</h1>
    <?php include 'php/checkDatabase.php'; ?>
</div>
<div class="container">

    <h2>Agregar Nuevo Registro</h2>
    <form id="form">
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" required>

        <label for="imagen">Url de la imagen:</label>
        <input type="text" name="imagen" required>

        <label for="descripcion">Descripción:</label>
        <input name="descripcion" required>

        <label for="precio">Precio:</label>
        <input type="text" name="precio" required>

        <button type="submit">Agregar</button>
    </form>
</div>

<div class="container">
    <h2>Base de Datos</h2>
    <table>
        <thead>
        <th>Nombre</th>
        <th>Precio</th>
        <th>Descripción</th> <!-- Encabezado para la columna de descripción -->
        </thead>
        <?php include 'php/records.php'; ?>
    </table>
</div>

<!-- Los scripts permanecen sin cambios -->

<script>
    document.getElementById('form').addEventListener('submit', function(e) {
        e.preventDefault();
        var datosFormulario = new FormData(this);
        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'php/insert.php', true);
        xhr.onload = function() {
            if (this.status === 200) {
                console.log(this.responseText);
                location.reload();
            }
        };

        xhr.send(datosFormulario);
    });
</script>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        document.querySelectorAll('.btn-delete').forEach(button => {
            button.addEventListener('click', function(e) {
                e.stopPropagation();
                var id = this.getAttribute('data-id');
                var formData = new FormData();
                formData.append('id', id);

                fetch('php/delete.php', {
                    method: 'POST',
                    body: formData
                })
                    .then(response => response.text())
                    .then(data => {
                        console.log(data);
                        location.reload();
                    })
                    .catch(error => console.error('Error:', error));
            });
        });

        document.querySelectorAll('tr[data-id]').forEach(row => {
            row.addEventListener('click', function() {
                var id = this.getAttribute('data-id');
                window.location.href = 'details.php?id=' + id;
            });
        });
    });
</script>
</body>
</html>