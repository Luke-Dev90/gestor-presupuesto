<div class="modal fade" id="loginModal">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-info text-white">
				<h5 class="modal-title">Login Usuario</h5>
				<button class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
			</div>
			<form action="${pageContext.request.contextPath}/ServletControlador?accion=loginUser"
				method="POST" class="was-validated">
					<div class="modal-body">
						<div class="form-group">
							<label for="email">Email</label>
							<input type="email" class="form-control" name="email" required >
						</div>
						<div class="form-group">
							<label for="pass">Password</label>
						<input type="password" class="form-control" name="pass" required>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-primary" type="submit">Agregar</button>
					</div>
			</form>
		</div>
	</div>
</div>