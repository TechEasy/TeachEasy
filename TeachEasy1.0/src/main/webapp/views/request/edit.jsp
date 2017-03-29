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

<div class="col-md-3"></div>
<div class="col-md-6">
<div class="panel panel-default">
<div class="panel-body payment-form">
<form:form action ="student/request/register.do" modelAttribute="requestForm">

	<form:hidden path="rclassId"/>
	<div class="row">
		<div class="col-md-12">
			<acme:textbox code="request.checkin" path="checkIn"/>			
		</div>

	</div>
	<div class="row">
		<div class="col-md-12">
			<acme:textbox code="request.checkout" path="checkOut"/>				
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<acme:submit name="save" code="request.save"/>			
		</div>
		<div class="col-md-3">
			<acme:cancel url="proposal/list.do" code="request.cancel"/>			
		</div>
		<div class="col-md-3">
		
		</div>
	</div>
	<br/>

</form:form>
</div>
</div>
</div>
<div class="col-md-3"></div>
