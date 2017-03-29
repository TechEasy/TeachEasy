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
	
	<acme:column code="request.rClass" property="rclass.title" sortable="false"/>
	<security:authorize access="hasRole('TEACHER') || hasRole('ACADEMY')">
	<display:column>
		<jstl:if test="${requestList.status == 'PENDING'}">
		<spring:message code="request.accept" var="accept" />
		<spring:message code="request.deny" var="deny" />
		<input type="button" name="accept" value="${accept}" onclick="javascript: window.location.replace('teacher/request/accept.do?requestId=${requestList.id}')" />
		<input type="button" name="deny" value="${deny}" onclick="javascript: window.location.replace('teacher/request/deny.do?requestId=${requestList.id}')" />
		</jstl:if>
	</display:column>	
		 </security:authorize>
</display:table>






