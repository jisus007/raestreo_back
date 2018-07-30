<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags"    prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"      prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"       prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Vector ITC Group - Objetos</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css"
              rel="stylesheet" media="screen"/>
    <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>

</head>
<body>
<br>
	<jsp:include page="../fragments/header.jsp"/>
	<br>
<div class="container">

    <div class="row">
        <div class="col-sm-6">
            <h2>Detalle Objeto</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-8">
            <form class="form-horizontal">
                  <div class="form-group">
					<label class="col-sm-2 control-label">Id:</label>
					<div class="col-sm-10">
						<p class="form-control-static">${objeto.idObjeto}</p>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Nombre:</label>
					<div class="col-sm-10">
						<p class="form-control-static">${objeto.nombre}</p>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Proyecto:</label>
					<div class="col-sm-10">
						<p class="form-control-static">${objeto.descripcion}</p>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Serie:</label>
					<div class="col-sm-10">
						<p class="form-control-static">${objeto.serie}</p>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Fecha Alta:</label>
					<div class="col-sm-10">
						<p class="form-control-static">${objeto.fecAlta}</p>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Fecha Act:</label>
					<div class="col-sm-10">
						<p class="form-control-static">${objeto.fecActualizacion}</p>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Estatus:</label>
					<div class="col-sm-10">
						<p class="form-control-static">${objeto.status}</p>
					</div>
				</div>
				
				<div class="row">							
					<a href="/objetos" class="btn btn-primary" role="button">Regresar</a>
				</div>
            </form>
        </div>
    </div>
</div>
<br/>
<br/>
<jsp:include page="../fragments/footer.jsp"/> 
</body>
</html>