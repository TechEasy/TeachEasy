<%--
 * register.jsp
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
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<jstl:if test="${academyForm.id==0}">
<div class="col-md-12">
<div class="panel panel-default">
<div class="panel-body payment-form">

<form:form action="academy/register.do" modelAttribute="academyForm">
		<form:hidden path="id"/>
			<div class="row">

					<div class="col-md-6">
						<h4><spring:message code="academy.account.info"/></h4>
						<acme:textbox code="academy.username" path="username" />
						<div class="row">
							<div class="col-md-6">
								<acme:password code="academy.password" path="password"/>
							</div>
							<div class="col-md-6">
								<acme:password code="academy.password2" path="password2"/>
							</div>
						</div>
					</div>

				<div class="col-md-6">
					<h4><spring:message code="academy.personal.info"/></h4>
					<acme:textbox code="academy.name" path="name"/>
					<div class="row">
						<div class="col-md-6">
							<acme:textbox code="academy.city" path="city" />
						</div>
						<div class="col-md-6">
							<acme:textbox code="academy.address" path="address"/>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<acme:textbox code="academy.cif" path="cif"/>
						</div>
						<div class="col-md-6">
						</div>
					</div>
					<acme:textarea code="academy.description" path="description"/>
					<acme:textbox code="academy.picture" path="picture"/>
					<acme:textbox code="academy.paypalMail" path="paypalMail" />
					
					<div class="checkbox-group checkbox">
						<form:label path="agreed" class="control-label">
							<form:checkbox path="agreed"/>
							<spring:message code="academy.register.agree" />
							<a href="misc/lopd.do" target="_blank"><spring:message code="academy.register.agree.2"/></a>
						</form:label>
						<form:errors path="agreed" cssClass="error" />
					</div>
				</div>
			</div>
			<div class="row mt-md">
				<div class="col-md-2">
					<acme:cancel code="academy.cancel" url="welcome/index.do" />
				</div>
				<div class="col-md-4"></div>
				<div class="col-md-6">
					<acme:submit name="save" code="academy.save"/>
				</div>
			</div>
</form:form>
</div>
</div>
</div>
</jstl:if>

<jstl:if test="${academyForm.id!=0}">
<div class="col-md-12">
<div class="panel panel-default">
<div class="panel-body payment-form">

<form:form action="academy/register.do" modelAttribute="academyForm">
		<form:hidden path="id"/>
			<div class="row">
				<form:hidden path="username"/>
				<form:hidden path="password"/>
				<form:hidden path="password2"/>
				<form:hidden path="agreed"/>

				<div class="col-md-12">
					<h4><spring:message code="academy.personal.info"/></h4>
					<acme:textbox code="academy.name" path="name"/>
					<div class="row">
						<div class="col-md-6">
							<acme:textbox code="academy.city" path="city" />
						</div>
						<div class="col-md-6">
							<acme:textbox code="academy.address" path="address"/>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<acme:textbox code="academy.cif" path="cif"/>
						</div>
						<div class="col-md-6">
							<acme:textbox code="academy.paypalMail" path="paypalMail" />
						</div>
					</div>
					<acme:textarea code="academy.description" path="description"/>
					<acme:textbox code="academy.picture" path="picture"/>
					
				</div>
			</div>
			<div class="row mt-md">
				<div class="col-md-2">
					<acme:cancel code="academy.cancel" url="welcome/index.do" />
				</div>
				<div class="col-md-4"></div>
				<div class="col-md-6">
					<acme:submit name="save" code="academy.save"/>
				</div>
			</div>
</form:form>
</div>
</div>
</div>
</jstl:if>
