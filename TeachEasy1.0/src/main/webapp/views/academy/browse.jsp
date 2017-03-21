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

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<display:table  name="academies" id="row" requestURI="${requestURI}" class="displaytag">
	
	<spring:message code="academy.name" var="nameHeader"/>
	<display:column property="name" title="${nameHeader}"/>
	
	<spring:message code="academy.city" var="cityHeader"/>
	<display:column property="city" title="${cityHeader}" sortable="true"/>
	
	<spring:message code="academy.description" var="descriptionHeader"/>
	<display:column property="description" title="${descriptionHeader}" sortable="false"/>
	
	<spring:message code="academy.avgStars" var="avgStarsHeader"/>
	<display:column property="avgStars" title="${avgStarsHeader}" sortable="true"/>
	
	
	<security:authorize access="isAuthenticated()">
	<display:column titleKey="academy.view">
		<a href="academy/displayById.do?id=${row.id}">
		<spring:message code="academy.view"></spring:message></a>	
	</display:column>
	</security:authorize>
	
</display:table>