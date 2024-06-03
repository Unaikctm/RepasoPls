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
  	<div class="container mt-5">
	    <h2>Formulario de Personaje</h2>
	    <form action="Store_caballero" method="POST" enctype="multipart/form-data">
	      	<div class="form-group">
	        	<label for="nombre">Nombre</label>
	        	<input type="text" class="form-control" id="nombre" name="nombre" value="${caballero.nombre}">
	      	</div>
	      	<div class="form-group">
	        	<label for="fuerza">Fuerza</label>
	        	<input type="number" class="form-control" id="fuerza" name="fuerza" value="${caballero.fuerza}">
	     	</div>
	      	<div class="form-group">
	       		<label for="experiencia">Experiencia</label>
	        	<input type="number" class="form-control" id="experiencia" name="experiencia" value="${caballero.experiencia}">
	      	</div>
	      	<div class="form-group">
	        	<label for="foto">Foto</label>
	        	<input type="file" class="form-control" id="foto" name="foto" value="${caballero.foto}">
	      	</div>
	      	<div class="form-group">
	        	<label for="arma">Arma</label>
	        	<select class="form-control" id="arma" name="arma_id">
	          		<option value=0></option>
	          		<c:forEach items="${armas}" var="arma">
	          			<option value="${arma.id}">${arma.nombre}</option>
	          		</c:forEach>
	        	</select>
	      	</div>
	      	<div class="form-group">
	        	<label for="escudo">Escudo</label>
	        	<select class="form-control" id="escudo" name="escudo_id">
	        	<option value=0></option>
	          		<c:forEach items="${escudos}" var="escudo">
	          			<option value="${escudo.id}">${escudo.nombre}</option>
	          		</c:forEach>
	        	</select>
	      	</div>
	      	<button type="submit" class="btn btn-primary">Enviar</button>
	    </form>
  	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>