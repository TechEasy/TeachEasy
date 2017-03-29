<%--
 * display.jsp
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

<display:table pagesize="5" class="displaytag" keepStatus="true" name="invoices" requestURI="${requestURI}" id="row">
	
	<!-- Action links -->
	
	<!-- Attributes -->
	
	<spring:message code="invoice.authoredMoment" var="authoredMoment" />
		<display:column property="authoredMoment" title="${authoredMoment}" sortable="false" />
	
	<spring:message code="invoice.vatNumber" var="vatNumber" />
	<display:column property="vatNumber" title="${vatNumber}" sortable="false" />
	
	<spring:message code="invoice.information" var="information" />
	<display:column property="information" title="${information}" sortable="false" />
	
	<spring:message code="invoice.details" var="details"/>
	<display:column property="details" title="${details}" sortable="false" />

	<spring:message code="invoice.total" var="total" />
	<display:column property="total" title="${total}" sortable="false" />
	
	<display:column>
		<a href="student/invoice/display.do?invoiceId=${row.id}"><spring:message code="invoice.display" /></a>
	</display:column>
	</display:table>