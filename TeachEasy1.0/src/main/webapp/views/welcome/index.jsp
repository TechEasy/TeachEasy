<%--
 * index.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<security:authorize access="isAnonymous() || hasRole('TEACHER') || hasRole('ADMIN')">
<div class="row text-center hidden-lg">
	<div class="col-md-12 ">
		<img src="images/logo.png" alt="TeachEasy Co., Inc." width="300" height="250" />
	</div>
</div>
</security:authorize>

<security:authorize access="isAnonymous() || hasRole('TEACHER') || hasRole('ADMIN')">
<div class="row text-center visible-lg">
	<div class="col-md-12 ">
		<img src="images/banner.png" alt="TeachEasy Co., Inc." width="1000" height="563" />
	</div>
</div>
</security:authorize>

<security:authorize access="hasRole('STUDENT')">
<div class="col-md-12">
	<div class="row">
		<div class="col-md-12 text-center">
			<H3><spring:message code="welcome.message"/></H3>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
		<div class="card-bordered">
			<h3><spring:message code="welcome.academy"/></h3>
			<div class="row">
				<div class="col-md-3">
					<img src="${academy.picture}" width="100" height="100" class="img-responsive" >
				</div>
				<div class="col-md-9">
					<h4><jstl:out value="${academy.name}"/></h4>
					<table>
					  <tr>
					    <td>
					      <input id="star-teacher-${academy.id}" name="star-teacher-${academy.id}" value="${academy.avgStars}" class="rating-loading" data-size="xs">
					    </td>
					  </tr>
					</table>
					<a class="btn btn-primary float-right" href="academy/displayById.do?id=${academy.id}"><spring:message code="finder.view.academy" /></a>
				</div>
			</div>
		</div>	
		</div>
		<div class="col-md-6">
		<div class=" card-bordered">
			<h3><spring:message code="welcome.teacher"/></h3>
			<div class="row">
				<div class="col-md-3">
					<img src="${teacher.picture}" width="100" height="100" class="img-responsive" >
				</div>
				<div class="col-md-9">
					<h4><jstl:out value="${teacher.name}"/><jstl:out value="${teacher.surname}"/></h4>
					<table>
					  <tr>
					    <td>
					      <input id="star-teacher-${teacher.id}" name="star-teacher-${teacher.id}" value="${teacher.avgStars}" class="rating-loading" data-size="xs">
					    </td>
					  </tr>
					</table>
					<a class="btn btn-primary float-right" href="teacher/displayById.do?id=${teacher.id}"><spring:message code="finder.view.teacher" /></a>
				</div>
			</div>
		</div>
		</div>
	</div>
</div>
</security:authorize>

<script>
	$(document).ready(function(){
	    $('[id^="star-teacher-"]').rating({displayOnly: true, step: 0.5});
	;
	});
</script>
