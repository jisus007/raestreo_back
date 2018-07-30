<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
	<script type="text/javascript">
		
		function cerrarSession() 
		{ 			
			document.getElementById("cerrar").click();
		} 
	</script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
          
        <title>Proyectos Internos</title>
    </head>
  
    	
		<div class="header">
			<form class="form-horizontal" commandName="headerForm">
				<input type="hidden" name="idUsuario" value="${usuario.id}"/>
			    <!-- this is header -->
			    <nav class="navbar-inverse">
				  <div class="container-fluid">
				    <div class="navbar-header">				     
				      <a class="navbar-brand" href="">	
				      	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				      </a>
				    </div>
				    <ul class="nav navbar-nav">
				    
				      <li class="active">
				      	 <a class="navbar-brand" href="/inicio">	
				      	 	<span class="fa-stack">
	                			<i class="glyphicon glyphicon-home"></i>
	                		</span>
				      	 </a>
				      </li> 
				      <li><a href="/objetos">Objetos</a></li>
				      <li><a href="/travel">Ubicar</a></li>
				    </ul>
				  </div>
				</nav>
			</form>
		</div>
			
    </body>
</html>