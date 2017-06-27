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
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<div class="col-md-3"></div>
<div class="col-md-6">
<form:form action = "comment/edit.do" modelAttribute="comment">
	
	<form:hidden path="id"/>
	<form:hidden path="version"/>
	<form:hidden path="student"/>
	<form:hidden path="createMoment"/>
	<form:hidden path="commentable"/>
				
	<acme:textbox code="comments.title" path="title"/>	
	<acme:textarea code="comments.text" path="text"/>
	<div class="row">
		<div class="col-md-12 mb-md">
			<label for="stars" class="control-label"></label>
			<input id="stars" name="stars" class="rating rating-loading" data-min="0" data-max="5" data-step="1">
		</div>
	</div>		
	<div class="row">
		<div class="col-md-3"><acme:cancel url="welcome/index.do" code="comments.cancel"/></div>
		<div class="col-md-3"></div>
		<div class="col-md-6"><acme:submit name="save" code="comments.save"/></div>
	</div>

</form:form>
</div>
<div class="col-md-3"></div>

<script>
$(document).on('ready', function(){
    $('#stars').rating({});
});
</script>