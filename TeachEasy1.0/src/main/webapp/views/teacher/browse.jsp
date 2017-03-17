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

<display:table  name="teachers" id="teacherList" requestURI="${requestURI}" class="displaytag">
	
	<spring:message code="teacher.name" var="nameHeader"/>
	<display:column property="name" title="${nameHeader}"/>
	
	<spring:message code="teacher.surname" var="surnameHeader"/>
	<display:column property="surname" title="${surnameHeader}" sortable="true"/>
	
	

	<display:column titleKey="teacher.view">
		<a href="teacher/display.do?teacherId=${teacherList.teacher.id}">
		<spring:message code="teacher.view"></spring:message></a>	
	</display:column>
	
</display:table>