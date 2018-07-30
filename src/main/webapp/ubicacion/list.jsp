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

<link
	href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet" media="screen" />

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
        <h2>Lista de Informes</h2>
       
        <form class="form-horizontal" action="/listInfo" commandName="listInfForm" method="post" id="listInfForm" name ="listInfForm">
			<div class="form-group">      			
				<label class="col-sm-2 control-label">No. OS:</label>
				<div class="col-sm-6">
					<select name="idProyecto" id="idProyecto" class="form-control" >
						<option value=""  ${info.idProyecto eq "0"?"selected":"" }> - Seleccione - </option>
				    	<c:forEach items="${listProyec}" var="dato">					    	 	
							 <option value="${dato.key}"  ${dato.key eq info.idProyecto?"selected":"" }> ${dato.value} </option>
						</c:forEach>
				    </select> 
				</div>
			</div>
			<div class="form-group">
					<div class="row">
						<label class="col-sm-2 control-label">Fecha Inicio:</label>
						<div class="col-sm-2">
							<div class="input-group date" data-provide="datepicker">
							   <input class="form-control" id="fIni" name="fIni" placeholder="DD/MM/YYY" type="text"
							   value="${info.fIni}" />
							  <div class="input-group-addon">
							        <span class="glyphicon glyphicon-th"></span>
							    </div>
						    </div>					
						</div>												
					
					</div>		
				</div>
			<div class="form-group">	
			   	<div class="col-sm-2">
			   	</div>
				<div class="col-sm-1">				
					<button type="submit" class="btn btn-primary">Buscar</button>					
				</div>		
				
					<div class="col-sm-1">				
						<a href="/informe/new" class="btn btn-primary" role="button">
	             			<span class="fa-stack">
	                			<i class="glyphicon glyphicon-plus-sign"></i>
	                		</span> Nuevo
						</a>
						
					</div>			
			</div>
			<br/>
			<br/>
			<br/>
			<c:if test="${not empty informes}">
		        <table class="table table-striped">
		        	<thead>
			            <tr>		    
			            	<th>id Informe</th>           
			                <th>Número OS</th>
			                <th>Horas Acordadas</th>
			                <th>Fecha Informe</th>
			                <th>Resumen Ejecutivo</th>	               
			                <th>Editar</th>
			                <th>Eliminar</th>
			            </tr>
			        </thead>
			        <tbody>        	
			            <c:forEach items = "${informes}" var="info">
			            <tr>
			                <td>${info.id}</td>
			                <td>${info.proyecto.numOs}</td>
			                <td>${info.proyecto.horas}</td>
			                <td>${info.fechaInf}</td>		                
			                <td>${info.resumen}</td>
			                <td>
			                	<a href="/informe/edit/${info.id}">
			                		<span class="fa-stack">
			                			<i class="glyphicon glyphicon-edit"></i>
			                		</span>
								</a> 
							</td>
			                <td>
			                	<a href="/informe/delete/${info.id}">
			                		<span class="fa-stack">
			                			<i class="glyphicon glyphicon-trash"></i>
			                		</span>
			                	</a> 
			                </td>
			            </tr>
			            </c:forEach>
		             </tbody>		            
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
 