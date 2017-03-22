<%--
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


<form:form action = "request/student/request.do" modelAttribute="request">

	<form:hidden path="id"/>
	<form:hidden path="rClass"/>

	<fieldset>		
		<acme:textbox code="request.checkin" path="checkin"/>
		<acme:textbox code="request.checkout" path="checkout"/>
		<acme:textbox code="request.day" path="day"/>
		<form:hidden path="status"/>
	</fieldset>
<%--
	<fieldset>
		<legend><spring:message code="request.creditCard"/></legend>
		
		<acme:textbox code="creditCard.number" path="creditcard.number"/>
		<acme:textbox code="creditCard.holderName" path="creditcard.holderName"/>
		<acme:textbox code="creditCard.brandName" path="creditcard.brandName"/>
		<acme:textbox code="creditCard.cvv" path="creditcard.cvv"/>
		<acme:textbox code="creditCard.expirationMonth" path="creditcard.expirationMonth"/>
		<acme:textbox code="creditCard.expirationYear" path="creditcard.expirationYear"/>	
	</fieldset>			
	<br/>
--%>
	<!-- Buttons -->
	
	<input type="submit" name="save" value="<spring:message code="request.save" />" />&nbsp; 
	
	<input type="button" name="cancel" value="<spring:message code="request.cancel" />"
		onclick="javascript: window.location.replace('proposal/list.do')" />
		
</form:form>