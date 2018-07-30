<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Vector ITC Group - Proyectos</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link
	href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet" media="screen" />

<script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />

</head>
<body>
	<br>
	<jsp:include page="../fragments/header.jsp" />
	<br>
	<div class="container">

		<h2>Alta Objeto</h2>
		<div>
			<form class="form-horizontal" action="/objeto"
				commandName="objetoForm" method="post" id="objetoForm"
				name="objetoForm">
				<input type="hidden" class="form-control" name="idObjeto"
							value="${objeto.idObjeto}" />

				<div class="form-group">
					<label class="col-sm-2 control-label">Id:</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="idObjeto" disabled="disabled"
							value="${objeto.idObjeto}" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Nombre:</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="nombre"
							value="${objeto.nombre}" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Descripcion:</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="descripcion"
							value="${objeto.descripcion}" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Serie:</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="serie"
							value="${objeto.serie}" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Fecha de Alta:</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="fecAlta"
							value="${objeto.fecAlta}" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Fecha de Act:</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="fecActualizacion"
							value="${objeto.fecActualizacion}" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Status:</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="status"
							value="${objeto.status}" />
					</div>
				</div>

				<div class="row">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="submit" class="btn btn-primary">Guardar</button>
					&nbsp;&nbsp; <a href="/objetos" class="btn btn-primary"
						role="button">Regresar</a>
				</div>
			</form>
		</div>
	</div>
	<br />
	<br />
	<jsp:include page="../fragments/footer.jsp" />
</body>
</html>