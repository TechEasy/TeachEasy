<%--
 * edit.jsp
 *
 * Copyright (C) 2016 Universidad de Sevilla
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


<form:form action ="student/request/register.do" modelAttribute="requestForm">

	<form:hidden path="rClassId"/>
	
	<fieldset>
			<legend><spring:message code="request.request"/></legend>
			
			<acme:textbox code="request.checkin" path="checkIn"/>			
			<acme:textbox code="request.checkout" path="checkOut"/>		
				
	</fieldset>				
	<br/>
	
	<!-- Buttons -->
	
	<acme:submit name="save" code="request.save"/>	
	<acme:cancel url="proposal/list.do" code="request.cancel"/>
	
</form:form>
