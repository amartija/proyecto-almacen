<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>    
<c:set scope="request" var="seccion" value="Fabricante ${fabricante.nombre}"/>
<jsp:include page="../includes/header.jsp" />
<main class="container-fluid">
	<section class="row">
		<header class="col-xs-12"><h2><p>Datos del fabricante de la coleccion ${coleccion.year}</p></h2></header>
		<div class="col-xs-12">
			<p>Nombre: ${fabricante.nombre}</p>
		    <p>Telefono: ${fabricante.telefono}</p>
	        <p>Ciudad: ${fabricante.ciudad}</p>
	       	<p>Persona de Contacto: ${fabricante.personaContacto}</p>
	       	
        </div>
		<%-- <section class="col-xs-12">
			<header><h3>Listado de alumnos</h3></header>
			<c:forEach var="alumno" items="${fabricante.alumnos}">
				<div>
					<a href="<c:url value='/fabricantes/${fabricante.codigo}/alumnos/${alumno.codigo}'/>">${alumno.nombre} ${alumno.apellidos} ${alumno.email}</a>
				</div>
			</c:forEach>
		</section> --%>
	</section>
</main>
<%@include file="../includes/footer.html" %>