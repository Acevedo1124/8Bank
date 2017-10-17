<%@page import="Model.CiudadDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>HTML Editor - Full Version</title>
</head>
<body>

 <%

  // Este es un scriplet. Dentro de un scriplet podemos tener lógica java
  // Utilizaremos el objeto predefinido "request", que representa el request que está llegando al JSP
  // Entonces recuperamos los datos que llegán en el request
  int vid = Integer.parseInt(request.getParameter("id"));
  String vnombre = request.getParameter("nombre");  
  int vidDepart = Integer.parseInt(request.getParameter("idDepart"));
  int videntificacion = Integer.parseInt(request.getParameter("identificacion"));
  CiudadDao ciudad = new CiudadDao();
  String resultado = ciudad.insertar_ciudad(vid, vnombre, vidDepart, videntificacion);
  
 %>


<h1>Bienvenido, los datos que has ingresado son:</h1>

<p>&nbsp;</p>

<form id="formulario1" method="get" name="Formulario1" >
<table border="0" cellpadding="1" cellspacing="1" style="width:500px;">
	<tbody>
		<tr>
			<td>Codigo</td>
			<td><%= vid  %></td>
		</tr>
		<tr>
			<td>Nombre</td>
			<td><%= vnombre %></td>
		</tr>
		<tr>
			<td>Codigo departamento</td>
			<td><%= vidDepart %></td>
		</tr>
		<tr>
			<td>Identificación</td>
			<td><%= videntificacion %></td>
		</tr>
	</tbody>
</table>

<p>&nbsp;</p>

<p><input name="Enviar" type="submit" value="Enviar" /></p>
</form>

<h1>El resultado es:</h1>

<p><%= resultado %></p>


<p>&nbsp;</p>
</body>
</html>