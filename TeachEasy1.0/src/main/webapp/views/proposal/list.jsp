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

<display:table  name="proposals" id="proposalList" pagesize="5" requestURI="proposal/list.do" class="displaytag">
	
	<spring:message code="proposal.title" var="titleHeader"/>
	<display:column property="title" title="${titleHeader}" sortable="false"/>
	
	<spring:message code="proposal.createMoment" var="createMomentHeader"/>
	<display:column property="createMoment" title="${createMomentHeader}" sortable="true"/>
	
	<spring:message code="proposal.updateMoment" var="updateMomentHeader"/>
	<display:column property="updateMoment" title="${updateMomentHeader}" sortable="true"/>
	
	<spring:message code="proposal.rate" var="rateHeader"/>
	<display:column property="rate" title="${rateHeader}" sortable="true" />
	
	<spring:message code="proposal.matter" var="matterHeader"/>
	<display:column property="subjectMatter.name" title="${matterHeader}" sortable="true"/>
	
	<security:authorize access="isAuthenticated()">
	<display:column titleKey="proposal.teacher">
		<a href="teacher/displayById.do?id=${proposalList.teacher.id}">
		<spring:message code="proposal.teacher"></spring:message></a>	
	</display:column>
	</security:authorize>
	
	<security:authorize access="hasRole('STUDENT')">
		<display:column title="Request">
			<a href="request/student/request.do?rClassId=${proposalList.id}">
				<spring:message	code="request.request" />
			</a>
		</display:column>		
	</security:authorize>
	
</display:table>