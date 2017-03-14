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

<form:form action="${requestURI}" modelAttribute="studentForm">
	<jstl:if test="${studentForm.id==0 || studentForm.username == pageContext.request.remoteUser}">
		<form:hidden path="id"/>
			<fieldset>
				<legend align="left"><spring:message code="student.account.info"/></legend>
				<acme:textbox code="student.username" path="username" />
				<br/>
				<acme:password code="student.password" path="password"/>
				<br/>
				<acme:password code="student.password2" path="password2"/>
			
				<br/>
				<form:checkbox path="agreed"/>
				<form:label path="agreed">
					<spring:message code="student.register.agree" />
					<a href="misc/lopd.do"><spring:message code="student.register.agree.2"/></a>
				</form:label>
				<form:errors path="agreed" cssClass="error" />
				<br/>
			</fieldset>
			<fieldset>
				<legend align="left"><spring:message code="student.personal.info"/></legend>
				<br/>
				<acme:textbox code="student.name" path="name" />
				<br/>
				<acme:textbox code="student.surname" path="surname"/>
				<br/>
				<acme:textbox code="student.email" path="email"/>
				<br/>
				<acme:textbox code="student.phone" path="phone"/>
				<br/>
				<acme:textbox code="student.picture" path="picture"/>
				<br/>
				<acme:textbox code="student.date" path="date"/>
				<br/>
				<acme:textbox code="student.city" path="city"/>
				<br/>
				<acme:textbox code="student.address" path="address"/>
				<br/>
				<fieldset>
					<legend align="left"><spring:message code="student.creditCard.info"/></legend>
					<acme:textbox code="student.creditCard.holderName" path="creditCard.holderName"/>
					<br/>			
					<acme:textbox code="student.creditCard.brandName" path="creditCard.brandName"/>
					<br/>		
					<acme:textbox code="student.creditCard.number" path="creditCard.number"/>
					<br/>			
					<acme:textbox code="student.creditCard.expirationMonth" path="creditCard.expirationMonth"/>
					<br/>			
					<acme:textbox code="student.creditCard.expirationYear" path="creditCard.expirationYear"/>
					<br/>	
					<acme:textbox code="student.creditCard.cvv" path="creditCard.cvv"/>
				</fieldset>
			</fieldset>

	<br/>
	<acme:submit name="save" code="student.save"/>
	<acme:cancel code="student.cancel" url="welcome/index.do" />
	</jstl:if>
</form:form>

