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
	<header  > <!-- Encabezado -->
		<div class="container">
			<div class="col-md-2">
				<img src="Img/G8.jpg" class="img-rounded"  width="100%" >								
			</div>
			<div class="col-md-4">
				<h1>
					<div class="row">Agregar Roles</div>
				</h1>
			</div>		
		</div>			
	</header>
	
		<h3>${resultado}</h3>
	<div class="container"> 
		<div action="" class="form-horizontal">
			<div class="form-group">
			
				<label for="nombre" class="control-label col-md-2">Digite nombre:</label>			
				<div class="col-md-10">
					<input type="text" id="txtNombre" class="form-control" placeholder="Nombre" required="required">
				</div>
				
				<label for="nombre" class="control-label col-md-2">Descripción:</label>
				<div class="col-md-10">
					<textarea id="txtDescripcion" class="form-control"   rows="3" placeholder="Descripción" required="required"></textarea>
				</div>
				
			</div>
			<br>
			
			<div class="form-gruop ">
				<div class="col-md-2 col-md-offset-2">
					<input type="submit" value="Guardar" class="btn btn-primary" onclick="GuardarRol()"/>
				</div>
			</div>
		</div>		
	</div>	

			




	<!-- Incluyen los archivos js	 -->
<script src="//code.jquery.com/jquery-latest.js"></script> 
<script src="js/bootstrap.min.js"></script>
<script src="js/ventanas.js"></script>
</body>
</html>