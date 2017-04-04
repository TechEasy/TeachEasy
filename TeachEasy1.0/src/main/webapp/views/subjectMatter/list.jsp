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

<security:authorize access="hasRole('ADMIN') || hasRole('TEACHER') || hasRole('ACADEMY')">
	<display:table  name="subjectMatters" id="row" pagesize="5" requestURI="${requestedURI}" class="displaytag">

			<spring:message code="subjectMatter.name" var="name" />
			<display:column property="name" title="${name}" sortable="true" />
			
			<spring:message code="subjectMatter.description" var="description" />
			<display:column property="description" title="${description}" sortable="false" />
			
			<security:authorize access="hasRole('ADMIN')">
				<display:column>
					<jstl:if test="${!row.validated}">
						<a href="subjectMatter/administrator/accept.do?subjectMatterId=${row.id}"> 
						<spring:message code="subjectMatter.accept" />
						</a><br/>
						
						<a href="subjectMatter/administrator/deny.do?subjectMatterId=${row.id}"> 
						<spring:message code="subjectMatter.deny" />
						</a><br/>
					</jstl:if>
				</display:column>
			</security:authorize>
			
	</display:table>
</security:authorize>
<security:authorize access="hasRole('TEACHER') || hasRole('ACADEMY')">
	<div>
		<a href="subjectMatter/create.do">
			<spring:message	code="subjectMatter.create" />
		</a>
	</div>
</security:authorize>
