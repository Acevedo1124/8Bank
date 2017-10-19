<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Usuarios</title>
<script type="text/javascript">

//Función que se ejecuta al cargar la pàgina, cambia la url en la barra de direcciones, 
//con el fin de que no se repitan operaciones sobre la base datos al recargar la pàgina
window.onload = function(){
	history.replaceState({}, "page", "ControlUser?action=Listar");
	
};

//Funciòn que se ejecuta al darle al botón filtrar o al darle enter dentro de los textbox de filtro
//redirige al control con los parámetros del filtro de busqueda
function FiltrarUsuario(){
	var url = "ControlUser?FilterIdentificacion=" + document.getElementById("FilterIdentificacion").value
			+ "&FilterNombre=" +document.getElementById("FilterNombre").value
			+ "&accion=Filtrar";
	location.href = url;
			
	
}

</script>
</head>
<body>
<div></div>
	<h1>Listado de Usuarios</h1>
	<h3>${resultado}</h3>
	<input type="button" style="heigth:2em;" value="Agregar un registro" onclick="location.href='View/AddUser.jsp'"/>
	<br/><br/>
	<input type="text" id="FilterIdentificacion" placeholder="Filtrar por identificacion " onkeyup="if (event.keyCode == 13)FiltrarUsuario()"/>
	<input type="text" id="FilterNombre" placeholder="Filtrar por Nombre" onkeyup="if (event.keyCode == 13)FiltrarUsuario()"/>
	<input type="button" style="heigth:2em;" value="Filtrar" onclick="FiltrarUsuario()"/>
	<table border="1" width="100%" style="margin-top:1em">
		<tr>
		 <td><strong>Identificacion</strong></td>
		 <td><strong>Nombre</strong></td>
		 <td><strong>Primer apellido</strong></td>
		 <td><strong>Segundo apellido</strong></td>
		 <td><strong>Mail</strong></td>
		 <td><strong>Telefono</strong></td>
		 <td><strong>Usuario</strong></td>
		 <td><strong>Estado</strong></td>
		 <td><strong>Id ciudad</strong></td>
		</tr>
		<c:forEach var="us" items="${lista}">
			<tr>
				<td><c:out value="${us.Identificacion}"/></td>
				<td><c:out value="${us.Nombre}"/></td>
				<td><c:out value="${us.Primer_apellido}"/></td>
				<td><c:out value="${us.Segundo_apeliido}"/></td>
				<td><c:out value="${us.Mail}"/></td>
				<td><c:out value="${us.Telefono}"/></td>
				<td><c:out value="${us.Usuario}"/></td>
				<td><c:out value="${us.Estado}"/></td>
				<td><c:out value="${us.tb_Ciuadades_idtb_Ciuadades}"/></td>
				<td><a href="ControlUser?action=Modificar&id=${us.Identificacion}">Editar </a> </td>

			</tr>
		</c:forEach>
	</table>
	<br><br>
	<input type="button" style="heigth:2em;" value="Volver" onclick="location.href='View/UserAdmin.jsp'"/>
</body>
</html>