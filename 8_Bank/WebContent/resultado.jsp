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


<h1><%= resultado %></h1>

<p>&nbsp;</p>

<form id="formulario2" name="Formulario2" >

<p>&nbsp;</p>
<a href="RegistroCiudades.html"><input name="Volver" type="button" value="Ingresar nuevo" /></a>
</form>


<p>&nbsp;</p>
</body>
</html>