<%--
 * action-1.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<div class="col-md-12">
		<c:forEach items="${teachers}" var="teacher" >
			<div class="row">
				<div class="col-md-3 text-center">	
					<img src="${teacher.picture}" class="img-responsive">
				</div>
				<div class="col-md-9 ">
					<h1>${teacher.name} ${teacher.surname}</h1>
					<h3><spring:message code="teacher.date" />: ${teacher.date}</h3>
					<div class="row">
						<div class="col-md-6">
							<h3><spring:message code="teacher.city" />: ${teacher.city}</h3>
						</div>
						<div class="col-md-6">
							<h3><spring:message code="teacher.address" />: ${teacher.address}</h3>
						</div>
					</div>
					<h3></h3>
					<h3><spring:message code="teacher.avgStars" />: ${teacher.avgStars}</h3>
					<label for="star-teacher-${teacher.id}" class="control-label">Rate This</label>
					<input id="star-teacher-${teacher.id}" name="star-teacher-${teacher.id}" class="rating rating-loading" data-min="0" data-max="5" data-step="0.1" data-size="xs">
					<security:authorize access="hasRole('TEACHER') || hasRole('ADMIN') || hasRole('STUDENT') || hasRole('ACADEMY')">
					<div class="row text-right">
						<div class="col-md-12 mt-lg pr-xl">
							<a class="btn btn-primary" href="teacher/displayById.do?id=${teacher.id}"><spring:message code="finder.view.teacher" /></a>
						</div>
					</div>
					</security:authorize>
				</div>
			</div>
			<hr class="divider"/>
		</c:forEach>
</div>
<script>
	$(document).ready(function(){
		$('[id^="star-teacher-"]').on('rating.change', function(event, value, caption) {
			var id = $ (this).attr ("id");
			var idExplode = id.split ('-');
			id = idExplode [2];
			console.log ("Id: " + id + ". Value: " + value);
		});
	});
	
	
</script>