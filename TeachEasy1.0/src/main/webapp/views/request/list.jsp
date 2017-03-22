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
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<display:table pagesize="5" class="displaytag" name="requests" requestURI="request/student/list.do" id="requestList">	
	
	<acme:column code="request.checkin" property="checkIn" sortable="true"/>
	
	<acme:column code="request.checkout" property="checkOut" sortable="true"/>
			
	<acme:column code="request.status" property="status" sortable="true"/>
	
	<acme:column code="request.rClass" property="rClass.title" sortable="false"/>
		<%--
	<display:column>
		<jstl:if test="${row.status == 'PENDING'}">
		<spring:message code="bookrequest.accept" var="accept" />
		<spring:message code="bookrequest.deny" var="deny" />
		<input type="button" name="addCategory" value="${accept}" onclick="javascript: window.location.replace('request/lessor/accept.do?bookRequestId=${row.id}')" />
		<input type="button" name="addCategory" value="${deny}" onclick="javascript: window.location.replace('request/lessor/deny.do?bookRequestId=${row.id}')" />
		</jstl:if>
	</display:column>	
		 --%>			
</display:table>






