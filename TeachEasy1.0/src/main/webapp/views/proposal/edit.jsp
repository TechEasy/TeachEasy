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
     
    	    
<div class="col-md-3"></div>    
<div class="col-md-6">	
<form:form action = "proposal/teacher/edit.do" modelAttribute="proposal">

	<form:hidden path="id"/>
	<form:hidden path="version"/>
	<form:hidden path="requests"/>
	<form:hidden path="teacher"/>
	<form:hidden path="available"/>
	
		<div class="form-group">
			<form:label path="title" class="control-label">
				<spring:message code="proposal.title" />:
			</form:label>
			<form:input path="title" class="form-control" />
			<form:errors cssClass="error" path="title" />
		</div>
		
		<div class="row">
		<div class="col-md-6">
		<div class="form-group">
			<form:label path="createMoment" class="control-label">
				<spring:message code="proposal.createMoment" />:
			</form:label>
			<form:input readonly="true" path="createMoment" class="form-control"/>
			<form:errors cssClass="error" path="createMoment" />
		</div>
		</div>
		<div class="col-md-6">
		<div class="form-group">
			<form:label path="updateMoment" class="control-label">
				<spring:message code="proposal.updateMoment" />:
			</form:label>
			<form:input readonly="true"  path="updateMoment" class="form-control"/>
			<form:errors cssClass="error" path="updateMoment" />
		</div>
		</div>
		</div>
		<div class="row">
		<div class="col-md-6">
		<div class="form-group">
			<form:label path="rate"  class="control-label">
				<spring:message code="proposal.rate" />:
			</form:label>
			<form:input path="rate" class="form-control"/>
			<form:errors cssClass="error" path="rate" />
		</div>
		</div>
			
		<div class="col-md-6">
		<div class="form-group">
		<form:label path="subjectMatter" class="control-label">
				<spring:message code="proposal.matter" />:
		</form:label>
		
		<form:select path="subjectMatter" class="form-control">
			<form:option label="-----" value="0" />
			<form:options items="${matters}" />
		</form:select>
		<form:errors cssClass="error" path="subjectMatter" />
		</div>
		</div>
		</div>
	
		
	<!-- Buttons -->
	
	<div class="row">
	<div class="col-md-6 ">
		<input class="btn btn-success btn-block" type="submit" name="save" value="<spring:message code="proposal.save" />">
	</div>
	<div class="col-md-3"></div>
	<div class="col-md-3">
		<input class="btn btn-default btn-block" type="button" value="<spring:message code="proposal.cancel"/>" onclick="javascript: relativeRedir('proposal/teacher/list.do')"/>
	</div>
	<div class="col-md-3"></div>
	</div>
	
</form:form>
</div>
