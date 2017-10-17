
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Rol</title>
</head>
<body>
<div></div>
	<h1>Lista ROl</h1>
	<table border="1" width="100%">
		<tr>
		 <td>ID</td>
		 <td>NOMBRE</td>
		 <td>DESCRPICION</td>
		</tr>
		<c:forEach var="rol" items="${lista}">
			<tr>
				<td><c:out value="${articulo.id}"/></td>
				<td><c:out value="${articulo.nombre}"/></td>
				<td><c:out value="${articulo.descripcion}"/></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>