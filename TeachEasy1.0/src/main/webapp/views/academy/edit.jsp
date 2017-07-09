<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="${requestURI}" modelAttribute="academyForm">

	
	<acme:textbox code="academy.username" path="username" readonly="true"/>
	<acme:password code="academy.password" path="password" />
	<acme:password code="academy.password2" path="password2" />
	<br />
	
	<acme:textbox code="academy.name" path="name" />
	<acme:textbox code="academy.city" path="city" />
	<acme:textbox code="academy.address" path="address" />
	<acme:textbox code="academy.description" path="description" />
	<acme:textarea code="academy.picture" path="picture" />
	<acme:textbox code="academy.cifEx" path="cif"/>
	<acme:textbox code="academy.paypalMail" path="paypalMail" />

	
	<acme:submit code="academy.save" name="save" />
	<acme:cancel code="academy.cancel" url="welcome/index.do" />
</form:form>