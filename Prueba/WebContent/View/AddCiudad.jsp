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

function GuardarCiudad(){
	
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
		var url = "../ControlCiudades?txtNombre=" +document.getElementById("txtNombre").value
		+ "&txtDepartamento=" +document.getElementById("txtDepartamento").value
		+ "&action=Guardar";
		location.href = url;
	}		
		
}


</script>
	<h1>Agregar Ciudades</h1>
		<h3>${resultado}</h3>
	
<label>Nombre</label><br/>		
<input type="text" id="txtNombre" style="margin: 1em; 
width: 159px; height: 31px;" placeholder="Nombre">
<br/>
<label>Codigo del departamento</label><br/>	
<input type="text" id="txtDepartamento" style="margin: 1em; 
width: 159px; height: 31px;" placeholder="Departamento">
<select>
  <option value="0">Seleccionar</option>
  <option value="${IdDepar}">${nombre}</option>
</select>
<br/>
<button value="guardar" style="margin: 1em;" onclick="GuardarCiudad()">Guardar</button>
<input type="button" style="heigth:2em;" value="Volver"  onclick="location.href = '../ControlCiudades?action=Listar'" />

</body>
</html>