
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista Ciudades</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/estilos.css">


	<script type="text/javascript">

		window.onload = function(){
			history.replaceState({}, "page", "ControlCiudades?action=Listar");	
		};

		function FiltrarCiudad(){
			var url = "ControlCiudades?FilterNombre=" + document.getElementById("FilterNombre").value
			+ "&FilterDepartamento=" +document.getElementById("FilterDepartamento").value
			+ "&action=Filtrar";
			location.href = url;	
		}

		function ModificarCiudad(id){
			var url = "ControlCiudades?FilterId=" + id
			+ "&action=ModificarXid";
			location.href = url;	
		}

		function EliminarCiudad(id){
			var con = confirm("Esta seguro que quiere eliminar");
			if(con == true){
				var url = "ControlCiudades?Id=" + id
				+ "&action=Eliminar";
				location.href = url;
			}

		}

	</script>
</head>
<body>
	<header > <!-- Encabezado -->
		<div class="container">
			<div class="col-md-2">
				<img src="Img/G8.jpg" class="img-rounded"  width="100%" >								
			</div>
			<div class="col-md-4">
				<h1>
					<div class="row">Lista Ciudades</div>
				</h1>
			</div>		
		</div>			
	</header>

	<div class="container">
		<h3>${resultado}</h3>

		<input type="button" class="btn btn-primary" value="Agregar ciudad" onclick="location.href='ControlCiudades?action=GuardarNuevo'"/>
		<br/><br/>

		<div class="form-inline" >
			<div class="form-group">
				<label class="control-label col-md-2">Nombre</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="FilterNombre" placeholder="filtrar por nombre" onkeyup="if (event.keyCode == 13)FiltrarCiudad()"/>
				</div>
				<label class="control-label col-md-2">Departamento</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="FilterDepartamento" placeholder="filtrar por departamento" onkeyup="if (event.keyCode == 13)FiltrarCiudad()"/>
				</div>
			</div>
			
				<div class="col-md-2 col-md-offset-2">
					<input type="button" class="btn btn-primary" value="Filtrar" onclick="FiltrarCiudad()"/>
				</div>
			
			<div class="container">
				<div class="table-reponsive">
					<table class="table table-striped">
						<tr class="success">
							<td><strong>Id</strong></td>
							<td><strong>Nombre</strong></td>
							<td><strong>Departamento</strong></td>
							<td colspan="2"><strong>Acciones </strong></td>
						</tr>
						<c:forEach var="ciudad" items="${lista}">
						<tr>
							<td><c:out value="${ciudad.id_ciudad}"/></td>
							<td><c:out value="${ciudad.nombre}"/></td>
							<td><c:out value="${ciudad.id_departamento}"/></td>
							<td><a style="color:blue;cursor:pointer" onclick="ModificarCiudad(${ciudad.id_ciudad});">Editar</a></td>
							<td><a style="color:blue;cursor:pointer" onclick="EliminarCiudad(${ciudad.id_ciudad});">Eliminar</a></td>

						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<br><br>	
		<input type="button" class="btn btn-primary" value="Volver" onclick="location.href='View/UserAdmin.jsp'"/>
	</body>
	</html>