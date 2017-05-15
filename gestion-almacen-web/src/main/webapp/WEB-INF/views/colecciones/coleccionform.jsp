<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
  
<spring:message var="men" code="form.crear" text="nombre" />
<c:if test="${coleccion.codigo > 0}" >
	<spring:message var="men"  code="form.editar" text="nombre" />
</c:if> 
<c:set scope="request" var="seccion" value="Coleccion"/>
<c:set scope="request" var="seccion" value="${men} ${seccion}"/>
<jsp:include page="../includes/header.jsp" />
<main class="container-fluid">
	<section class="row">
		<c:url var="sendUrl" value="/colecciones/save"/>

		<c:url var="cancelUrl" value="/colecciones"/>
		<header class="col-xs-12 col-md-10 col-md-offset-2"><h2>${seccion}</h2></header>
		
		<div class="container-fluid">
			<form:form action="${sendUrl}" enctype="multipart/form-data" method="post" cssClass="form-horizontal" modelAttribute="coleccion">
				<c:if test="${!empty coleccion}">
					<form:hidden path="codigo"/>
				</c:if>
				<div class="form-group">
						<form:label path="year" cssClass="control-label  col-xs-2"><spring:message code="form.year" text="Año"/></form:label>
						<div class="col-xs-4">
							<form:input type="text" path="year" cssClass="form-control" cssErrorClass="form-control text-danger"/>
						</div>
					<form:errors path="year" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
						<form:label path="gama" cssClass="control-label  col-xs-2"><spring:message code="form.gama" text="Gama"/></form:label>
						<div class="col-xs-4">
							<form:input type="text" path="gama" cssClass="form-control" cssErrorClass="form-control text-danger"/>
						</div>
					<form:errors path="gama" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="tematica" cssClass="control-label col-xs-2"><spring:message code="form.tematica" text="Tematica"/></form:label>
					<div class="col-xs-4">
						<form:input type="text" path="tematica" cssClass="form-control" cssErrorClass="text-danger"/>
					</div>
					<form:errors path="tematica" cssClass="text-danger col-xs-6"></form:errors>
					<input type = "file" id ="fichero" name = "fichero">
				</div>					
				<div class="form-group">
						<form:label path="fEntrada" cssClass="control-label  col-xs-2"><spring:message code="form.fEntrada" text="F. Entrada"/></form:label>
						<div class="col-xs-4">
							<form:input type="text" path="fEntrada" cssClass="form-control" cssErrorClass="text-danger"/>
						</div>
						<form:errors path="fEntrada" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
					<form:label cssClass="control-label col-xs-2" path="fabricante">Fabricante:</form:label>
					<div class="col-xs-4">
						<form:select cssClass="form-control" path="fabricante">
			               <form:option value="0" label="Elija un Fabricante"/>
							<form:options items="${listadoFabricantes}" itemValue="codigo" itemLabel="nombre" />
			            </form:select> 
		            </div>
		            <form:errors cssClass="text-error"  path="fabricante"/>   
				</div>
				
				<div class="form-group">
					<form:label cssClass="control-label col-xs-2" path="prendas">Prendas:</form:label>
					<div class="col-xs-4">
						<form:select multiple="true" cssClass="form-control" path="prendas">
							<form:options items="${listadoPrendas}" itemValue="codigo" itemLabel="nombre" />
			            </form:select> 
		            </div>
		            <form:errors cssClass="text-error"  path="prendas"/>   
				</div>		
				<div id = fabricante>
				
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


