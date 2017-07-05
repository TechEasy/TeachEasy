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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<jstl:if test="${msg!=null }">
<h3 style="color:red;"><spring:message code="${msg}"></spring:message></h3>
</jstl:if>

<div class="col-md-12">
<div class="row">
	<div class="col-md-12">
	<div class="table-responsive">
	<table class="table table-striped">
		<thead>
	      <tr>
	        <th><spring:message code="RegisterSocialIdentity.nickHeader"/></th>
	        <th><spring:message code="RegisterSocialIdentity.socialNetworkHeader"/></th>
	        <th><spring:message code="RegisterSocialIdentity.profileUrl"/></th>
	        <th><spring:message code="RegisterSocialIdentity.Edit" /></th>
	      </tr>
	    </thead>
	    <tbody>
		<c:forEach items="${socialIdentity}" var="socialIdentity" >
	      <jstl:if test="${socialIdentity.id != null}">
	      <tr>    
	        <td>${socialIdentity.nick}</td>
	        <td>${socialIdentity.socialNetwork}</td>
	        <td>${socialIdentity.profileUrl}</td>
	       	<td><a class="btn btn-primary" href="socialIdentity/edit.do?socialIdentityId=${socialIdentity.id}"><spring:message code="RegisterSocialIdentity.Edit" /></a></td>
	      </tr>
	      </jstl:if>
	    </c:forEach>
	    </tbody>
	</table>
	</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<a class="btn btn-primary" href="socialIdentity/create.do"><spring:message code="RegisterSocialIdentity.Create" /></a>
	</div>
</div>
</div>
