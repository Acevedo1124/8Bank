function pasarvariable(){


var pwd = document.getElementById("password").value;
var user = document.getElementById("Usuario").value;
alert("pasarvariable");

location.href="ControlRol?user="+user;
//location.href="ControlUser?user="+user+"&pwd="+pwd;
}

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