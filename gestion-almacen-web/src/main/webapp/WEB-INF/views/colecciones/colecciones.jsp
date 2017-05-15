<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>    
<c:set scope="request" var="seccion" value="Listado de Colecciones" /> 
<jsp:include page="../includes/header.jsp" />
<main class="container-fluid">
	<section class="row">
		<header class="col-xs-12"><h2><spring:message code="colecciones.titulo" text="Listado de Colecciones" /></h2></header>
		<div class="col-xs-12">
		<a class="btn btn-primary" href="<c:url value="/colecciones/addColeccion"/>">Crear Coleccion</a> 
		</div>
		<div class="col-xs-12">
			<div class="row">
				<div class="col-xs-2">Año</div>
				<div class="col-xs-2">Gama</div>
				<div class="col-xs-5">Tematica</div>
				<div class="col-xs-3"></div>
			</div>
			<c:choose>
				<c:when test="${not empty listadoColecciones}">
					<c:forEach var="coleccion" items="${listadoColecciones}">
						<div class="row">
							<div class="col-xs-2">
								<a href="<c:url value='/colecciones/${coleccion.codigo}'/>">${coleccion.year}</a>
							</div>
							<div class="col-xs-2">
								${coleccion.gama}
				            </div>
							<div class="col-xs-5">
								${coleccion.tematica}
				            </div>
				            <div class="col-md-3">
				            	<a class="btn btn-warning" href="<c:url value="/colecciones/editColeccion/${coleccion.codigo}"/>">Editar coleccion</a>
				            	<a class="btn btn-danger" href="<c:url value="/colecciones/deleteColeccion/${coleccion.codigo}"/>">Borrar coleccion</a>
				            </div>			
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="row">
						<p class="col-xs-12">No existen resultados</p>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</section>
</main>
<%@include file="../includes/footer.html" %>