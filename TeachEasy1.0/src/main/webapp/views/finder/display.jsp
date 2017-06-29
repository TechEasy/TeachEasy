<%--
 * display.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<security:authorize access="hasRole('STUDENT')">
<div class="col-md-12">
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-body payment-form">
					<form:form	action="student/finder/edit.do"	modelAttribute="finder"> 
					<div class="row">
						<div class="col-md-12">
							<div class="row">
								<div class="col-md-12">
									<p><spring:message code="finder.cityNotOptional" /></p>
								</div>
							</div>	
							<div class="row">
								<div class="col-md-3">
									<acme:textbox code="finder.city" path="city"/>		
								</div>
								<div class="col-md-3">
									<acme:textbox code="finder.matter" path="matter"/>		
								</div>
								<div class="col-md-2">		
									<acme:textbox code="finder.keyword" path="keyword"/>
								</div>
								<div class="col-md-2">
									<acme:textbox code="finder.minimumPrice" path="minimumPrice"/>		
								</div>
								<div class="col-md-2">
									<acme:textbox code="finder.maximumPrice" path="maximumPrice"/>	
								</div>
							</div>
						</div>
							</div>
							<div class="row">
								<div class="col-md-2">
									<acme:cancel url="student/finder/display.do" code="finder.cancel"/>		
								</div>
								<div class="col-md-6">
												
								</div>
								<div class="col-md-4">
									<acme:submit name="save" code="finder.edit"/>	
								</div>
							</div>
						</form:form>
					</div>
			</div>
		</div>
	</div>
	 <jstl:if test="${aux==true}">
	 <h3><spring:message code="finder.nothingFound"/></h3>
	 </jstl:if>
	<div class="row">
		<div class="col-md-12" id="contenedor-tarjetas">
		<c:forEach items="${proposals}" var="proposal" >
		<div class="row paginador-item">
		<div class="col-md-12">
			<div class="card-bordered">
				<div class="row">
				<div class="col-md-3 text-center">	
					<img src="${proposal.teacher.picture}"  width="200" height="200" class="img-responsive">
				</div>
				<div class="col-md-9 ">
					<h1>${proposal.title}</h1>
					<h2>${proposal.teacher.name} ${proposal.teacher.surname}</h2>
					<div class="row">
						<div class="col-md-6">
							<h3><spring:message code="proposal.rate" />: ${proposal.rate} Eur.</h3>
						</div>
						<div class="col-md-6">
							<input id="star-teacher-${proposal.teacher.id}" name="star-teacher-${proposal.teacher.id}" value="${proposal.teacher.avgStars}" class="rating-loading" data-size="sm">
						</div>
					</div>
					<div class="row text-right">
						<div class="col-md-12 mt-lg pr-xl">
							<security:authorize access="hasRole('TEACHER') || hasRole('ADMIN') || hasRole('STUDENT') || hasRole('ACADEMY')">
								<a class="btn btn-primary" href="teacher/displayById.do?id=${proposal.teacher.id}"><spring:message code="finder.view.teacher" /></a>
							</security:authorize>
							<security:authorize access="hasRole('STUDENT')">
							<a class="btn btn-primary" href="student/request/register.do?rClassId=${proposal.id}"><spring:message	code="request.request" /></a>
							</security:authorize>
						</div>
					</div>
				</div>
				</div>
			</div>
			</div>
			</div>
		</c:forEach>
		</div>
	</div>
</div>

</security:authorize>
<script>
	$(document).ready(function(){
	    $('[id^="star-teacher-"]').rating({displayOnly: true, step: 0.5});
	    $ ('#contenedor-tarjetas').easyPaginate({
	    	paginateElement: 'div.paginador-item',
	    	elementsPerPage: 5,
	    	effect: 'climb'
	    });
	});
</script>