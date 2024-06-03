<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabla de Caballeros</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
    <div class="row">
        <div class="col-md-5">
            <h2 class="text-center">Datos del ganador</h2>
            <table class="table table-bordered">
                <tr>
                    <td>ID:</td>
                    <td>${lucha.ganador.id}</td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td>${lucha.ganador.nombre}</td>
                </tr>
                <tr>
                    <td>Fuerza:</td>
                    <td>${lucha.ganador.fuerza}</td>
                </tr>
                <tr>
                    <td>Experiencia:</td>
                    <td>${lucha.ganador.experiencia}</td>
                </tr>
                <tr>
                    <td>Foto:</td>
                    <td><img alt="" src="fotos/${lucha.ganador.foto}" style="max-width:200px;max-height:200px;"></td>
                </tr>
                <tr>
                    <td>Arma:</td>
                    <td>${lucha.ganador.arma.nombre}, ${lucha.ganador.arma.capacidad_danio}</td>
                </tr>
                <tr>
                    <td>Escudo:</td>
                    <td>${lucha.ganador.escudo.nombre}, ${lucha.ganador.escudo.capacidad_defensa}</td>
                </tr>
            </table>
        </div>
     <a href="Index_caballero" class="btn btn-primary " title="Volver"> 
	        
	    </a>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</html>