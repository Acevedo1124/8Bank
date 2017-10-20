<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Listar usuarios</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/estilos.css">

	<script type="text/javascript">

		window.onload = function(){
			history.replaceState({}, "page", "ControlUser?accion=Listar");	
		};

			//Funciòn que se ejecuta al darle al botón filtrar o al darle enter dentro de los textbox de filtro
			//redirige al control con los parámetros del filtro de busqueda
			function Filtrarusuario(){
				if (!(/[0-9]/.test(document.getElementById("FilterIdentificacion").value)))
					document.getElementById("FilterIdentificacion").value = "";
				var url = "ControlUser?FilterIdentificacion=" + document.getElementById("FilterIdentificacion").value
				+ "&FilterNombre=" +document.getElementById("FilterNombre").value
				+ "&accion=Filtrar";
				location.href = url;
				
			}
			function EliminarUser(id){
				var con = confirm("Esta seguro que quiere eliminar");
				if(con == true){
					var url = "ControlUser?Id=" + id
					+ "&accion=Eliminar";
					location.href = url;
				}

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
						<div class="row">Listado de usuarios</div>
					</h1>
				</div>		
			</div>			
		</header>
		<div class="container">



			<div></div>
			<h1>Listado de usuarios</h1>
			<h3>${resultado}</h3>


			<input type="button" class="btn btn-primary" value="Agregar un registro" onclick="location.href='ControlUser?accion=Guardar'"/>
			<br/><br/>
			<div class="form-inline" >
				<div class="form-group">
					<input type="text" class="form-control" id="FilterIdentificacion" placeholder="Filtrar por identificacion " onkeyup="if (event.keyCode == 13)Filtrarusuario()"/>
					<input type="text" class="form-control" id="FilterNombre" placeholder="Filtrar por Nombre" onkeyup="if (event.keyCode == 13)Filtrarusuario()"/>
					<input type="button" class="btn btn-primary" value="Filtrar" onclick="Filtrarusuario()"/>
				</div>
			</div>	


			<div class="container">
				<div class="table-reponsive">
					<table class="table table-striped">
						<tr class="success">
							<td><strong>Identificacion</strong></td>
							<td><strong>Nombre</strong></td>
							<td><strong>Primer apellido</strong></td>
							<td><strong>Segundo apellido</strong></td>
							<td><strong>Mail</strong></td>
							<td><strong>Telefono</strong></td>
							<td><strong>usuario</strong></td>
							<td><strong>Estado</strong></td>
							<td><strong>Ciudad</strong></td>
							<td><strong>Rol</strong></td>
							<td colspan="2"><strong>Acciones</strong></td>
						</tr>
						<c:forEach var="usr" items="${lista}">

						<tr>
							<td><c:out value="${usr.getIdentificacion()}"/></td>
							<td><c:out value="${usr.getNombre()}"/></td>
							<td><c:out value="${usr.getPrimer_apellido()}"/></td>
							<td><c:out value="${usr.getSegundo_apellido()}"/></td>
							<td><c:out value="${usr.getMail()}"/></td>
							<td><c:out value="${usr.getTelefono()}"/></td>
							<td><c:out value="${usr.getUsuario()}"/></td>
							<td><c:out value="${usr.getEstado()}"/></td>
							<td><c:out value="${usr.getIdCiudades()}"/></td>
							<td><c:out value="${usr.getRol()}"/></td>
							<td><a style="color:blue" href="ControlUser?accion=Modificar&id=${usr.getIdentificacion()}">Editar </a> </td>
							<td><a style="color:blue;cursor:pointer;" onclick="EliminarUser(${usr.getIdentificacion()});">Eliminar</a></td>
								
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>	
		<br><br>
		<input type="button" class="btn btn-primary" value="Volver" onclick="location.href='View/UserAdmin.jsp'"/>
	</body>
	</html>