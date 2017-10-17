<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="ServletCiudad" method="post">
	<label>Codigo</label>
	<input type="text" id="txtId">
	<label>Nombre</label>
	<input type="text" id="txtNombre">
	<label>Identificación</label>
	<input type="text" id="txtIdentificacion">
	<label>Departamento</label>
	<input type="text" id="txtDepartamento">
	
	<input type="button" value="Enviar">
</form>

</body>
</html>