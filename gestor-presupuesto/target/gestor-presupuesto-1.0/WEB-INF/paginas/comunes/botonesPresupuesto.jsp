<section id="actions" class="py-4 mg-4 bg-light">
	<div class="container">
		<div class="row p-1">
			<div class="col-md-3">
				<a href="${pageContext.request.contextPath}/ServletControlador?accion=Obtenerlistado&accion2=general"
				class="btn btn-primary btn-block">
				<i class="fas fa-smile"></i>&nbsp Listado General</a>
				
				
		</div>
				<div class="col-md-3">
				<a href="${pageContext.request.contextPath}/ServletControlador?accion=Obtenerlistado&accion2=ingresos" 
				class="btn btn-primary btn-block">
				<i class="fas fa-address-book"></i>&nbsp Listar Ingresos</a>
				</div>
				
				<div class="col-md-3">
				<a href="${pageContext.request.contextPath}/ServletControlador?accion=Obtenerlistado&accion2=egresos"
				class="btn btn-primary btn-block">
				<i class="fas fa-address-book"></i>&nbsp Listar egresos</a>
				</div>
			</div>
			
			
			<div class="row p-1">
			
			<div class="col-md-1"></div>
			<div class="col-md-3">
				<a href="#" class="btn btn-primary btn-block"
				data-toggle="modal" data-target="#agregarOperacion">
					<i class="fas fa-plus"></i>Nueva Operacion
				</a>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-3">
				<a href="${pageContext.request.contextPath}/ServletControlador?accion=cerrar" class="btn btn-primary btn-block">
				<i class="fas fa-plus"></i>Cerrar Conexion
				</a>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>	
</section>

<!-- Modals -->
<jsp:include page="/WEB-INF/paginas/ventas/agregarOperacion.jsp" />