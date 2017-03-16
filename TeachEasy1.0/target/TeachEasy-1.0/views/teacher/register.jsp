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

<form:form action="${requestURI}" modelAttribute="teacherForm">
	<jstl:if test="${teacherForm.id==0 || teacherForm.username == pageContext.request.remoteUser}">
		<form:hidden path="id"/>
			<fieldset>
				<legend align="left"><spring:message code="teacher.account.info"/></legend>
				<acme:textbox code="teacher.username" path="username" />
				<br/>
				<acme:password code="teacher.password" path="password"/>
				<br/>
				<acme:password code="teacher.password2" path="password2"/>
			
				<br/>
				<form:checkbox path="agreed"/>
				<form:label path="agreed">
					<spring:message code="teacher.register.agree" />
					<a href="misc/lopd.do"><spring:message code="teacher.register.agree.2"/></a>
				</form:label>
				<form:errors path="agreed" cssClass="error" />
				<br/>
			</fieldset>
			<fieldset>
				<legend align="left"><spring:message code="teacher.personal.info"/></legend>
				<br/>
				<acme:textbox code="teacher.name" path="name" />
				<br/>
				<acme:textbox code="teacher.surname" path="surname"/>
				<br/>
				<acme:textbox code="teacher.email" path="email"/>
				<br/>
				<acme:textbox code="teacher.phone" path="phone"/>
				<br/>
				<acme:textbox code="teacher.picture" path="picture"/>
				<br/>
				<acme:textbox code="teacher.date" path="date"/>
				<br/>
				<acme:textbox code="teacher.city" path="city"/>
				<br/>
				<acme:textbox code="teacher.address" path="address"/>
				<br/>
				<fieldset>
					<legend align="left"><spring:message code="teacher.iban.info"/></legend>
					<acme:textbox code="teacher.iban" path="iban"/>
					<br/>			
				</fieldset>
			</fieldset>

	<br/>
	<acme:submit name="save" code="teacher.save"/>
	<acme:cancel code="teacher.cancel" url="welcome/index.do" />
	</jstl:if>
</form:form>

