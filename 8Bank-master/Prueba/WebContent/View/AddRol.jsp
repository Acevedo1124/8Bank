<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Rol</title>
</head>
<body>
<script type="text/javascript">
function GuardarRol(){
	var url = "/Prueba/ControlRol?txtNombre=" + encodeURIComponent(document.getElementById("txtNombre").value)
			+ "&txtDescripcion=" +encodeURIComponent(document.getElementById("txtDescripcion").value)
			+ "&action=Guardar";
	location.href = url;
			
	
}
</script>
	<h1>Agregar Rol</h1>
		<h3>${resultado}</h3>
<input type="text" id="txtNombre" style="margin: 1em; 
width: 159px; height: 31px;" placeholder="Nombre">
<br/>	
<textarea id="txtDescripcion" style="margin: 1em; width: 159px; height: 31px;"
 placeholder="Descripción" cols="30" rows="1" style=""></textarea>
<br>
<button value="guardar" style="margin: 1em;" onclick="GuardarRol()">Guardar</button>

</body>
</html>