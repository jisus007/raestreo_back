jpProy= {
		lock:0,	
		init:function(){
			$('#idBuscar').click(function(){
				var valjp = $('#idJefe').val()
				if(valjp==="0"){
					jAlert(mensajes["ED00001V"],
							mensajes["aplicacion"],
						   	   'ED00001V',
						   	   '');
				}else{
					$('#proyectoForm').submit();
				}
			}
		}

		activarCps:function(){
			var val = $("input[name='activo']:checked").val();
			
			if(val){				
				document.getElementById('activo').checked  = true;
				
			}else{
				document.getElementById('activo').checked  = false;
			}
		}
}

