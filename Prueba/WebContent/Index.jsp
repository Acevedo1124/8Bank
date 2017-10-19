<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>BIENVENIDO A GRUPO 8BANK</title>
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
			<a href="Index.jsp" src="img/logo.png">home</a>
				<img src="img/logo.png"  width="130" alt="" class="img-responsive  img-circle">				
			</div>
			<div class="col-md-4">
				<h1>

				<div class="row">GRUPO 8BANK</div>
				</h1>
			</div>
			<div class="col-md-6">
				<br>
				<div class="form-inline" >
					<div class="form-group">
						<label for="nombre" class="sr-only">Usuario:</label>
						<input type="text" id="Usuario" placeholder="Usuario:"  class="form-control" required>
					</div>
					<div class="input-group">
						<label for="correo" class="sr-only">Contraseña:</label>
						
						<input type="password" id="password" placeholder="Contraseña:" class="form-control" required>
					</div>
<<<<<<< HEAD
					<button id="login" class="btn btn-success " >Login</button>	
=======
					
					<button id="login" class="btn btn-success " onclick="pasarvariable()" >Login</button>	
>>>>>>> e7ebd6f317445d4f1a647c5969f46d2e31f2ec81
					<i class="fa fa-refresh fa-spin"></i>
					</div>
					<h2 id="respuesta"></h2>				
			</div>
		</div>
		
	</header>	
	
	
	

	<!-- Incluyen los archivos js	 -->
	<script src="//code.jquery.com/jquery-latest.js"></script> 
	<script src="js/bootstrap.min.js"></script>
	<script src="js/ventanas.js"></script>
</body>
</html>