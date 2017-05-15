<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
  
<spring:message var="men" code="form.crear" text="Crear" />
<c:if test="${fabricante.codigo > 0}" >
	<spring:message var="men"  code="form.editar" text="Editar" />
</c:if> 
<c:set scope="request" var="seccion" value="Fabricante"/>
<c:set scope="request" var="seccion" value="${men} ${seccion}"/>
<jsp:include page="../includes/header.jsp" />
<main class="container-fluid">
	<section class="row">
		<c:url var="sendUrl" value="/fabricantes/save"/>

		<c:url var="cancelUrl" value="/fabricantes"/>
		<header class="col-xs-12 col-md-10 col-md-offset-2"><h2>${seccion}</h2></header>
		<div class="container-fluid">
			<form:form action="${sendUrl}" method="post" cssClass="form-horizontal" modelAttribute="fabricante">
				<c:if test="${!empty fabricante}">
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
						<form:label path="telefono" cssClass="control-label  col-xs-2"><spring:message code="form.telefono" text="Telefono"/></form:label>
						<div class="col-xs-4">
							<form:input type="text" path="telefono" cssClass="form-control" cssErrorClass="form-control text-danger"/>
						</div>
					<form:errors path="telefono" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="ciudad" cssClass="control-label col-xs-2"><spring:message code="form.ciudad" text="Ciudad"/></form:label>
					<div class="col-xs-4">
						<form:input type="text" path="ciudad" cssClass="form-control" cssErrorClass="text-danger"/>
					</div>
					<form:errors path="ciudad" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
						<form:label path="personaContacto" cssClass="control-label  col-xs-2"><spring:message code="form.personaContacto" text="Persona de contacto"/></form:label>
						<div class="col-xs-4">
							<form:input type="text" path="personaContacto" cssClass="form-control" cssErrorClass="text-danger"/>
						</div>
						<form:errors path="personaContacto" cssClass="text-danger col-xs-6"></form:errors>
				</div>
							
				<%-- <div class="form-group">
					<form:label cssClass="control-label col-xs-2" path="profesor">Profesor:</form:label>
					<div class="col-xs-4">
						<form:select cssClass="form-control" path="profesor">
			               <form:option value="0" label="Elija un profesor"/>
							<form:options items="${listadoProfesores}" itemValue="codigo" itemLabel="fullName" />
			            </form:select> 
		            </div>
		            <form:errors cssClass="text-error"  path="profesor"/>   
				</div>
				<div class="form-group">
					<form:label cssClass="control-label col-xs-2" path="cliente">Cliente:</form:label>
					<div class="col-xs-4">
						<form:select  cssClass="form-control" path="cliente">
							<form:option value="0" label="Elija un cliente"/>
							<form:options  items="${listadoClientes}" itemValue="codigo" itemLabel="nombre" />
			            </form:select> 
		            </div>
		            <form:errors cssClass="text-error"  path="cliente"/>   
				</div>
				<div class="form-group">
					<form:label cssClass="control-label col-xs-2" path="alumnos">Alumnos:</form:label>
					<div class="col-xs-4">
						<form:select multiple="true" cssClass="form-control" path="alumnos">
							<form:options items="${listadoAlumnos}" itemValue="codigo" itemLabel="nombre" />
			            </form:select> 
		            </div>
		            <form:errors cssClass="text-error"  path="alumnos"/>   
				</div> --%>
				<div class="form-group">
					<div class="col-md-offset-3">
						<button type="submit" class="btn btn-success">${men}</button>
						<a class="btn btn-warning" href="${cancelUrl}">Cancelar</a>
					</div>
				</div>
				<%-- <form:hidden path="activo"/> --%>
			</form:form>
		</div>
	</section>
</main>
<%@include file="../includes/footer.html" %>