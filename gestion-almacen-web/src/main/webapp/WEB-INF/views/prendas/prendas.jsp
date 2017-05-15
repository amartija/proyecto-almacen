<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>    
<c:set scope="request" var="seccion" value="Listado de Prendas"/>
<jsp:include page="../includes/header.jsp" />
<main class="container-fluid">
	<section class="row">
		<header class="col-xs-12"><h2>Listado prendas</h2></header>
		<div class="col-xs-12">
		<a class="btn btn-primary" href="<c:url value="/prendas/addPrenda"/>">Crear Prenda</a> 
		</div>
		<div class="col-xs-12">
			<div class="row">
				<div class="col-xs-3">Nombre</div>
				<div class="col-xs-3">Talla</div>
				<div class="col-xs-3">Color</div>
				<div class="col-xs-3"></div>
			</div>
			<c:choose>
				<c:when test="${not empty listadoPrendas}">
					<c:forEach var="prenda" items="${listadoPrendas}">
						<div class="row">
							<div class="col-xs-3">
								<a href="<c:url value='/prendas/${prenda.codigo}'/>">${prenda.nombre}</a>
							</div>
							<div class="col-xs-3">
								${prenda.talla}
				            </div>
							<div class="col-xs-3">
								${prenda.color}
				            </div>
				            <div class="col-xs-3">
				            	<a class="btn btn-warning" href="<c:url value="/prendas/editPrenda/${prenda.codigo}"/>">Editar prenda</a>
				            	<a class="btn btn-danger" href="<c:url value="/prendas/deletePrenda/${prenda.codigo}"/>">Borrar prenda</a>
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