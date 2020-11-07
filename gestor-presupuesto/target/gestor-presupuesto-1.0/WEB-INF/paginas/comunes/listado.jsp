<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${cookie.preferredLocale.value}"/>


<section id="listados">
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="card">
					<h4 class="text-center">Listado de ingreso y egresos</h4>
				</div>
				<table class="table table-striped">
					<thead class="thead-dark">
						<tr>
							<th>#</th>
							<th>Concepto</th>
							<th>Monto</th>
							<th>fecha</th>
							<th>Tipo</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="operaciones" items="${listado}" varStatus="status">
						<tr>
						<td> ${status.count}</td>
						<td> ${operaciones.concepto}</td>
						<td> <fmt:formatNumber value="${operaciones.monto}" type="currency"/></td>
						<td> ${operaciones.fecha}</td>
						<td> ${operaciones.tipo }</td>
						<td> 
						<a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idOperacion=${operaciones.idOperacion}"
						class="btn btn-secondary">
						<i class="fas fa-angle-double-right"></i>Editar
						</a>
						
						</td>
						</tr>
						
						</c:forEach>
					</tbody>				
				</table>
			</div>
		</div>
		<div class="col-md-9">
		<div class="card text-center bg-danger text-white mb-3">
			<div class="card-body">
				<h3>Saldo Total</h3>
				<h4 class="display-4">
					<fmt:formatNumber value="${saldoTotal}" type="currency"/>
				</h4>
			</div>
		</div>
	</div>
	</div>
	
	

</section>