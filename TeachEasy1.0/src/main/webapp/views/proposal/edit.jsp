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
     
    	    
    	
<form:form action = "proposal/teacher/edit.do" modelAttribute="proposal">

	<form:hidden path="id"/>
	<form:hidden path="version"/>
	<form:hidden path="requests"/>
	<form:hidden path="teacher"/>
	
	
	<fieldset>
		<div>
			<form:label path="title">
				<spring:message code="proposal.title" />:
			</form:label>
			<form:input path="title" />
			<form:errors cssClass="error" path="title" />
		</div>
		
		<div>
			<form:label path="createMoment">
				<spring:message code="proposal.createMoment" />:
			</form:label>
			<form:input readonly="true" path="createMoment" />
			<form:errors cssClass="error" path="createMoment" />
		</div>
		
		<div>
			<form:label path="updateMoment">
				<spring:message code="proposal.updateMoment" />:
			</form:label>
			<form:input readonly="true"  path="updateMoment" />
			<form:errors cssClass="error" path="updateMoment" />
		</div>
		
		<div>
			<form:label path="rate">
				<spring:message code="proposal.rate" />:
			</form:label>
			<form:input path="rate" />
			<form:errors cssClass="error" path="rate" />
		</div>		
		 
		<div>
			
		<form:label path="subjectMatter">
				<spring:message code="proposal.matter" />:
		</form:label>
		
		<form:select path="subjectMatter">
			<form:option label="-----" value="0" />
			<form:options items="${matters}" />
		</form:select>
		<form:errors cssClass="error" path="subjectMatter" />
		<br/>
 	
		</div>
	</fieldset>
	
	
		
	<!-- Buttons -->
	
	<input type="submit" name="save"
		value="<spring:message code="proposal.save" />" />&nbsp; 
	
	
	<input type="button" name="cancel" value="<spring:message code="proposal.cancel" />"
		onclick="javascript: window.location.replace('proposal/teacher/list.do')" />
	<br />
	<br />
	
	
</form:form>