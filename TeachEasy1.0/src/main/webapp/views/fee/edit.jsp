<%--
 * edit.jsp
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
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<form:form action = "administrator/fee/edit.do" modelAttribute="fee">
	<form:hidden path="id"/>
	<form:hidden path="version"/>
	<acme:textbox code="fee.teacher" path="valueTeacher"/>	
	<acme:textbox code="fee.academy" path="valueAcademy"/>
			
	<br/>

	<!-- Buttons -->
	<acme:submit name="save" code="fee.save"/>
	&nbsp; 
	<acme:cancel url="welcome/index.do" code="fee.cancel"/>
		
	<br/>
	<br/>

</form:form>