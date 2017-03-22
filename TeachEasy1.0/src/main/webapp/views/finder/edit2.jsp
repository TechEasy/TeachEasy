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

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<security:authorize
	access="hasRole('STUDENT')">

	<form:form	action="student/finder/course/edit2.do"	modelAttribute="finder"> 

			<acme:textbox code="finder.city" path="city"/>
			<acme:textbox code="finder.matter" path="matter"/>
			<acme:textbox code="finder.minimumPrice" path="minimumPrice"/>
			<acme:textbox code="finder.maximumPrice" path="maximumPrice"/>
			<acme:textbox code="finder.keyword" path="keyword"/>
			
			<acme:submit name="save" code="finder.save"/>
			<acme:cancel code="finder.cancel" url="student/finder/display.do"/>
		
	</form:form>

</security:authorize>

