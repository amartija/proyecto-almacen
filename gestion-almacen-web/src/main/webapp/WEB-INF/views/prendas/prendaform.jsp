<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
  
<spring:message var="men" code="form.crear" text="Crear" />
<c:if test="${prenda.codigo > 0}" >
	<spring:message var="men"  code="form.editar" text="Editar" />
</c:if> 
<c:set scope="request" var="seccion" value="Prenda"/>
<c:set scope="request" var="seccion" value="${men} ${seccion}"/>
<jsp:include page="../includes/header.jsp" />
<main class="container-fluid">
	<section class="row">
		<c:url var="sendUrl" value="/prendas/save"/>

		<c:url var="cancelUrl" value="/prendas"/>
		<header class="col-xs-12 col-md-10 col-md-offset-2"><h2>${seccion}</h2></header>
		<div class="container-fluid">
			<form:form action="${sendUrl}" method="post" cssClass="form-horizontal" modelAttribute="prenda">
				<c:if test="${!empty prenda}">
					<form:hidden path="codigo"/>
				</c:if>
				<div class="form-group">
						<form:label path="nombre" cssClass="control-label  col-xs-2"><spring:message code="form.nombre" text="Nombre"/></form:label>
						<div class="col-xs-4">
							<form:input type="text" path="nombre" cssClass="form-control" cssErrorClass="form-control text-danger"/>
						</div>
					<form:errors path="nombre" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
						<form:label path="talla" cssClass="control-label  col-xs-2"><spring:message code="form.talla" text="Talla"/></form:label>
						<div class="col-xs-4">
							<form:input type="text" path="talla" cssClass="form-control" cssErrorClass="form-control text-danger"/>
						</div>
					<form:errors path="talla" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="color" cssClass="control-label col-xs-2"><spring:message code="form.color" text="Color"/></form:label>
					<div class="col-xs-4">
						<form:input type="text" path="color" cssClass="form-control" cssErrorClass="text-danger"/>
					</div>
					<form:errors path="color" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
						<form:label path="tipoTela" cssClass="control-label  col-xs-2"><spring:message code="form.tipoTela" text="Tipo Tela"/></form:label>
						<div class="col-xs-4">
							<form:input type="text" path="tipoTela" cssClass="form-control" cssErrorClass="text-danger"/>
						</div>
						<form:errors path="tipoTela" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				
				<div class="form-group">
					<div class="col-md-offset-3">
						<button type="submit" class="btn btn-success">${men}</button>
						<a class="btn btn-warning" href="${cancelUrl}">Cancelar</a>
					</div>
				</div>
				
			</form:form>
		</div>
	</section>
</main>
<%@include file="../includes/footer.html" %>