<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>    
<c:set scope="request" var="seccion" value="Listado de Fabricantes"/>
<jsp:include page="../includes/header.jsp" />
<main class="container-fluid">
	<section class="row">
		<header class="col-xs-12"><h2>Listado fabricantes</h2></header>
		<div class="col-xs-12">
		<a class="btn btn-primary" href="<c:url value="/fabricantes/addFabricante"/>">Crear fabricante</a> 
		</div>
		<div class="col-xs-12">
			<div class="row">
				<div class="col-xs-3">Nombre</div>
				<div class="col-xs-3">Telefono</div>
				<div class="col-xs-3">Ciudad</div>
				<div class="col-xs-3"></div>
			</div>
			<c:choose>
				<c:when test="${not empty listadoFabricantes}">
					<c:forEach var="fabricante" items="${listadoFabricantes}">
						<div class="row">
							<div class="col-xs-3">
								<a href="<c:url value='/fabricantes/${fabricante.codigo}'/>">${fabricante.nombre}</a>
							</div>
							<div class="col-xs-3">
								${fabricante.telefono}
				            </div>
							<div class="col-xs-3">
								${fabricante.ciudad}
				            </div>
				            <div class="col-xs-3">
				            	<a class="btn btn-warning" href="<c:url value="/fabricantes/editFabricante/${fabricante.codigo}"/>">Editar fabricante</a>
				            	<a class="btn btn-danger" href="<c:url value="/fabricantes/deleteFabricante/${fabricante.codigo}"/>">Borrar fabricante</a>
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