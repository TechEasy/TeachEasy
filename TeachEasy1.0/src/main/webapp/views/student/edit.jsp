<%--
 * edit.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="student/edit.do" modelAttribute="studentForm">

	<form:hidden path="studentForm.id" />

	<fieldset>
		<legend>
			<spring:message code="student.accountDetails" />
		</legend>
		<jstl:choose>
			<jstl:when test="${studentForm.student.id != 0}">
				<acme:textbox path="student.userAccount.username"
					code="student.username" readonly="true" />
			</jstl:when>
			<jstl:otherwise>
				<acme:textbox path="student.userAccount.username"
					code="student.username" />
			</jstl:otherwise>
		</jstl:choose>
		<jstl:choose>
			<jstl:when test="${studentForm.student.id==0}">
				<acme:password code="student.password"
					path="student.userAccount.password" />
				<acme:password code="student.password" path="passwordCheck" />
			</jstl:when>
			<jstl:otherwise></jstl:otherwise>
		</jstl:choose>
	</fieldset>
	<fieldset>
		<legend>
			<spring:message code="student.personalInfo" />
		</legend>
		<acme:textbox code="student.name" path="student.name" />
		<acme:textbox code="student.surname" path="student.surname" />
		<acme:textbox code="student.email" path="student.email" />
		<acme:textbox code="student.phone" path="student.phone" />
		<acme:textbox code="student.address" path="student.address" />
		<acme:textbox code="student.city" path="student.city" />
		<acme:textbox code="student.picture" path="student.picture" />
		<acme:textbox code="student.paypalMail" path="student.paypalMail" />
		
	</fieldset>

 <br/>
   <jstl:if test="${studentForm.student.id == 0}">
   	<form:label path="conditions">
	<spring:message code="actor.legal.accept"/> - <a href="welcome/legal.do"><spring:message code="actor.legal.moreinfo"/></a>
	</form:label>
	<form:checkbox id="conditions" path="conditions"/>
	<form:errors cssClass="error" path="conditions"/>
   </jstl:if>
 <br/>
   
	<!-- Buttons -->
	<br />
	<input type="submit" name="save"
		value="<spring:message code="student.save" />" />&nbsp; 
		
	<acme:cancel code="student.cancel" url="/welcome/index.do" />


</form:form>