<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lucha</title> <!-- Agregar Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="container">
    <h1 class="mt-5">Lucha<a href="javascript:history.back()" class="btn btn-success text-decoration-none">
	    Atras
	</a></h1>
    
    <table class="table mt-3">
      <thead class="thead-dark">
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Fecha</th>
          <th scope="col">Caballero 1</th>
          <th scope="col">Caballero 2</th>
          <th scope="col">Ganador</th>
        </tr>
      </thead>
      <tbody>
        <!-- Aquí se itera sobre los caballeros -->
        <c:forEach items="${luchas}" var="lucha">
          <tr>
            <td>${lucha.id}</td>
            <td>
            <fmt:formatDate value="${lucha.fecha}" pattern="dd/MM/yyyy"/>
            </td>
            <td>${lucha.caballero1.nombre} <img alt="" src="fotos/${lucha.caballero1.foto}" style="max-width:200px;max-height:200px;"></td>
            <td>${lucha.caballero2.nombre} <img alt="" src="fotos/${lucha.caballero2.foto}" style="max-width:200px;max-height:200px;"></td>
            <td>${lucha.ganador.nombre} <img alt="" src="fotos/${lucha.ganador.foto}" style="max-width:200px;max-height:200px;"></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

  <!-- Agregar Bootstrap JS (opcional, solo si necesitas funcionalidades de Bootstrap) -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>