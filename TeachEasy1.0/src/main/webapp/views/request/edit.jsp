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


<form:form action ="request/student/edit.do" modelAttribute="request">

	<form:hidden path="id"/>
	<form:hidden path="rClass"/>
	
	<fieldset>
			<legend><spring:message code="request.request"/></legend>
			
			<acme:textbox code="request.checkin" path="checkin"/>
			
			<acme:textbox code="request.checkout" path="checkout"/>
			
			<acme:checkbox code="request.day" path="day"/>
			
			<acme:textbox code="request.status" path="status"/>	
	</fieldset>
	<br/>

	<!-- Buttons -->
	
	<acme:submit name="save" code="request.save"/>
	
	<jstl:if test="${request.id != 0}">	
		<input type="submit" name="delete" value="<spring:message code="request.delete" />"
			onclick="return confirm('<spring:message code="request.confirm.delete" />')" />&nbsp;
	</jstl:if>
	<acme:cancel url="proposal/list.do" code="request.cancel"/>
	
</form:form>