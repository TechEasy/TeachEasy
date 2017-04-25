<%--
 * list.jsp
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
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<display:table name="socialIdentity" id="row" requestURI="socialIdentity/list.do"  pagesize="5" class="displaytag">
	
	<acme:column code="RegisterSocialIdentity.nickHeader" property="nick"/>
	<acme:column code="RegisterSocialIdentity.socialNetworkHeader" property="socialNetwork"/>

	<spring:message code="RegisterSocialIdentity.profileUrl" var="profileUrlVAR" />
	<display:column title="${ profileUrlVAR}">
		
		<a href="${row.profileUrl}"> ${row.profileUrl}</a>
	</display:column> 
	
	
	<display:column>
		<spring:message code="RegisterSocialIdentity.Edit" var="Edit"/>
		<a href="socialIdentity/edit.do?socialIdentityId=${row.id}"> <spring:message code="RegisterSocialIdentity.Edit" /></a>
	</display:column> 

</display:table>

<p><a href="socialIdentity/create.do"><spring:message code="RegisterSocialIdentity.Create" /></a></p>
