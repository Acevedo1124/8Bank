
var txt='<div class="container-fluid">';
for (var i = 1; i < 7; i++) {
	txt +='<img src="img/celu'+i+'.jpg" class="imgmar img-responsive img-circle img-thumbnail">';				
}
txt +='</div>';

$('#img').html(txt);

$('form').submit(function (e) {

	e.preventDefault();

	
	$('.alert').remove();

	var aler='<div class="alert alert-dismissible alert-success "><button type="button" class="close" data-dismiss="alert">&times;</button><strong>Buscando... </strong>  Se está ejecutando la busqueda.</div>';
	allert(aler);
	
	
	var data = $(this).serializeArray();
	data.push({
		name:"tag",value:"login"
	});


	$.ajax({
		url: "validar.php",
		type: "post",
		dataType: "json",
		data: data,
		beforeSend:function() {
			//alert('esta en display');
			$('.fa').css('display','inline');
		}
	})
	.done(function(data) {

		if (data.success) {
			setTimeout(function() {
				$('.alert').remove();
				var aler = '<div class="alert alert-dismissible alert-success "><button type="button" class="close" data-dismiss="alert">&times;</button><strong>Exito...</strong>  '+data.message+'</div>';
				allert(aler);
			},2000);			
		}else{
			setTimeout(function() {
				$('.alert').remove();
				var aler = '<div class="alert alert-dismissible alert-warning "><button type="button" class="close" data-dismiss="alert">&times;</button><strong>Error...</strong> '+data.message+'</div>';
				allert(aler);
			},2000);
		}
		//$('.alert').remove();
		
	})
	.fail(function(data) {
		setTimeout(function() {
			$('.alert').remove();
			var aler = '<div class="alert alert-dismissible alert-danger "><button type="button" class="close" data-dismiss="alert">x</button><strong>Peligro... </strong>  Algo ha fallado.</div>';
			allert(aler);
		},2000);
	})
	.always(function() {
		setTimeout(function() {
			$('.fa').hide();	
		},3000);		
	});
});

function allert(html) {
	$('#respuesta').append(html);
	
	setTimeout(function() {
		$('.alert').addClass('on');
	},200);
}

// $("#btn_enviar").click(function(){  

// 		alert("hola")  
//         $.ajax({
//                type: "GET",
//                url: "ingresar.php";,
//                data: $("#formulario").serialize(), // Adjuntar los campos del formulario enviado.
//                success: function(data) {
//                    $("#respuesta").html(data); // Mostrar la respuestas del script PHP.
//                }
//              });

//         return false; // Evitar ejecutar el submit del formulario.

//     });


