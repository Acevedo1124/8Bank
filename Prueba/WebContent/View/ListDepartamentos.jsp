
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista Departamentos</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/estilos.css">
	<script type="text/javascript">

//Funci�n que se ejecuta al cargar la p�gina, cambia la url en la barra de direcciones, 
//con el fin de que no se repitan operaciones sobre la base datos al recargar la p�gina
window.onload = function(){
	history.replaceState({}, "page", "ControlDepartamentos?action=Listar");
	
}; 	

//Funci�n que se ejecuta al darle al bot�n filtrar o al darle enter dentro de los textbox de filtro
//redirige al control con los par�metros del filtro de busqueda
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
					<div class="row">Lista Departamentos</div>
				</h1>
			</div>		
		</div>			
	</header>
	<div class="container">


		
		<h1>Lista Departamentos</h1>
		<h3>${resultado}</h3>
		<input type="button" class="btn btn-primary" value="Agregar registro" onclick="location.href='View/AddDepartamentos.jsp'"/>
		<br/><br/>
		<div class="form-inline" >
			<div class="form-group">
				<input type="text" class="form-control" id="FilterID" placeholder="filtrar por id " onkeyup="if (event.keyCode == 13)FiltrarRol()"/>
				<input type="text" class="form-control" id="FilterNombre" placeholder="filtrar por nombre" onkeyup="if (event.keyCode == 13)FiltrarRol()"/>
				<input type="button"  class="btn btn-primary" value="Filtrar" onclick="#"/>
			</div>		
		</div>


		<div class="container">
			<div class="table-reponsive">
				<table class="table table-striped">
					<tr class="success">
						
						<td><strong>ID</strong></td>
						<td><strong>NOMBRE</strong></td>

					</tr>
					<c:forEach var="Departamentos" items="${lista}">
					<tr>
						<td><c:out value="${Departamentos.idDpto}"/></td>
						<td><c:out value="${Departamentos.nombreDpto}"/></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<br><br>
	<input type="button" class="btn btn-primary" value="Volver" onclick="location.href='View/UserAdmin.jsp'"/>
</body>
</html>