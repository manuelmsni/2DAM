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

    <h2>Detalles</h2>
    <div class="splitter">
        <?php include 'php/detalle.php'; ?>
    </div>

</div>
<script>
    document.getElementById('form').addEventListener('submit', function(e) {
        e.preventDefault();
        var datosFormulario = new FormData(this);
        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'php/update.php', true);
        xhr.onload = function() {
            if (this.status === 200) {
                console.log(this.responseText);
                location.reload();
            }
        };

        xhr.send(datosFormulario);
    });
</script>
</body>
</html>