<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>    
<c:set scope="request" var="seccion" value="Prenda ${prenda.nombre}"/>
<jsp:include page="../includes/header.jsp" />
<main class="container-fluid">
	<section class="row">
		<header class="col-xs-12"><h2><p>Datos de la prenda de coleccion ${coleccion.year}</p></h2></header>
		<div class="col-xs-12">
			<p>Nombre: ${prenda.nombre}</p>
		    <p>Talla: ${prenda.talla}</p>
	        <p>Color: ${prenda.color}</p>
	       	<p>Tipo de Tela: ${prenda.tipoTela}</p>
	       	
        </div>

	</section>
</main>
<%@include file="../includes/footer.html" %>