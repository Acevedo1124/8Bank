<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>8 Back</title>
	<!-- Incluyen los archivos de css -->
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="../css/estilos.css">

</head>
<body>

	<header  > <!-- Encabezado -->
		<div class="container">
			<div class="col-md-2">
				img
				<img src="img/logo.jpg"  width="130" alt="" class="img-responsive  img-circle">				
			</div>
			<div class="col-md-4">
				<h1>

					<div class="row">Bienvenido <a id="nombre" value="${nombre}"></a></div>
				</h1>
			</div>
			
		</div>
		
	</header>

	<div class="conatiner">
		
		
		<div class="col-md-3">
			<button id="btn_user" class="btn btn-success " onclick="crud_user()" >Usuarios</button><br>
			<button id="btn_cuidad" class="btn btn-success " onclick="crud_ciudad()" >Ciudad</button><br>
			<button id="btn_rol" class="btn btn-success " onclick="crud_rol()" >Roles</button><br>


		</div>
		<div class="col-md-9">	
			<h2>	
				<div class="col-md-9" style="display:none" id="Ver_user"><h1>Ver user</h1></div>
				<div class="col-md-9" style="display:none" id="Ver_ciudad"><h1>Ver Ver_ciudad</h1></div>
				<div class="col-md-9" style="display:none" id="Ver_rol"><h1>Ver rol</h1></div>
			</h2>
		</div>
	</div>

	<script type="text/javascript">
		function ocultar() {


			
			document.getElementById("Ver_user").style.display = "none";
			document.getElementById("Ver_ciudad").style.display = "none";
			document.getElementById("Ver_rol").style.display = "none";


		}


		function crud_user(){
			ocultar();
			document.getElementById("Ver_user").style.display = "block";



		}

		function crud_ciudad(){
			ocultar();
			document.getElementById("Ver_ciudad").style.display = "block";

		}

		function crud_rol(){
			ocultar();
			document.getElementById("Ver_rol").style.display = "block";

		}

	</script>

	
	
	
	
	

	

	<!-- Incluyen los archivos js	 -->
	<script src="//code.jquery.com/jquery-latest.js"></script> 
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/ventanas.js"></script>
</body>
</html>