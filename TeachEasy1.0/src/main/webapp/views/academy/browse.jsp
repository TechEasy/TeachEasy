<%--
 * action-1.jsp
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
		<c:forEach items="${academies}" var="academy" >
			<div class="row">
				<div class="col-md-3 text-center">	
					<img src="${academy.picture}" class="img-responsive">
				</div>
				<div class="col-md-9 ">
					<h1>${academy.name}</h1>
					<div class="row">
						<div class="col-md-6">
							<h3><spring:message code="academy.city" />: ${academy.city}</h3>
						</div>
						<div class="col-md-6">
							<h3><spring:message code="academy.address" />: ${academy.address}</h3>
						</div>
					</div>
					<h3><spring:message code="academy.avgStars" />: ${academy.avgStars}</h3>
					<security:authorize access="hasRole('TEACHER') || hasRole('ADMIN') || hasRole('STUDENT') || hasRole('ACADEMY')">
					<div class="row text-right">
						<div class="col-md-12 mt-lg pr-xl">
							<a class="btn btn-primary" href="academy/displayById.do?id=${academy.id}"><spring:message code="finder.view.academy" /></a>
						</div>
					</div>
					</security:authorize>
				</div>
			</div>
			<hr class="divider"/>
		</c:forEach>
</div>