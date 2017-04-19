<%--
 * list.jsp
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

<div class="col-md-12">
		<c:forEach items="${proposals}" var="proposal" >
		<div class="row">
		<div class="col-md-12">
		<div class="card-bordered">
			<div class="row">
				<div class="col-md-3">	
					<img src="${proposal.teacher.picture}"  width="200" height="200" class="img-responsive">
				</div>
				<div class="col-md-9 ">
					<h1>${proposal.title}</h1>
					<h2>${proposal.teacher.name} ${proposal.teacher.surname}</h2>
					<div class="row">
						<div class="col-md-6">
							<h3><spring:message code="proposal.rate" />: ${proposal.rate} $</h3>
						</div>
						<div class="col-md-6">
							<input id="star-teacher-${proposal.teacher.id}" name="star-teacher-${proposal.teacher.id}" value="${proposal.teacher.avgStars}" class="rating-loading" data-size="sm">
						</div>
					</div>
					<div class="row text-right">
						<div class="col-md-12 mt-lg pr-xl">
							<security:authorize access="hasRole('ADMIN') || hasRole('STUDENT') || hasRole('ACADEMY')">
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
		
		<!-- Create course -->
		<security:authorize access="hasRole('TEACHER')">
			<div>
				<a href="proposal/teacher/create.do" class="enlaceboton">
				<spring:message code="proposal.create" /></a>
			</div>
		</security:authorize>
</div>
<script>
	$(document).ready(function(){
	    $('[id^="star-teacher-"]').rating({displayOnly: true, step: 0.5});
	;
	});
</script>
