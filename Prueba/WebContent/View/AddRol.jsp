<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../css/estilos.css">

<title>Agregar Rol</title>
</head>
<body>
<script type="text/javascript">
function GuardarRol(){
	var validar=/[A-Za-z\s\.\,]/;
	var Validacion;
	if (validar.test(document.getElementById("txtNombre").value) && validar.test(document.getElementById("txtDescripcion").value)){
		Validacion=1;
	}
	else{
	alert("!Por favor introduce texto en los campos!")
	Validacion = 0;
	}
	if (Validacion ==0 || document.getElementById("txtNombre").value == "" || document.getElementById("txtDescripcion").value == ""){
		if(document.getElementById("txtNombre").value == "")
		document.getElementById("txtNombre").style.borderColor = "Red";
		if(document.getElementById("txtDescripcion").value == "")
		document.getElementById("txtDescripcion").style.borderColor = "Red";
	}
	else{
	var url = "/Prueba/ControlRol?txtNombre=" + encodeURIComponent(document.getElementById("txtNombre").value)
			+ "&txtDescripcion=" +encodeURIComponent(document.getElementById("txtDescripcion").value)
			+ "&action=Guardar";
	location.href = url;
	}
}
</script>
<header> <!-- Encabezado -->
		<div class="container">
		<div class="row">
			<div class="col-md-2">
				img
				<img src="img/logo.jpg"  width="130" alt="" class="img-responsive  img-circle">				
			</div>
			<div class="col-md-4">
                   <a id="nombre" value="${nombre}">Bienvenido</a>
		  </div>
			</div>
		</div>
</header>
	<h1>Agregar Rol</h1>
		<h3>${resultado}</h3>
<input type="text" id="txtNombre" style="margin: 1em; 
width: 159px; height: 31px;" placeholder="Nombre" required="required">
<br/>	
<textarea id="txtDescripcion" style="margin: 1em; width: 159px; height: 31px;" cols="30" rows="1" style="" placeholder="Descripción" required="required"></textarea>
<br>
<input type="submit" value="Guardar" style="margin: 1em;" onclick="GuardarRol()"/>

	<!-- Incluyen los archivos js	 -->
<script src="//code.jquery.com/jquery-latest.js"></script> 
<script src="js/bootstrap.min.js"></script>
<script src="js/ventanas.js"></script>
</body>
</html>