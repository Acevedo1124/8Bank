<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>8 Back</title>
	<!-- Incluyen los archivos de css -->
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/estilos.css">

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
	<div class="col-md-3">
	<button id="btn_user" class="btn btn-success " onclick="crud_user()" >Usuarios</button><br>
	<button id="btn_cuidad" class="btn btn-success " onclick="crud_ciudad()" >Ciudad</button><br>
	<button id="btn_rol" class="btn btn-success " onclick="crud_rol()" >Roles</button><br>
	
	
	</div>
	<div class="col-md-9"></div>>

		
	
	
	
	
	

	

	<!-- Incluyen los archivos js	 -->
	<script src="//code.jquery.com/jquery-latest.js"></script> 
	<script src="js/bootstrap.min.js"></script>
	<script src="js/ventanas.js"></script>
</body>
</html>