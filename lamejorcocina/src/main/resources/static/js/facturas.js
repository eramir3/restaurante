let numeroPlatoAdicional = 1;

$( document ).ready(function() {
	  
	$("#facturaForm").submit(function(event) {
		event.preventDefault();
		saveFactura();
	});

	$("#btnAgregarPlato").click(function() {
		agregarPlato();
	});
});



function saveFactura() {
	
	var config = {};
	jQuery($("#facturaForm")).serializeArray().map(function(item) {
	    if ( config[item.name] ) {
	        if ( typeof(config[item.name]) === "string" ) {
	            config[item.name] = [config[item.name]];
	        }
	        config[item.name].push(item.value);
	    } else {
	        config[item.name] = item.value;
	    }
	});
	
	console.log(config);
	
	/*
	let formData = getFormData($("#facturaForm"));
	
	console.log($("#facturaForm").serialize());
	console.log(JSON.stringify(formData));
	*/

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "api/save",
		data : JSON.stringify(config),
		dataType : 'json',
		success : function(result) {
			
			if (result.status == "200") {
				alert('La factura ha sido creada con exito!');
			} 
			else {
				alert('Error!');
			}
		},
		error : function(e) {
			alert("Error!")
			console.log("ERROR: ", e);
		}
	});
}

/*
function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}
*/

function agregarPlato() {
	
	/*
	let nuevoPlato = $("#infoPlato-0").clone();
	nuevoPlato.attr("id", "infoPlato-" + numeroPlatoAdicional);
	nuevoPlato.append(`
			<div class="col-3 mb-4">
				<button type="button" class="btn btn-danger" id="btnEliminarPlato-`+numeroPlatoAdicional+`" onclick="eliminarPlato('infoPlato-`+numeroPlatoAdicional+`')">Eliminar</button>
			</div>`
			);
	*/
	
	
	/*
	let nuevoPlato = `
		<div class="row" id="infoPlato-`+numeroPlatoAdicional+`">
			<div class="col-3 mb-4">
				<input type="text" class="form-control" placeholder="Plato" name="nombrePlato[`+numeroPlatoAdicional+`]">
			</div>
			<div class="col-3 mb-4">
				<input type="number" class="form-control" placeholder="Importe" name="importePlato[`+numeroPlatoAdicional+`]">
			</div>
			
		</div>
	`;
	*/
	
	let nuevoPlato = `
		<div class="row" id="infoPlato-`+numeroPlatoAdicional+`">
			<div class="col-3 mb-4">
				<input type="text" class="form-control" placeholder="Plato" name="nombrePlato[]" required>
			</div>
			<div class="col-3 mb-4">
				<input type="number" class="form-control" placeholder="Importe" name="importePlato[]" required>
			</div>
			<div class="col-3 mb-4">
				<button type="button" class="btn btn-danger" id="btnEliminarPlato-`+numeroPlatoAdicional+`" onclick="eliminarPlato('infoPlato-`+numeroPlatoAdicional+`')">Eliminar</button>
			</div>
		</div>
	`;
	
	
	$(nuevoPlato).appendTo($("#platos"));
	numeroPlatoAdicional++;
}

function eliminarPlato(id) {
	$("#"+id).remove();
}