<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Ciudades</title>
</head>
<body>
<script type="text/javascript">
function GuardarCiudad(){
	var url = "../ControlCiudades?txtId=" + document.getElementById("txtId").value
			+ "&txtNombre=" +document.getElementById("txtNombre").value
			+ "&txtDepartamento=" +document.getElementById("txtDepartamento").value
			+ "&action=Guardar";
	location.href = url;
			
	
}
</script>
	<h1>Agregar Ciudades</h1>
		<h3>${resultado}</h3>
<label>Codigo</label><br/>		
<input type="text" id="txtId" style="margin: 1em; 
width: 159px; height: 31px;" placeholder="Codigo">
<br/>
<label>Nombre</label><br/>		
<input type="text" id="txtNombre" style="margin: 1em; 
width: 159px; height: 31px;" placeholder="Nombre">
<br/>
<label>Codigo del departamento</label><br/>	
<input type="text" id="txtDepartamento" style="margin: 1em; 
width: 159px; height: 31px;" placeholder="Departamento">
<br/>
<button value="guardar" style="margin: 1em;" onclick="GuardarCiudad()">Guardar</button>
<input type="button" style="heigth:2em;" value="Volver"  onclick="location.href = '../ControlCiudades?action=Listar'" />

</body>
</html>