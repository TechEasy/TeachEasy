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

<display:table  name="courses" id="courseList" requestURI="${requestURI}" class="displaytag">
	
	<spring:message code="course.title" var="titleHeader"/>
	<display:column property="title" title="${titleHeader}"/>
	
	<spring:message code="course.createMoment" var="createMomentHeader"/>
	<display:column property="createMoment" title="${createMomentHeader}" sortable="true"/>
	
	<spring:message code="course.updateMoment" var="updateMomentHeader"/>
	<display:column property="updateMoment" title="${updateMomentHeader}" sortable="true"/>
	
	<spring:message code="course.rate" var="rateHeader"/>
	<display:column property="rate" title="${rateHeader}"/>
	
	<spring:message code="course.duration" var="durationHeader"/>
	<display:column property="duration" title="${durationHeader}"/>
	
	<spring:message code="course.level" var="levelHeader"/>
	<display:column property="level" title="${levelHeader}"/>
	
	<spring:message code="course.matter" var="matterHeader"/>
	<display:column property="subjectMatter.name" title="${matterHeader}"/>
	
	<%--
	<display:column titleKey="proposal.teacher">
		<a href="teacher/display.do?teacherId=${proposalList.teacher.id}">
		<spring:message code="proposal.teacher"></spring:message></a>	
	</display:column>
	 --%>
</display:table>