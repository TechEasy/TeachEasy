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
		<a href="student/finder/edit.do?finderId=${row.id}"><spring:message code="finder.edit" /></a>
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

<display:table pagesize="5" class="displaytag" keepStatus="true" name="proposals" requestURI="${requestURI}" id="row">
	
	<!-- Action links -->
	
	<!-- Attributes -->
	
	<spring:message code="proposal.teacher.picture" var="teacher" />
		<display:column><img src="${row.teacher.picture}" width="60" height="60" ></display:column>
	
	<spring:message code="proposal.teacher" var="teacher" />
	<display:column property="teacher.name" title="${teacher}" sortable="false" />
	
	<spring:message code="proposal.teacher.surname" var="teacher" />
	<display:column property="teacher.surname" title="${teacher}" sortable="false" />
	
	<spring:message code="proposal.title" var="titleHeader"/>
	<display:column property="title" title="${titleHeader}" sortable="false" />

	<spring:message code="proposal.rate" var="rateHeader" />
	<display:column property="rate" title="${rateHeader}" sortable="false" />
	
	<spring:message code="proposal.teacher.avgStars" var="teacher" />
	<display:column property="teacher.avgStars" title="${teacher}" sortable="false" />

	<display:column>
		<a href="teacher/displayById.do?id=${row.id}"><spring:message code="finder.view.teacher" /></a>
	</display:column>
	</display:table>
	