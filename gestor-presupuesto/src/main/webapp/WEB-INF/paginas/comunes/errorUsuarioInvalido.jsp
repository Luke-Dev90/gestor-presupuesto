
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="refresh" content="1;url=${pageContext.request.contextPath}/ServletControlador">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
		integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
		crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/c97c8bdba0.js"
		crossorigin="anonymous"></script>
	<title>Control de Clientes</title>

</head>
<body>

	<!--  Cabecero -->
	<jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp" />
	<!--  Botones -->
	<jsp:include page="/WEB-INF/paginas/comunes/botonesNevegacion.jsp" />

	
	<jsp:include page="/WEB-INF/paginas/alertas/userInvalidoModal.jsp" />	


	<!-- Pie de pagina -->
	<jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp" />
	
	
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>

</body>
</html>