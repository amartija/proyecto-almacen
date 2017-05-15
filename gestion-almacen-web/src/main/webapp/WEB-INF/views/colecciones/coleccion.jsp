<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>    
<c:set scope="request" var="seccion" value="Coleccion ${coleccion.year}"/>
<jsp:include page="../includes/header.jsp" />
<main class="container-fluid">
	<section class="row">
		<header class="col-xs-12"><h2>Datos de la coleccion</h2></header>
		<div class="col-xs-12">
			<p>Año: ${coleccion.year}</p>
		    <p>Gama: ${coleccion.gama}</p>
	        <p>Tematica: ${coleccion.tematica}</p>
	        <p>Fecha Entrada: ${coleccion.fEntrada}</p>
	       
	        <section>
	        <header><h5>Fabricante</h5></header>
	        	<div>
					<a href="<c:url value='/colecciones/${coleccion.codigo}/fabricantes/${coleccion.fabricante.codigo}'/>">${coleccion.fabricante.nombre}</a>
				</div>
	        
	       
	        		       		
			<header><h3>Listado de prendas</h3></header>
			<c:forEach var="prenda" items="${coleccion.prendas}">
				<div>
					<a href="<c:url value='/colecciones/${coleccion.codigo}/prendas/${prenda.codigo}'/>">${prenda.nombre}</a>
				</div>
			</c:forEach>
		</section>
	       	       
        </div>
		
	</section>
</main>
<!-- 		<script>
/* 		const url="http://localhost:8080/gestionalmacen/api/prendas";
		jQuery(document).ready(function($) {
			  $.ajax({
			  url : url,
			  dataType : "json",
			  success : function(data) {
				console.log(data);
				for(var i = 0; i < data.length; i++){
					var txt ="<p>"+data[i].nombre+"</p>";

					$("main div").append(txt);
				}
			  }
		  });
			  
		}); */


		const url="http://localhost:8080/gestionalmacen/api/fabricantes/{codigo}";
		jQuery(document).ready(function($) {
			  $.ajax({
			  url : url,
			  dataType : "json",
			  success : function(data) {
				console.log(data);

					codigo = 2;
					
					var txt ="<p>"+data[i].nombre+"</p>";

					$("main div").append(txt);
				
			  }
		  });
			  
		});

		</script> -->
<%@include file="../includes/footer.html" %>
