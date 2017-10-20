<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista Rol</title>
	<!-- Incluyen los archivos de css -->
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/estilos.css">

	<script type="text/javascript">

		//Función que se ejecuta al cargar la pàgina, cambia la url en la barra de direcciones, 
		//con el fin de que no se repitan operaciones sobre la base datos al recargar la pàgina
		window.onload = function(){
			history.replaceState({}, "page", "ControlRol?action=Listar");
	
		};
		
		//Funciòn que se ejecuta al darle al botón filtrar o al darle enter dentro de los textbox de filtro
		//redirige al control con los parámetros del filtro de busqueda
		function FiltrarRol(){
			var url = "ControlRol?FilterID=" + document.getElementById("FilterID").value
			+ "&FilterNombre=" +document.getElementById("FilterNombre").value
			+ "&action=Filtrar";
			location.href = url;
	
		}

	</script>
</head>
<body>
	<header  > <!-- Encabezado -->
		<div class="container">
			<div class="col-md-2">
				<img src="Img/G8.jpg" class="img-rounded"  width="100%" >								
			</div>
			<div class="col-md-4">
				<h1>
					<div class="row">Lista Roles</div>
				</h1>
			</div>		
		</div>			
	</header>
	<div class="container">
		<h3>${resultado}</h3>
		<input type="button" class="btn btn-primary" value="Agregar registro" onclick="location.href='View/AddRol.jsp'"/>
		<br/><br/>
		<div class="form-inline" >
			<div class="form-group">
				<input type="text" class="form-control" size="10" id="FilterID" placeholder="filtrar por id " onkeyup="if (event.keyCode == 13)FiltrarRol()"/>
				<input type="text" class="form-control" id="FilterNombre" placeholder="filtrar por nombre" onkeyup="if (event.keyCode == 13)FiltrarRol()"/>
				<input type="button"  class="btn btn-primary" value="Filtrar" onclick="FiltrarRol()"/>
			</div>
		</div>	


		<div class="container">
			<div class="table-reponsive">
				<table class="table table-striped">
					<tr class="success">
						<td><strong>ID</strong></td>
						<td><strong>NOMBRE</strong></td>
						<td><strong>DESCRPICION</strong></td>
						<td ><strong>ACCIONES</strong></td>
					</tr>
					<c:forEach var="rol" items="${lista}">
						<tr>
							<td><c:out value="${rol.id}"/></td>
							<td><c:out value="${rol.nombre}"/></td>
							<td><c:out value="${rol.descripcion}"/></td>
							<td><a style="color:blue" href="ControlRol?action=Modificar&id=${rol.id}">Editar </a> </td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	<br><br>
	<input type="button" class="btn btn-primary"  value="Volver" onclick="location.href='View/UserAdmin.jsp'"/>
</div>
<!-- Incluyen los archivos js	 -->
<script src="//code.jquery.com/jquery-latest.js"></script> 
<script src="js/bootstrap.min.js"></script>
<script src="js/ventanas.js"></script>
</body>
</html>