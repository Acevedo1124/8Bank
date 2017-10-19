function pasarvariable(){


var pwd = document.getElementById("password").value;
var user = document.getElementById("Usuario").value;


location.href="ControlUser?user="+user+"&pwd="+pwd+"&accion=login";
}

function ocultar() {
	document.getElementById("Ver_user").style.display = "none";
	document.getElementById("Ver_ciudad").style.display = "none";
	document.getElementById("Ver_rol").style.display = "none";
	
	
	}

function listaruser(){
	
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
	url = "../ControlRol";
	location.href = url;

	
}