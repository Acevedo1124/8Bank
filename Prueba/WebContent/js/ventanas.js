function pasarvariable(){


var pwd = document.getElementById("password").value;
var user = document.getElementById("Usuario").value;


location.href="ControlUser?user="+user+"&pwd="+pwd+"&accion=login";
}


function listaruser(){
	
}




function crud_rol(){
	url = "../ControlRol";
	location.href = url;

	
}