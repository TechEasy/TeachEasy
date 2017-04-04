<%--
 * action-1.jsp
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

<form:form action="teacher/edit.do" modelAttribute="teacherForm">

	<form:hidden path="teacherForm.id" />

	<fieldset>
		<legend>
			<spring:message code="teacher.accountDetails" />
		</legend>
		<jstl:choose>
			<jstl:when test="${teacherForm.teacher.id != 0}">
				<acme:textbox path="teacher.userAccount.username"
					code="teacher.username" readonly="true" />
			</jstl:when>
			<jstl:otherwise>
				<acme:textbox path="teacher.userAccount.username"
					code="teacher.username" />
			</jstl:otherwise>
		</jstl:choose>
		<jstl:choose>
			<jstl:when test="${teacherForm.teacher.id==0}">
				<acme:password code="teacher.password"
					path="teacher.userAccount.password" />
				<acme:password code="teacher.password" path="passwordCheck" />
			</jstl:when>
			<jstl:otherwise></jstl:otherwise>
		</jstl:choose>
	</fieldset>
	<fieldset>
		<legend>
			<spring:message code="teacher.personalInfo" />
		</legend>
		<acme:textbox code="teacher.name" path="teacher.name" />
		<acme:textbox code="teacher.surname" path="teacher.surname" />
		<acme:textbox code="teacher.email" path="teacher.email" />
		<acme:textbox code="teacher.phone" path="teacher.phone" />
		<acme:textbox code="teacher.address" path="teacher.address" />
		<acme:textbox code="teacher.city" path="teacher.city" />
		<acme:textbox code="teacher.picture" path="teacher.picture" />
		<acme:textbox code="teacher.paypalMail" path="teacher.paypalMail" />
		
		
		<form:hidden path="teacher.comments" />
	</fieldset>

 <br/>
   <jstl:if test="${teacherForm.teacher.id == 0}">
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
		value="<spring:message code="teacher.save" />" />&nbsp; 
		
	<acme:cancel code="teacher.cancel" url="/welcome/index.do" />


</form:form>