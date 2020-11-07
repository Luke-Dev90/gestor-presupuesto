<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name ="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
		integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
		crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/c97c8bdba0.js"
		crossorigin="anonymous"></script>
<title>Editar Operaciones</title>
</head>
<body>
	<!-- Cabeceros -->
	<jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>
	<form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idOperacion=${operaciones.idOperacion}"
	method="POST" class="was-validated">
	
	<jsp:include page="/WEB-INF/paginas/comunes/BotonesEditar.jsp"/>
	
	<section id="details">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="card-header">
						<h4>Editar Operacion</h4>
					</div>
					<div class="card-body">
						<div class="form-group">
							<label for="concepto">Concepto:</label>
							<input type="text" class="form-group" name="concepto" required value="${operaciones.concepto}">
						</div>
						<div class="form-group">
							<label for="monto">Monto:</label>
							<input type="number" class="form-group" name="monto" required value="${operaciones.monto}" step="any">
						</div>
						<div class="form-group">
							<label for="fecha">Fecha: ${operaciones.fecha}</label>
						</div>
						<div class="form-group">
							<label for="tipo">Tipo operación: ${operaciones.tipo}</label>
							<select class="form-control" name="tipo" required>
							<option value="mantener">mantener</option>
							<option value="ingresos">ingresos</option>
							<option value="egresos">egresos</option>
						</select>
						</div>
					</div>
				</div>
			</div>
		
		</div>
	
	</section>
	
	
	</form>
</body>
</html>