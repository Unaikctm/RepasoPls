<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show caballero</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.8.1/font/bootstrap-icons.css" rel="stylesheet">
    
</head>
<body>      
    <div class="container">
        <h1 class="mt-5 mb-4">Caballero</h1>
          <div class="table-responsive">
            <table class="table table-bordered ">
              <thead class="thead-dark">
                <tr>
                      <th scope="row">ID</th>
                      <td>${caballero.id}</td>
                </tr>
                <tr>
                      <th scope="row">Nombre</th>
                      <td>${caballero.nombre}</td>
                </tr>
                <tr>
                	<th scope="row">Fuerza</th>
                    <td>
	                    <div class="progress" role="progressbar" aria-label="Basic example" aria-valuenow="${caballero.fuerza}" aria-valuemin="0" aria-valuemax="100">
							<div class="progress-bar" style="width: ${caballero.fuerza}%"></div>
						</div>
					</td>
                </tr>
                <tr>
                      <th scope="row">Experiencia</th>
                      <td>
                        <div class="progress" role="progressbar" aria-label="Basic example" aria-valuenow="${caballero.experiencia}" aria-valuemin="0" aria-valuemax="100">
							<div class="progress-bar" style="width: ${caballero.experiencia}%"></div>
						</div>
					  </td>
                </tr>
                <tr>
                      <th scope="row">Foto</th>
                      <td>
                      	<img alt="" src="fotos/${caballero.foto}" style="max-width:200px;max-height:200px;">
					  </td>
                </tr>
                <tr>
                      <th scope="row">Arma</th>
                      <td>${caballero.arma.nombre}, ${caballero.arma.capacidad_danio}</td>
                </tr>
                <tr>
                      <th scope="row">Escudo</th>
                      <td>${caballero.escudo.nombre}, ${caballero.escudo.capacidad_defensa}</td>
                </tr>
            </table>
            
         </div>
         <a href="javascript:history.back()" class="btn btn-success text-decoration-none">
                <i class="bi bi-arrow-left-circle text-white"></i>
           </a>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>