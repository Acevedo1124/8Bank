<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Usuario</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="../css/estilos.css">
</head>
<body>
<script type="text/javascript">
function GuardarUsuario(){
	var url = "/Prueba/ControlUser?Identificacion=" + encodeURIComponent(document.getElementsByName("Identificacion").value)
			+ "&txtNombre" +encodeURIComponent(document.getElementsByName("Nombre").value)
			+ "&txtPrimer_apellido" +encodeURIComponent(document.getElementsByName("Primer_apellido").value)
			+ "&txtSegundo_apellido" +encodeURIComponent(document.getElementsByName("Segundo_apellido").value)
			+ "&txtMail" +encodeURIComponent(document.getElementsByName("Mail").value)
			+ "&txtTelefono" +encodeURIComponent(document.getElementsByName("Telefono").value)
			+ "&txtUsuario" +encodeURIComponent(document.getElementsByName("Usuario").value)
			+ "&txtContraseña" +encodeURIComponent(document.getElementsByName("Contraseña").value)
			+ "&txtIdCiudad" +encodeURIComponent(document.getElementsByName("tb_Ciuadades_idtb_Ciuadades").value)	
			+ "&accion=guardarUser&Rol="+document.getElementsByName("tb_Rol_idtb_Rol").value;
	location.href = url;
			
	
}
</script>
	<h1>Agregar Usuario</h1>
		<h3>${resultado}</h3>
<form id="tb_usuario" method="get" name="registro" class="form-horizontal"> 
	<div class="modal-body"> 
	<div id="rr" class="container"> 
	<div class="form-group"> 
	<label for="Identificacion" class="control-label col-md-2">Identificacion:</label> 
	<div class="col-md-4"> 
	<input name="Identificacion" type="text" placeholder="Ingresar Identificacion" class="form-control " required > 
	</div><br><br> 
	<label for="Nombre" class="control-label col-md-2">Nombre:</label> 
	<div class="col-md-4"> 
	<input name="Nombre" type="text" placeholder="Ingresar Nombre" class="form-control " required > 
	</div><br><br> 
	<label for="Primer_apellido" class="control-label col-md-2">Primer Apellido:</label> 
	<div class="col-md-4"> 
	<input name="Primer_apellido" type="text" placeholder="Ingresar Primer apellido" class="form-control " required > 
	</div> 
	</div> 
	<div class="form-group "> 
	<label for="Segundo_apellido" class="control-label col-md-2">Segundo Apellido:</label> 
	<div class="col-md-4"> 
	<input name="Segundo_apellido" type="text" placeholder="Ingresar Segundo Apellido" class="form-control " > 
	</div> 
	</div> 
	<div class="form-group "> 
	<label for="Mail" class="control-label col-md-2">Correo Electronico:</label> 
	<div class="col-md-4"> 
	<input name="Mail" type="email" placeholder="Ingresar Correo electronico" class="form-control " > 
	</div><br><br> 
	<label for="Telefono" class="control-label col-md-2">Telefono:</label> 
	<div class="col-md-4"> 
	<input name="Telefono" type="text" placeholder="Ingresar Telefono" class="form-control " > 
	</div><br><br>
	<label for="tb_Ciuadades_idtb_Ciuadades" class="control-label col-md-2">Id Ciudad:</label> 
	<div class="col-md-4"> 
	<select  name="tb_Ciuadades_idtb_Ciuadades" class="control-label col-md-2">
                                <option value="1">-Seleccione-</option>
                                <option value="2">Med</option>
                                <option value="3" >Pas</option>
                                <option value="4" >Otro</option>     
                            </select>
	</div><br><br>  
		<label for="tb_Rol_idtb_Rol" class="control-label col-md-2">Id Rol:</label> 
	<div class="col-md-4"> 
	<select  name="tb_Rol_idtb_Rol" class="control-label col-md-2">
                                <option value="1">-Seleccione-</option>
                                <option value="2">Admin</option>
                                <option value="3" >Pas</option>
                                <option value="4" >Otro</option>     
                            </select>
	</div><br><br>  
	<label for="Usuario" class="control-label col-md-2">Usuario:</label> 
	<div class="col-md-4"> 
	<input name="Usuario" type="text" placeholder="Ingresar Usuario" class="form-control " > 
	</div><br><br> 
	<label for="Contraseña" class="control-label col-md-2">Contraseña:</label> 
	<div class="col-md-4"> 
	<br><input name="Contraseña" type="password" placeholder="Ingresar Contraseña" class="form-control " > 
	</div> 
	</div> 
	</div> 
	</div> 
	<div class="modal-footer"> 
	
	<button type="button" class="btn btn-success" onclick="GuardarUsuario()">Guardar</button> 
	</div> 
	</form> 


<script src="//code.jquery.com/jquery-latest.js"></script> 
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/ventanas.js"></script>
</body>
</html>