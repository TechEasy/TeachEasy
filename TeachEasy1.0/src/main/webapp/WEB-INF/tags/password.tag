<%--
 * password.tag
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@ tag language="java" body-content="empty" %>

<%-- Taglibs --%>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<%-- Attributes --%> 
 
<%@ attribute name="path" required="true" rtexprvalue="true" %>
<%@ attribute name="code" required="true" rtexprvalue="true" %>

<%-- Definition --%>

<div class="form-group">
	<form:label path="${path}" class="col-sm-2 control-label">
		<spring:message code="${code}" />
	</form:label>
	<div class="col-sm-9">	
	<form:password path="${path}" class="form-control"/>
	</div>
	<form:errors path="${path}" cssClass="error" />
</div>
