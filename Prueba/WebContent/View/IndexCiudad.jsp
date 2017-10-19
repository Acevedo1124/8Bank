<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ciudades</title>
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


<script type="text/javascript">

window.onload = function(){
	history.replaceState({}, "page", "/Prueba/View/IndexCiudad.jsp");	
	
};

function BuscarCiu(){
	var url = "../ControlCiudades?Ciu="+ document.getElementById("Ciudad").value ;
	location.href = url;
}
</script>
<input type="text" id="Ciudad" />
<input type="button" style="heigth:2em;" value="Buscar" onclick="BuscarCiu()"/>


<div id="cabecera">
	<img id="logo" src="/Prueba/Img/rocket-icon.png"/>
	<input type="button" style="heigth:2em;" value="${Respuesta}"  />
	
</div>
<input type="button" style="heigth:2em;" value="Crud Ciudades"  onclick="location.href = '../ControlCiudades?action=Listar'" />
</body>

</html>