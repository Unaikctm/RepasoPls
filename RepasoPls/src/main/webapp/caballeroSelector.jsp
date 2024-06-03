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
  <div class="container">
    <h1 class="mt-5">Lucha</h1>
    <form action="SeleccionaCaballero" method="POST">
      <table class="table mt-3">
        <thead class="thead-dark">
          <tr>
            <th scope="col">Seleccionar</th>
            <th scope="col">ID</th>
            <th scope="col">Nombre</th>
            <th scope="col">Fuerza</th>
            <th scope="col">Experiencia</th>
            <th scope="col">Foto</th>
            <th scope="col">Arma</th>
            <th scope="col">Escudo</th>
          </tr>
        </thead>
        <tbody>
          <!-- Aquí se itera sobre los caballeros -->
          <c:forEach items="${caballeros}" var="caballero">
            <tr>
              <td>
                <input type="radio" name="caballero" value="${caballero.id}">
              </td>
              <td>${caballero.id}</td>
              <td>${caballero.nombre}</td>
              <td>${caballero.fuerza}</td>
              <td>${caballero.experiencia}</td>
              <td>${caballero.foto}</td>
              <td>${caballero.arma.nombre}, ${caballero.arma.capacidad_danio}</td>
              <td>${caballero.escudo.nombre}, ${caballero.escudo.capacidad_defensa}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <button type="submit" class="btn btn-primary mt-3">Seleccionar Caballero</button>
    </form>
  </div>

  <!-- Agregar Bootstrap JS (opcional, solo si necesitas funcionalidades de Bootstrap) -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>