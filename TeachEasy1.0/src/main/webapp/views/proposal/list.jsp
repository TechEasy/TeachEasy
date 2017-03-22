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

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<display:table pagesize="5" class="displaytag" keepStatus="true" name="proposals" requestURI="${requestURI}" id="row">
	
	<!-- Action links -->
	
	<!-- Attributes -->
	
	<spring:message code="proposal.teacher.picture" var="teacher" />
		<display:column><img src="${row.teacher.picture}" width="60" height="60" ></display:column>
	
	<spring:message code="proposal.teacher" var="teacher" />
	<display:column property="teacher.name" title="${teacher}" sortable="false" />
	
	<spring:message code="proposal.teacher.surname" var="teacher" />
	<display:column property="teacher.surname" title="${teacher}" sortable="false" />
	
	<spring:message code="proposal.title" var="titleHeader"/>
	<display:column property="title" title="${titleHeader}" sortable="false" />

	<spring:message code="proposal.rate" var="rateHeader" />
	<display:column property="rate" title="${rateHeader}" sortable="false" />
	
	<spring:message code="proposal.teacher.avgStars" var="teacher" />
	<display:column property="teacher.avgStars" title="${teacher}" sortable="false" />

	<display:column>
		<a href="teacher/displayById.do?id=${row.id}"><spring:message code="finder.view.teacher" /></a>
	</display:column>
	<security:authorize access="hasRole('STUDENT')">
		<display:column title="Request">
			<a href="student/request/register.do?rClassId=${proposalList.id}">
				<spring:message	code="request.request" />
			</a>
		</display:column>		
	</security:authorize>
	</display:table>