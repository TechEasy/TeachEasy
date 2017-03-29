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

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<security:authorize access="hasRole('STUDENT')">

<div class="col-md-3"></div>
<div class="col-md-6">
<div class="panel panel-default">
<div class="panel-body payment-form">
	<form:form	action="student/finder/edit.do"	modelAttribute="finder"> 
	<div class="row">
		<div class="col-md-12">
			<acme:textbox code="finder.city" path="city"/>			
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<acme:textbox code="finder.matter" path="matter"/>		
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<acme:textbox code="finder.minimumPrice" path="minimumPrice"/>		
		</div>
		<div class="col-md-6">
			<acme:textbox code="finder.maximumPrice" path="maximumPrice"/>	
		</div>
	</div>
	<acme:textbox code="finder.keyword" path="keyword"/>
	<div class="row">
		<div class="col-md-6">
			<acme:submit name="save" code="finder.edit"/>			
		</div>
		<div class="col-md-3">
			<acme:cancel url="student/finder/display.do" code="finder.cancel"/>			
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

</security:authorize>

