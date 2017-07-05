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
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<div class="col-md-3"></div>
<div class="col-md-6">
<form:form action="socialIdentity/edit.do" modelAttribute="socialIdentity">

	<form:hidden path="id"/>
	
	<acme:textbox code="RegisterSocialIdentity.nick" path="nick"/>
	<acme:textbox code="RegisterSocialIdentity.socialNetworkHeader" path="socialNetwork"/>
	<acme:textbox code="RegisterSocialIdentity.profileUrlHeader" path="profileUrl"/>
	
	<div class="row">
		<div class="col-md-3"><acme:cancel url="socialIdentity/list.do" code="RegisterSocialIdentity.cancel"/></div>
		<div class="col-md-3"></div>
		
		<div class="col-md-6">
			<acme:submit name="save" code="RegisterSocialIdentity.save"/>
			<jstl:if test="${socialIdentity.id!=0 }">
				<acme:delete name="delete" code="RegisterSocialIdentity.delete"/>
			</jstl:if>
		</div>
	</div>

</form:form>
</div>
<div class="col-md-3"></div>