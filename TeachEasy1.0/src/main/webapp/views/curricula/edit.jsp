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

<div class="col-md-12">

<form:form action = "teacher/curricula/edit.do" modelAttribute="curricula">
		
	<acme:textbox code="curricula.educationSection" path="educationSection"/>
	<acme:textbox code="curricula.experienceSection" path="experienceSection"/>
	<acme:textbox code="curricula.hobbiesSection" path="hobbiesSection"/>
			
	<br/>

	<!-- Buttons -->
	<div class="row">
		<div class="col-md-3">
			<acme:cancel url="welcome/index.do" code="curricula.cancel"/>
		</div>
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<acme:submit name="save" code="curricula.save"/>
		</div>
	</div>

</form:form>

</div>