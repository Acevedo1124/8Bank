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

window.onload = function(){
	history.replaceState({}, "page", "ControlCiudades?action=Listar");	
};

function ModificarCiudad(){
	
	var validar=/[A-Za-z\s\.\,]/;
	var valnum = /[0-9]/
	var Validacion;
	if (validar.test(document.getElementById("txtNombre").value) && valnum.test(document.getElementById("txtDepartamento").value)){
		Validacion=1;
	}
	else{
	alert("!Todos os campos son requeridos!")
	Validacion = 0;
	}
	if (Validacion ==0 || document.getElementById("txtNombre").value == "" || document.getElementById("txtDepartamento").value == ""){
				
		if(document.getElementById("txtNombre").value == "")
			document.getElementById("txtNombre").style.borderColor = "Red";
		else
			document.getElementById("txtNombre").style.borderColor = "Green";
		
		if(document.getElementById("txtDepartamento").value == "")
			document.getElementById("txtDepartamento").style.borderColor = "Red";
		else
			document.getElementById("txtDepartamento").style.borderColor = "Green";
	}
	else{
		var url = "ControlCiudades?txtId=" + document.getElementById("txtId").value
		+ "&txtNombre=" +document.getElementById("txtNombre").value
		+ "&txtDepartamento=" +document.getElementById("txtDepartamento").value
		+ "&action=Modificar";
		location.href = url;
	}	
	
		
}
</script>

	<h1>Modificar Ciudades</h1>
		<h3>${resultado}</h3>	
<input type="hidden" id="txtId" style="margin: 1em; 
width: 159px; height: 31px;" placeholder="Codigo" value="${IdCiudad}">
<br/>	
<label>Nombre</label><br/>		
<input type="text" id="txtNombre" style="margin: 1em; 
width: 159px; height: 31px;" placeholder="Nombre" value="${nombre}">
<br/>
<label>Codigo del departamento</label><br/>	
<input type="text" id="txtDepartamento" style="margin: 1em; 
width: 159px; height: 31px;" placeholder="Departamento" value="${id_departamento}">
<br/>
<button value="modificar" style="margin: 1em;" onclick="ModificarCiudad()">Guardar</button>
<input type="button" style="heigth:1em;" value="Volver"  onclick="location.href = 'ControlCiudades?action=Listar'" />
</body>
</html>