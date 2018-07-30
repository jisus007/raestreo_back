<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags"    prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"      prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"       prefix="fmt"%>

<!DOCTYPE html>

<html lang="en">
<head>
    <title>Vector ITC Group - Proyectos</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css"
          rel="stylesheet" media="screen"/>

    <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"></script>

    <script src="../js/fechas.js"></script>
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
        <h2>Registro del Informe</h2>
       
        <form class="form-horizontal" action="/informe" commandName="infListForm" method="post" id="infListForm" name ="infListForm">
			<input type="hidden" name="idOriginal" value="${info.id}"/>
			<input type="hidden" name="id" value="${info.id}"/>
      		<div class="form-group">
 				<label class="col-sm-2 control-label">Nombre del proyecto:</label>
				<div class="col-sm-6">
					<select name="idProyecto" id="idProyecto" required="required" class="form-control" >
						 <option value=""  ${info.idProyecto eq "0"?"selected":"" }> - Seleccione - </option>
				    	<c:forEach items="${listProyec}" var="dato">					    	 	
							 <option value="${dato.key}"  ${dato.key eq info.idProyecto?"selected":"" }> ${dato.value} </option>
						</c:forEach>
				    </select> 
				</div>								
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Fecha Informe:</label>
				<div class="col-sm-2">
					<div class="input-group date" data-provide="datepicker">
					   <input class="form-control" id="fIni" name="fIni" placeholder="DD/MM/YYY" type="text"
					   value="${info.fIni}" required="required"/>
					  <div class="input-group-addon">
					        <span class="glyphicon glyphicon-th"></span>
					    </div>
				    </div>					
				</div>											
			</div>
			<div class="form-group">
					<label class="col-sm-2 control-label">Resumen Ejecutivo:</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="resumen" value="${info.resumen}" />
					</div>
			</div>
			<div class="row">
				<button type="submit" class="btn btn-primary">Guardar</button>
				&nbsp;&nbsp;					
				<a href="/informe" class="btn btn-primary" role="button">Regresar</a>
			</div>
	      	<c:if test="${info.id > 0 }">
		      	<h2>Avance</h2>
		      	<table class="table table-striped">
		        	<thead>
			            <tr>
			            	<th>Id</th>
			                <th>Compromiso</th>
			                <th>Entregables</th>
			                <th>Fecha Inicio</th>
			                <th>Fecha Fin</th>
			                <th>Avance</th>	
			                <th>Editar</th>
			                <th>Eliminar</th>
			            </tr>
			        </thead>
			        <tbody>        	
			            <c:forEach items = "${avances}" var="avance">
			            <tr>
			                <td>${avance.id}</td>
			                <td>${avance.compromiso}</td>
			                <td>${avance.entregable.descripcion}</td>
			                <td>${avance.fechaIni}</td>
			                <td>${avance.fechaFin}</td>
			                <td>${avance.avance}</td>			                
			                <td>
			                	<a href="/avance/editAv/${avance.id}">
			                		<span class="fa-stack">
			                			<i class="glyphicon glyphicon-edit"></i>
			                		</span>
								</a> 
							</td>
			                <td>
			                	<a href="/avance/delete/${avance.id}">
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
		             		<a href="/informe/newAv/${info.id}" class="btn btn-primary" role="button">
		             			<span class="fa-stack">
		                			<i class="glyphicon glyphicon-plus-sign"></i>
		                		</span> Nuevo Avance
							</a>
		             	</tr>
		             </tfoot>
		        </table>
      		</c:if>
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
 