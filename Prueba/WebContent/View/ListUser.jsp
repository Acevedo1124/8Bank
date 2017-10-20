<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar usuarios</title>
<script type="text/javascript">

//Función que se ejecuta al cargar la pàgina, cambia la url en la barra de direcciones, 
//con el fin de que no se repitan operaciones sobre la base datos al recargar la pàgina
window.onload = function(){
	history.replaceState({}, "page", "ControlUser?accion=Listar");
	
};

//Funciòn que se ejecuta al darle al botón filtrar o al darle enter dentro de los textbox de filtro
//redirige al control con los parámetros del filtro de busqueda
function Filtrarusuario(){
	var url = "Controluser?FilterIdentificacion=" + document.getElementById("FilterIdentificacion").value
			+ "&FilterNombre=" +document.getElementById("FilterNombre").value
			+ "&accion=Filtrar";
	location.href = url;
			
	
}

</script>
</head>
<body>
<div></div>
	<h1>Listado de usuarios</h1>
	<h3>${resultado}</h3>
	<input type="button" style="heigth:2em;" value="Agregar un registro" onclick="location.href='ControlUser?accion=Guardar'"/>
	<br/><br/>
	<input type="text" id="FilterIdentificacion" placeholder="Filtrar por identificacion " onkeyup="if (event.keyCode == 13)Filtrarusuario()"/>
	<input type="text" id="FilterNombre" placeholder="Filtrar por Nombre" onkeyup="if (event.keyCode == 13)Filtrarusuario()"/>
	<input type="button" style="heigth:2em;" value="Filtrar" onclick="Filtrarusuario()"/>
	<table border="1" width="100%" style="margin-top:1em">
		<tr>
		 <td><strong>Identificacion</strong></td>
		 <td><strong>Nombre</strong></td>
		 <td><strong>Primer apellido</strong></td>
		 <td><strong>Segundo apellido</strong></td>
		 <td><strong>Mail</strong></td>
		 <td><strong>Telefono</strong></td>
		 <td><strong>usuario</strong></td>
		 <td><strong>Estado</strong></td>
		 <td><strong>Id ciudad</strong></td>
		 <td><strong>Id Rol</strong></td>
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
				<td><a href="ControlUser?accion=Modificar&id=${usr.getIdentificacion()}">Editar </a> </td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<input type="button" style="heigth:2em;" value="Volver" onclick="location.href='View/userAdmin.jsp'"/>
</body>
</html>