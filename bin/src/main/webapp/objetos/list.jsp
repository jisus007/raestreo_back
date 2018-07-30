<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags"    prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"      prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"       prefix="fmt"%>

<!DOCTYPE html>

<html lang="en">
<head>
    <title>Sistema de Rastreo - Objetos</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css"
          rel="stylesheet" media="screen"/>
    <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>
    
	<script src="../js/objeto.js"></script>
    <script src="../js/fechas.js"></script>
	<script src="../core/jquery.autocomplete.min.js" ></script>
	<link href="../core/main.css" >
	<!-- Include Date Range Picker -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
</head>
<body>
<br>
	<jsp:include page="../fragments/header.jsp"/>
	<br>
	<br>
		<div class="container">
    <div>
        <h2>Lista de Objetos</h2>
        <form class="form-horizontal" action="/objetos" commandName="listForm" method="post" id="listForm" name ="listForm">
      		<div class="form-group"> 
      			<div class="row">
					<label class="col-sm-2 control-label">Nombre:</label>
					<div class="col-sm-2">
						<div class="input-group">
						   <input class="form-control" id="nombre" name="nombre" placeholder="Nombre del Objeto" type="text"
						   value="${objeto.nombre}" />
					    </div>					
					</div>
					<div class="col-sm-2">				
						<button type="submit" class="btn btn-primary">Buscar</button>
						<a href="/objetos" class="btn btn-primary" role="button">Todos</a>
					</div>
				</div>
			</div>
			<br/>
			<br/>
			<br/>
	        <table class="table table-striped">
	        	<thead>
		            <tr>
		                <th>Id</th>
		                <th>Nombre</th>
		                <th>Descripcion</th>
		                <th>Serie</th>
		                <th>Fecha de Alta</th>
		                <th>Ultima Actualizacion</th>
		                <th>Estatus</th>
		                <th>Ver </th>
		                <th>Editar</th>
		                <th>Eliminar</th>
		            </tr>
		        </thead>
		        <tbody>        	
		            <c:forEach items = "${objetos}" var="objeto">
		            <tr>
		                <td>${objeto.idObjeto}</td>
		                <td>${objeto.nombre}</td>
		                <td>${objeto.descripcion}</td>
		                <td>${objeto.serie}</td>
		                <td>${objeto.fecAlta}</td>
		                <td>${objeto.fecActualizacion}</td>
		                <td>${objeto.status}</td>
		                <td>
		                	<a href="/objeto/show/${objeto.idObjeto}">
		                		<span class="fa-stack">
		                			<i class="glyphicon glyphicon-list-alt"></i>
		                		</span>
							</a> 
						</td>
		                <td>
		                	<a href="/objeto/edit/${objeto.idObjeto}">
		                		<span class="fa-stack">
		                			<i class="glyphicon glyphicon-edit"></i>
		                		</span>
							</a> 
						</td>
		                <td>
		                	<a href="/objeto/delete/${objeto.idObjeto}">
		                		<span class="fa-stack">
		                			<i class="glyphicon glyphicon-trash"></i>
		                		</span>
		                	</a> 
		                </td>
		            </tr>
		            </c:forEach>
	             </tbody>
	             <tfoot>
	             	<tr>
	             		<a href="/objeto/new" class="btn btn-primary" role="button">
	             			<span class="fa-stack">
	                			<i class="glyphicon glyphicon-plus-sign"></i>
	                		</span> Nuevo
						</a>
	             	</tr>
	             </tfoot>
	        </table>
      
      </form>
    </div>
    <br/>
    <br/>
</div> 
<br/>
<br/>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
 