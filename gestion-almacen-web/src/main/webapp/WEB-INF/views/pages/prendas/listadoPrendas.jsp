<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>    


	<section class="row">
		<header class="col-xs-12"><h2>Servicio Listado Prendas </h2></header>
		<div>
		
		</div>
	</section>

<script>
 		const url="http://localhost:8080/gestionalmacen/api/prendas";
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
			  
		});
</script>

