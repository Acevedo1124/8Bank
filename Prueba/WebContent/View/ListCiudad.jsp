
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Ciudades</title>
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
<div></div>
	<h1>Lista Ciudades</h1>
	<h3>${resultado}</h3>
	<input type="button" style="heigth:2em;" value="Agregar ciudad" onclick="location.href='View/AddCiudad.jsp'"/>
	<br/><br/>
	<label>Nombre</label>
	<input type="text" id="FilterNombre" placeholder="filtrar por nombre" onkeyup="if (event.keyCode == 13)FiltrarCiudad()"/>
	<label>Departamento</label>
	<input type="text" id="FilterDepartamento" placeholder="filtrar por departamento" onkeyup="if (event.keyCode == 13)FiltrarCiudad()"/>
	<input type="button" style="heigth:2em;" value="Filtrar" onclick="FiltrarCiudad()"/>
	<table border="1" width="100%" style="margin-top:1em">
		<tr>
		 <td><strong>Id</strong></td>
		 <td><strong>Nombre</strong></td>
		 <td><strong>Departamento</strong></td>
		 <td colspan="2"><strong> </strong></td>
		</tr>
		<c:forEach var="ciudad" items="${lista}">
			<tr>
				<td><c:out value="${ciudad.id_ciudad}"/></td>
				<td><c:out value="${ciudad.nombre}"/></td>
				<td><c:out value="${ciudad.id_departamento}"/></td>
				<td><input type="button" value="Editar" onclick="ModificarCiudad(${ciudad.id_ciudad});"/></td>
				<td><input type="button" value="Eliminar" onclick="EliminarCiudad(${ciudad.id_ciudad});"/></td>
				<!-- <td><a href="#">Editar </a> </td> -->			
				<!-- <td><a href="#">Borrar</a> </td> -->
			</tr>
		</c:forEach>
	</table>
	<br><br>	
	<input type="button" style="heigth:2em;" value="Volver" onclick="location.href='View/IndexCiudad.jsp'"/>
</body>
</html>