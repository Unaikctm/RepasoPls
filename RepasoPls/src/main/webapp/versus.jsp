<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabla de Caballeros</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .versus {
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 20px 0;
        }
        .versus img {
            max-width: 100px;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-md-5">
            <h2 class="text-center">Datos de Caballero 1</h2>
            <table class="table table-bordered">
                <tr>
                    <td>ID:</td>
                    <td>${cab1.id}</td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td>${cab1.nombre}</td>
                </tr>
                <tr>
                    <td>Fuerza:</td>
                    <td>${cab1.fuerza}</td>
                </tr>
                <tr>
                    <td>Experiencia:</td>
                    <td>${cab1.experiencia}</td>
                </tr>
                <tr>
                    <td>Foto:</td>
                    <td><img alt="" src="fotos/${cab1.foto}" style="max-width:200px;max-height:200px;"></td>
                </tr>
                <tr>
                    <td>Arma:</td>
                    <td>${cab1.arma.nombre}, ${cab1.arma.capacidad_danio}</td>
                </tr>
                <tr>
                    <td>Escudo:</td>
                    <td>${cab1.escudo.nombre}, ${cab1.escudo.capacidad_defensa}</td>
                </tr>
            </table>
        </div>

        <div class="col-md-2 versus">
            <img src="https://via.placeholder.com/100x100.png?text=VS" alt="Versus">
        </div>

        <div class="col-md-5">
            <h2 class="text-center">Datos de Caballero 2</h2>
            <table class="table table-bordered">
                <tr>
                    <td>ID:</td>
                    <td>${cab2.id}</td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td>${cab2.nombre}</td>
                </tr>
                <tr>
                    <td>Fuerza:</td>
                    <td>${cab2.fuerza}</td>
                </tr>
                <tr>
                    <td>Experiencia:</td>
                    <td>${cab2.experiencia}</td>
                </tr>
                <tr>
                    <td>Foto:</td>
                    <td><img alt="" src="fotos/${cab2.foto}" style="max-width:200px;max-height:200px;"></td>
                </tr>
                <tr>
                    <td>Arma:</td>
                    <td>${cab2.arma.nombre}, ${cab2.arma.capacidad_danio}</td>
                </tr>
                <tr>
                    <td>Escudo:</td>
                    <td>${cab2.escudo.nombre}, ${cab2.escudo.capacidad_defensa}</td>
                </tr>
            </table>
        </div>
    </div>
    <div class="row justify-content-center">
        <form action="Versus" method="POST">
            <input type="hidden" name="cab1" value="${cab1.id}">
            <input type="hidden" name="cab2" value="${cab2.id}">
            <button type="submit" class="btn btn-primary">Luchar</button>
        </form>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
