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
				<img src="Img/G8.jpg" class="img-rounded"  width="100%" >			
			</div>
			<div class="col-md-4">
				<h1>

					<div class="row">Bienvenido </div>
				</h1>
			</div>
			
		</div>
		
	</header>

	<div class="conatiner">
		
		
		<div class="col-md-3"><br><br><br>
			<button id="btn_user" class="btn btn-success " onclick="crud_user()" >Usuarios</button><br><br><br>
			<button id="btn_cuidad" class="btn btn-success " onclick="location.href = '../ControlCiudades?action=Listar'" >Ciudad</button><br><br><br>
			<button id="btn_rol" class="btn btn-success " onclick="crud_rol()" >Roles</button><br><br><br>


		</div>
		<div class="col-md-9">	
			<h2>	
				<div class="col-md-9" style="display:none" id="Ver_user"><h1>Ver user</h1></div>
				<div class="col-md-9" style="display:none" id="Ver_ciudad"><h1>Ver Ver_ciudad</h1></div>
				
			</h2>
		</div>
	</div>

	<script type="text/javascript">
	window.onload = function(){
		history.replaceState({}, "page", "View/UserAdmin.jsp");
	};
	</script>


	<!-- Incluyen los archivos js	 -->
	<script src="//code.jquery.com/jquery-latest.js"></script> 
	<script src="js/bootstrap.min.js"></script>
	<script src="js/ventanas.js"></script>
</body>
</html>