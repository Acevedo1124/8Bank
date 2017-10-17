<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prueba</title>
<script type="text/javascript">


</script>
</head>
<style>
	#cabecera{
		height:6em;
		background-color:lightgray;
		width:100%;
		display:table;
	}
	#logo{
		width:50px;
		height:50px;
	}
</style>
<body>
<div id="cabecera">
	<img id="logo" src="/Prueba/Img/rocket-icon.png"/>
</div><input type="button" style="heigth:2em;" value="${intento}" onclick="location.href('ControlPrueba')" />
</body>
</html>