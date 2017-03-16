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

<display:table name="finder"
	id="row"
	class="displaytag"
	pagesize="5">
	
	<security:authorize access="hasRole('STUDENT')">
	
	<display:column>
		<a href="student/finder/edit2.do?finderId=${row.id}"><spring:message code="finder.edit" /></a>
	</display:column>			
	
					
	<spring:message code="finder.city" var="cityHeader" />
	<display:column property="city" title="${cityHeader}" sortable="false"/>
	
	<spring:message code="finder.minimumPrice" var="minimumPriceHeader" />
	<display:column property="minimumPrice" title="${minimumPriceHeader}" sortable="true"/>
	
	<spring:message code="finder.maximumPrice" var="maximumPriceHeader" />
	<display:column property="maximumPrice" title="${maximumPriceHeader}" sortable="true"/>
	
	<spring:message code="finder.keyword" var="keywordHeader"/>
	<display:column property="keyword" title="${keywordHeader}" sortable="false"/>
	
	<spring:message code="finder.matter" var="matterHeader"/>
	<display:column property="matter" title="${matterHeader}" sortable="false"/>
	
	</security:authorize>

</display:table>


	<display:table pagesize="5" class="displaytag" keepStatus="true" name="courses" requestURI="${requestURI}" id="row">
	
	<!-- Action links -->
	
	<!-- Attributes -->
	<spring:message code="course.academy" var="academy" />
	<display:column property="academy.name" title="${academy}" sortable="false" />
	
	<spring:message code="course.title" var="titleHeader"/>
	<display:column property="title" title="${titleHeader}" sortable="false" />

	<spring:message code="course.rate" var="rateHeader" />
	<display:column property="rate" title="${rateHeader}" sortable="true" />

	
	<display:column>
		<a href="academy/display.do?courseId=${row.id}"><spring:message code="finder.view.academy" /></a>
	</display:column>
	
	
	
	
</display:table>