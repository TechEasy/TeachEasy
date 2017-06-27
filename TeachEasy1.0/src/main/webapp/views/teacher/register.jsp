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

<jstl:if test="${teacherForm.id==0}">
<div class="col-md-12">
<div class="panel panel-default">
<div class="panel-body payment-form">

<form:form action="teacher/register.do" modelAttribute="teacherForm">
		<form:hidden path="id"/>
			<div class="row">
			
				<div class="col-md-6">
					<h4><spring:message code="teacher.account.info"/></h4>
					<acme:textbox code="teacher.username" path="username" />
					<div class="row">
						<div class="col-md-6">
							<acme:password code="teacher.password" path="password"/>
						</div>
						<div class="col-md-6">
							<acme:password code="teacher.password2" path="password2"/>
						</div>
					</div>
				</div>
				
				<div class="col-md-6">
					<h4><spring:message code="teacher.personal.info"/></h4>
					<div class="row">
						<div class="col-md-6">
							<acme:textbox code="teacher.name" path="name" />
						</div>
						<div class="col-md-6">
							<acme:textbox code="teacher.surname" path="surname"/>
						</div>
					</div>
					<acme:textbox code="teacher.email" path="email"/>
					<div class="row">
						<div class="col-md-6">
							<acme:textbox code="teacher.phone" path="phone"/>
						</div>
						<div class="col-md-6">
							<acme:textbox code="teacher.date" path="date"/>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<acme:textbox code="teacher.city" path="city"/>		
						</div>
						<div class="col-md-6">
							<acme:textbox code="teacher.address" path="address"/>
						</div>
					</div>
					<acme:textbox code="teacher.picture" path="picture"/>
					<acme:textbox code="teacher.paypalMail" path="paypalMail" />
						<div class="checkbox-group checkbox">
							<form:label path="agreed" class="control-label">
								<form:checkbox path="agreed"/>
								<spring:message code="teacher.register.agree" />
								<a data-toggle="modal" data-target="#myModal"><spring:message code="teacher.register.agree.2"/></a>
							</form:label>
							<form:errors path="agreed" cssClass="error" />
						</div>
				</div>
			</div>
			<div class="row mt-md">
				<div class="col-md-2">
					<acme:cancel code="teacher.cancel" url="welcome/index.do" />
				</div>
					<div class="col-md-4"></div>
				<div class="col-md-6">
					<acme:submit name="save" code="teacher.save"/>
				</div>
			</div>
</form:form>
</div>
</div>
</div>
</jstl:if>

<jstl:if test="${teacherForm.id!=0}">
<div class="col-md-12">
<div class="panel panel-default">
<div class="panel-body payment-form">

<form:form action="teacher/register.do" modelAttribute="teacherForm">
		<form:hidden path="id"/>
			<div class="row">
				<form:hidden path="username"/>
				<form:hidden path="password"/>
				<form:hidden path="password2"/>
				<form:hidden path="agreed"/>
				<div class="col-md-12">
					<h4><spring:message code="teacher.personal.info"/></h4>
					<div class="row">
						<div class="col-md-6">
							<acme:textbox code="teacher.name" path="name" />
						</div>
						<div class="col-md-6">
							<acme:textbox code="teacher.surname" path="surname"/>
						</div>
					</div>
					<acme:textbox code="teacher.email" path="email"/>
					<div class="row">
						<div class="col-md-6">
							<acme:textbox code="teacher.phone" path="phone"/>
						</div>
						<div class="col-md-6">
							<acme:textbox code="teacher.date" path="date"/>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<acme:textbox code="teacher.city" path="city"/>		
						</div>
						<div class="col-md-6">
							<acme:textbox code="teacher.address" path="address"/>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<acme:textbox code="teacher.picture" path="picture"/>	
						</div>
						<div class="col-md-6">
							<acme:textbox code="teacher.paypalMail" path="paypalMail" />
						</div>
					</div>
				</div>
			</div>
			<div class="row mt-md">
				<div class="col-md-2">
					<acme:cancel code="teacher.cancel" url="welcome/index.do" />
				</div>
					<div class="col-md-4"></div>
				<div class="col-md-6">
					<acme:submit name="save" code="teacher.save"/>
				</div>
			</div>
</form:form>
</div>
</div>
</div>
</jstl:if>

<div class="modal fade" id="myModal" >
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"><spring:message code="lopd.title" /></h4>
        </div>
        <div class="modal-body">
          <p><spring:message code="lopd.text" /></p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
</div>

