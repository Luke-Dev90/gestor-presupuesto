<!-- agregarOperacion -->


<div class="modal fade" id="agregarOperacion">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-info text-white">
				<h5 class="modal-title">Ingrese venta</h5>
				<button class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
			</div>
			
			<form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar"
			method="POST" class="was-validated">
				<div class="modal-body">
					
					<div class="form-group">
						<label for="concepto">Concepto:</label>
						<input type="text" class="form-control" name="concepto" required>
					</div>
					
					<div class="form-group">
						<label for="monto">Monto:</label>
						<input type='number' class="form-control" step="0.01" value="5.00"
						min="0" max="9999999" name="monto" required>
					</div>
					
					<div class="form-group">
						<label for="tipo">Tipo</label>
						<select class="form-control" name="tipo">
							<option value="ingresos">ingresos</option>
							<option value="egresos">egresos</option>
						</select>
					</div>
					
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary "type="submit">Agregar</button>
				</div>
			</form>
		</div>
	</div>
</div>