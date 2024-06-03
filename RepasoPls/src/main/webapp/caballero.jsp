<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Caballeros</title> <!-- Agregar Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <c:if test="${param.msg == 'fail'}">
        <div class="alert alert-danger alert-dismissible fade show m-0" role="alert">
            <strong>Error:</strong> Se ha cancelado la solicitud.
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
  </c:if>
  
  <c:if test="${param.msg == 'okay'}">
        <div class="alert alert-success alert-dismissible fade show m-0" role="alert">
            <strong>Ok!</strong> operación realizada.
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
  </c:if>
  
  <div class="container">
  <h4>Buscador</h4>
	<form action="Index_caballero" method="POST" class="form-inline">
	  <input type="text" class="form-control mr-2" id="string" name="string" placeholder="Buscar...">
	  <button type="submit" class="btn btn-primary">Buscar</button>
	</form>
	<form action="DeleteCaballeros" method="POST" class="form-inline">
	  <input type="text" class="form-control mr-2" id="borrar" name="borrar" placeholder="(id caballero1, id caballero2,...)">
	  <button type="submit" class="btn btn-primary">Borrar</button>
	</form>
    <h1 class="mt-5">Caballeros</h1>
    <a href="Form_caballero">Insertar caballero</a>
    <a href="Index_lucha" class="ml-3">Crear luchas</a>
    <a href="Ver_luchas" class="ml-3">Ver luchas</a>
    <table class="table mt-3">
      <thead class="thead-dark">
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Nombre</th>
          <th scope="col">Fuerza</th>
          <th scope="col">Experiencia</th>
          <th scope="col">Foto</th>
          <th scope="col">Arma</th>
          <th scope="col">Escudo</th>
          <th scope="col">Visualizar</th>
        </tr>
      </thead>
      <tbody>
        <!-- Aquí se itera sobre los caballeros -->
        <c:forEach items="${caballeros}" var="caballero">
          <tr>
            <td>${caballero.id}</td>
            <td>${caballero.nombre}</td>
            <td>${caballero.fuerza}</td>
            <td>${caballero.experiencia}</td>
            <td>${caballero.foto}</td>
            <td>${caballero.arma.nombre}, ${caballero.arma.capacidad_danio}</td>
            <td>${caballero.escudo.nombre}, ${caballero.escudo.capacidad_defensa}</td>
          	<td>
        	<!-- Botón para mostrar cliente -->
	        <a href="ShowCaballero?id=${caballero.id}" class="btn btn-primary " title="Visualizar Cliente"> 
	            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
	                <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8M1.173 8a13 13 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5s3.879 1.168 5.168 2.457A13 13 0 0 1 14.828 8q-.086.13-.195.288c-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5s-3.879-1.168-5.168-2.457A13 13 0 0 1 1.172 8z" />
	                <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5M4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0" />
	            </svg>
	        </a>
	        <!-- Botón para mostrar cliente -->
	        <a href="EditarCaballero?id=${caballero.id}">Editar caballero</a>
        	</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

  <!-- Agregar Bootstrap JS (opcional, solo si necesitas funcionalidades de Bootstrap) -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>