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

				<div class="row">texto</div>
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
						<label for="correo" class="sr-only">ContraseÒa:</label>
						
						<input type="password" id="password" placeholder="ContraseÒa:" class="form-control" required>
					</div>
					
					<button id="login" class="btn btn-success " onclick="pasarvariable()">Login</button>	
					<i class="fa fa-refresh fa-spin"></i>
					<script type="text/javascript">
					function pasarvariable(){
alert("estamos en java scrip");

//var pwd = document.getElementById("pwd").value;
//var user = document.getElementById("Usuario").value;

//location.href="ControlRol?user="+user+"&pwd="+pwd;
}
</script>

				</form>	
				
			</div>
		</div>
		<!-- <div class="alert alert-dismissible alert-success "><button type="button" class="close" data-dismiss="alert">&times;</button><strong>Buscando... </strong>  Se est√° ejecutando la busqueda.</div> -->
	</header>

		<script type="text/javascript">
			

			alert("Hello! I am an alert box!!");
		</script>
	<button onclick="pasarvariable()">pasa </button>
	<div id="myModal" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">x</button>
	        <h4 class="modal-title">Favor ingresar todos los datos</h4>
	      </div>
	      <div class="modal-body">
	        <div class="container"> 
				<form action="" class="form-horizontal">

					<div class="form-group">
						<label for="nombre" class="control-label col-md-2">Digite su cedula:</label>
						<div class="col-md-4">
							<input name="cedula" type="text" placeholder="cedula" class="form-control " >
						</div>
						<br><br>
						<label for="nombre" class="control-label col-md-2">Digite su nombre:</label>
						<div class="col-md-4">
							<input name="Nombre" type="text" placeholder="Nombre" class="form-control " >
						</div>
						<br><br>
						<label for="nombre" class="control-label col-md-2">Digite su apellido:</label>
						<div class="col-md-4">
							<input name="apellido" type="text" placeholder="apellido" class="form-control " >
						</div>
					</div>
					
					<div class="form-group ">
						<label for="option" class="control-label col-md-2">Elige un genero:</label>
						<div class="col-md-4">
							<select name="genero" id="option" class="form-control " >
								<option value="" >Femenino </option>
								<option value="" >Masculino </option>								
							</select>
						</div>
					</div>
					<div class="form-group has-primary">
						<label for="nombre" class="control-label col-md-2">Digite su correo:</label>
						<div class="col-md-4">
							<input name="email" type="email" placeholder="correo" class="form-control " >
						</div>
						<br><br>
						<label for="contra" class="control-label col-md-2">Digite su contrase√±a:</label>
						<div class="col-md-4">
							<input name="contra" type="text" placeholder="contrase√±a" class="form-control " >
						</div>
						
					</div>
					
					
					<div class="form-gruop ">
						<div class="col-md-2 col-md-offset-2">
							<button id="btn_enviar" class="btn btn-primary" >Enviar</button>
						</div>
					</div>
					

				</form>
			</div>
	      </div>
	      <div class="modal-footer">
	      	<button type="button"  class="btn btn-default" data-dismiss="modal">Cerrar</button>
	      	<a href="index.php" class="btn btn-success">Guardar</a>
	        
	      </div>
	    </div>

	  </div>
	</div>
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