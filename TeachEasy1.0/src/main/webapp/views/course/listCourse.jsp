<%--
 * list.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<jstl:if test="${msg!=null }">
	<h3 style="color:red;"><spring:message code="${msg}" /></h3>
</jstl:if>
<div class="col-md-12">
		<c:forEach items="${courses}" var="course" >
		<div class="row">
		<div class="col-md-12">
		<div class="card-bordered">
			<div class="row">
				<div class="col-md-3">	
					<img src="${course.academy.picture}"  width="200" height="200" class="img-responsive">
				</div>
				<div class="col-md-9 ">
					<h1>${course.title}</h1>
					<h2>${course.academy.name}</h2>
					<div class="row">
						<div class="col-md-6">
							<h3><spring:message code="course.rate" />: ${course.rate} Eur.</h3>
						</div>
						<div class="col-md-6">
							<h3><spring:message code="course.avgStars" />: ${course.academy.avgStars}</h3>
						</div>
					</div>
					<div class="row text-right">
						<div class="col-md-12 mt-lg pr-xl">
							<jstl:if test="${course.available == false}">
								<a class="btn btn-primary" href="course/academy/enableDisable.do?courseId=${course.id}"><spring:message code="proposal.enable" /></a>
							</jstl:if>
							<jstl:if test="${course.available == true}">
								<a class="btn btn-danger" href="course/academy/enableDisable.do?courseId=${course.id}"><spring:message code="proposal.disable" /></a>
							</jstl:if>
							<a class="btn btn-primary" href="course/academy/edit.do?courseId=${course.id}"><spring:message code="course.edit" /></a>
						</div>
					</div>
					<security:authorize access="hasRole('ACADEMY')">
					

						
					</security:authorize>
				</div>
			</div>
		</div>
		</div>
		</div>
		</c:forEach>
		<!-- Create course -->
		<security:authorize access="hasRole('ACADEMY')">
			<div>
				<a class="btn btn-primary" href="course/academy/create.do"><spring:message code="course.create" /></a>
			</div>
		</security:authorize>
</div>