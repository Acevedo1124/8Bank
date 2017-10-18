
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Rol</title>
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
<div></div>
	<h1>Lista Rol</h1>
	<h3>${resultado}</h3>
	<input type="button" style="heigth:2em;" value="Agregar registro" onclick="location.href='AddRol.jsp'"/>
	<br/><br/>
	<input type="text" id="FilterID" placeholder="filtrar por id " onkeyup="if (event.keyCode == 13)FiltrarRol()"/>
	<input type="text" id="FilterNombre" placeholder="filtrar por nombre" onkeyup="if (event.keyCode == 13)FiltrarRol()"/>
	<input type="button" style="heigth:2em;" value="Filtrar" onclick="FiltrarRol()"/>
	<table border="1" width="100%" style="margin-top:1em">
		<tr>
		 <td><strong>ID</strong></td>
		 <td><strong>NOMBRE</strong></td>
		 <td><strong>DESCRPICION</strong></td>
		 <td colspan="2"><strong>ACCIONES</strong></td>
		</tr>
		<c:forEach var="rol" items="${lista}">
			<tr>
				<td><c:out value="${rol.id}"/></td>
				<td><c:out value="${rol.nombre}"/></td>
				<td><c:out value="${rol.descripcion}"/></td>
				<td><a href="#">Editar </a> </td>
				
				<td><a href="#">Borrar</a> </td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<input type="button" style="heigth:2em;" value="Volver" onclick="location.href='View/index.jsp'"/>
</body>
</html>