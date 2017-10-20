<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/estilos.css">
<title>Agregar Ciudades</title>
</head>
<body>
<header  > <!-- Encabezado -->
		<div class="container">
			<div class="col-md-2">
				<img src="Img/G8.jpg" class="img-rounded"  width="100%" >								
			</div>
			<div class="col-md-4">
				<h1>
					<div class="row">Modificar Ciudades</div>
				</h1>
			</div>			
			
		</div>			
	</header>
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

	<div class="container">
		<h3>${resultado}</h3>	
		<div class="form-inline" >
			<div class="form-horizontal">
<input type="hidden" id="txtId" style="margin: 1em; 
width: 159px; height: 31px;" placeholder="Codigo" value="${IdCiudad}">
<br/>	
<label class="control-label col-md-2">Nombre</label><br/>
<div class="col-md-10">		
	<input type="text" id="txtNombre" class="form-control" placeholder="Nombre" value="${nombre}">
</div>
<br/>
<label class="control-label col-md-2">Codigo del departamento</label><br/>
<div class="col-md-10">		
<select id="txtDepartamento" class="form-control">
							<option value="0" selected>Departamentos</option>
							<c:forEach items="${Dpto}" var="Dep">
							<c:if test="${Dep != selected}">
							<option value="${Dep.idDpto}">${Dep.nombreDpto}</option>
						</c:if>
					</c:forEach>
				</select>
		</div>
	
	
<br/>
<br/>
<button value="modificar" class="btn btn-primary" onclick="ModificarCiudad()">Guardar</button>
<input type="button" class="btn btn-primary" value="Volver"  onclick="location.href = 'ControlCiudades?action=Listar'" />
</div>
</div>
</div>
</body>
</html>