<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
	
	<title>BIENVENIDO A GRUPO 8BANK</title>
	<!-- Incluyen los archivos de css -->
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/estilos.css">

</head>
<body>
	<header  > <!-- Encabezado -->
		<div class="container">
			<div class="col-md-2">
				<img src="Img/G8.jpg" class="img-rounded"  width="100%" >								
			</div>
			<div class="col-md-4">
				<h1>
					<div class="row"> Bienvenido</div>
				</h1>
			</div>
			<div class="col-md-6"><br>				
				<div class="form-inline" >
					<div class="form-group">
						<label for="nombre" class="sr-only">Usuario:</label>
						<input type="text" id="Usuario" placeholder="Usuario:"  class="form-control" required>
					</div>
					<div class="input-group">
						<label for="correo" class="sr-only">Contraseña:</label>
						
						<input type="password" id="password" placeholder="Contraseña:" class="form-control" required>
				</div>					
				<button id="login" class="btn btn-success " onclick="pasarvariable()" >Login</button>	
				<i class="fa fa-refresh fa-spin"></i>
			</div>
			<h3 >${Respuesta}</h3>				
			</div>
		</div>		
	</header>
	<div class="container">
		<img src="Img/fondo.jpg" class="img-rounded"  width="100%" >
	</div>

	<!-- Incluyen los archivos js	 -->
	<script src="//code.jquery.com/jquery-latest.js"></script> 
	<script src="js/bootstrap.min.js"></script>
	<script src="js/ventanas.js"></script>
</body>
</html>