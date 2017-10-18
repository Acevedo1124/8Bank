function pasarvariable(){


var pwd = document.getElementById("password").value;
var user = document.getElementById("Usuario").value;
alert("pwd"+pwd);

location.href="ControlRol?user="+user+"&pwd="+pwd;
}