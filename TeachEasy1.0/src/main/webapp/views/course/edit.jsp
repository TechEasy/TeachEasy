<%--
 * edit.jsp
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
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<form:form action = "course/academy/edit.do" modelAttribute="course">

	<form:hidden path="id"/>
	
	<fieldset>
		<div>	
			<form:label path="ticker">
				<spring:message code="course.ticker" />:
			</form:label>
			<form:input readonly="true" path="ticker" />
			<form:errors cssClass="error" path="ticker" />
		</div>	
		
		<div>
			<form:label path="title">
				<spring:message code="course.title" />:
			</form:label>
			<form:input path="title" />
			<form:errors cssClass="error" path="title" />
		</div>
		
		<div>
			<form:label path="createMoment">
				<spring:message code="course.createMoment" />:
			</form:label>
			<form:input readonly="true" path="createMoment" />
			<form:errors cssClass="error" path="createMoment" />
		</div>
		
		<div>
			<form:label path="updateMoment">
				<spring:message code="course.updateMoment" />:
			</form:label>
			<form:input readonly="true"  path="updateMoment" />
			<form:errors cssClass="error" path="updateMoment" />
		</div>
		
		<div>
			<form:label path="rate">
				<spring:message code="course.rate" />:
			</form:label>
			<form:input path="rate" />
			<form:errors cssClass="error" path="rate" />
		</div>
		
		<div>
			<form:label path="duration">
				<spring:message code="course.duration" />:
			</form:label>
			<form:input path="duration" />
			<form:errors cssClass="error" path="duration" />
		</div>
		
		<div>
			<form:label path="level">
				<spring:message code="course.level" />:
			</form:label>
			<form:input path="level" />
			<form:errors cssClass="error" path="level" />
		</div>
		
		<div>
			<form:label path="subjectMatter">
				<spring:message code="course.matter" />:
			</form:label>
			<form:input path="subjectMatter.name" />
			<form:errors cssClass="error" path="subjectMatter" />
		</div>
	</fieldset>
	
	
		
	<!-- Buttons -->
	
	<input type="submit" name="save"
		value="<spring:message code="course.save" />" />&nbsp; 
	
	<jstl:if test="${course.id != 0}">
	
		<input type="submit" name="delete" value="<spring:message code="course.delete" />"
			onclick="return confirm('<spring:message code="course.confirm.delete" />')" />&nbsp;
	</jstl:if>
	
	<input type="button" name="cancel" value="<spring:message code="course.cancel" />"
		onclick="javascript: window.location.replace('course/academy/listCourse.do')" />
	<br />
	<br />
	
	
</form:form>