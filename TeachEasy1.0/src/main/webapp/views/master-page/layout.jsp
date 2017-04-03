<%--
 * layout.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!-- Bootstrap -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<base
	href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="shortcut icon" href="favicon.ico"/> 


<link rel="stylesheet" href="styles/common.css" type="text/css">
<link rel="stylesheet" href="styles/displaytag.css" type="text/css">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/star-rating.min.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" src="scripts/jquery-ui.js"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/star-rating.min.js" />" type="text/javascript"></script>


<title><tiles:insertAttribute name="title" ignore="true" /></title>

<script type="text/javascript">

	function askSubmission(msg, form) {
		if (confirm(msg))
			form.submit();
	}
</script>
<script type="text/javascript">
		function relativeRedir(loc) {	
			var b = document.getElementsByTagName('base');
			if (b && b[0] && b[0].href) {
	  			if (b[0].href.substr(b[0].href.length - 1) == '/' && loc.charAt(0) == '/')
	    		loc = loc.substr(1);
	  			loc = b[0].href + loc;
			}
			window.location.replace(loc);
		}
	</script>
	
	

	
</head>

<body>
<div class="container">
	
		<tiles:insertAttribute name="header" />
		
		<div class="row mb-md">
			<div class="col-md-12">
				<h1>
					<tiles:insertAttribute name="title" />
				</h1>
			</div>
		</div>
		<div class="row">
		<tiles:insertAttribute name="body" />	
		<jstl:if test="${message != null}">
			<br />
			<span class="message"><spring:message code="${message}" /></span>
		</jstl:if>	
		</div>

		<tiles:insertAttribute name="footer" />
</div>
</body>
</html>