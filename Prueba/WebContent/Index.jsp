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

				<div class="row">texto  otro</div>
				</h1>
			</div>
			<div class="col-md-6">
				<br>
				<form class="form-inline" id="login" onsubmit="return pasarvariable();" >
					<div class="form-group">
						<label for="nombre" class="sr-only">Usuario:</label>
						<input type="text" id="Usuario" placeholder="Usuario:"  class="form-control" required>
					</div>
					<div class="input-group">
						<label for="correo" class="sr-only">Contraseña:</label>
						
						<input type="password" id="password" placeholder="Contraseña:" class="form-control" required>
					</div>
					
					<button id="login" class="btn btn-success " onclick="pasarvariable()">Login</button>	
					<i class="fa fa-refresh fa-spin"></i>
									
			</div>
		</div>
		
	</header>

		
	
	
	<br><br>	
	<marquee scrollamount="10" scrolldelay="100" >
		<div id="img">
			 
		</div>
	</marquee>

	<div class="row">
		<div id="respuesta" class="container">
		<span></span>
			
		</div>
	</div>

	<!-- Incluyen los archivos js	 -->
	<script src="//code.jquery.com/jquery-latest.js"></script> 
	<script src="js/bootstrap.min.js"></script>
	<script src="js/ventanas.js"></script>
</body>
</html>