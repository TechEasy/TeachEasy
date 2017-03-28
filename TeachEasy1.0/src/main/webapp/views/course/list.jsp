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

<display:table pagesize="5" class="displaytag" keepStatus="true" name="courses" requestURI="${requestURI}" id="row">
	
	<spring:message code="course.academy.name" var="academy" />
	<display:column property="academy.name" title="${academy}" sortable="false" />
	
	<spring:message code="course.title" var="titleHeader"/>
	<display:column property="title" title="${titleHeader}"/>
	
	<spring:message code="course.rate" var="rateHeader"/>
	<display:column property="rate" title="${rateHeader}" sortable="true"/>
	
	<spring:message code="course.duration" var="durationHeader"/>
	<display:column property="duration" title="${durationHeader}" sortable="true"/>
	
	<spring:message code="course.level" var="levelHeader"/>
	<display:column property="level" title="${levelHeader}" sortable="true"/>
	
	<spring:message code="course.matter" var="matterHeader"/>
	<display:column property="subjectMatter.name" title="${matterHeader}" sortable="true"/>
	
	<spring:message code="course.avgStars" var="academy" />
	<display:column property="academy.avgStars" title="${academy}" sortable="false" />
	
	<security:authorize access="isAuthenticated()">
	<display:column>
		<a href="academy/displayById.do?id=${row.id}"><spring:message code="course.academy" /></a>
	</display:column>
	</security:authorize>
	<%--
	<display:column titleKey="proposal.teacher">
		<a href="teacher/display.do?teacherId=${proposalList.teacher.id}">
		<spring:message code="proposal.teacher"></spring:message></a>	
	</display:column>
	 --%>
</display:table>