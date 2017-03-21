<%--
 * register.jsp
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
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<form:form action="${requestURI}" modelAttribute="academyForm">
	<jstl:if test="${academyForm.id==0 || academyForm.username == pageContext.request.remoteUser}">
		<form:hidden path="id"/>
			<fieldset>
				<legend align="left"><spring:message code="academy.account.info"/></legend>
				<acme:textbox code="academy.username" path="username" />
				<br/>
				<acme:password code="academy.password" path="password"/>
				<br/>
				<acme:password code="academy.password2" path="password2"/>
			
				<br/>
				<form:checkbox path="agreed"/>
				<form:label path="agreed">
					<spring:message code="academy.register.agree" />
					<a href="misc/lopd.do"><spring:message code="academy.register.agree.2"/></a>
				</form:label>
				<form:errors path="agreed" cssClass="error" />
				<br/>
			</fieldset>
			<fieldset>
				<legend align="left"><spring:message code="academy.personal.info"/></legend>
				<br/>
				<acme:textbox code="academy.name" path="name" />
				<br/>
				<acme:textbox code="academy.city" path="city"/>
				<br/>
				<acme:textbox code="academy.address" path="address"/>
				<br/>
				<acme:textbox code="academy.description" path="description"/>
				<br/>
				<acme:textbox code="academy.cif" path="cif"/>
				<br/>
				
				<fieldset>
					<legend align="left"><spring:message code="academy.iban.info"/></legend>
					<acme:textbox code="academy.iban" path="iban"/>
					<br/>			
				</fieldset>
			</fieldset>

	<br/>
	<acme:submit name="save" code="academy.save"/>
	<acme:cancel code="academy.cancel" url="welcome/index.do" />
	</jstl:if>
</form:form>

