<%--
 * header.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div class="row text-left">
	<div class="col-md-6 col-xs-6">
		<font size="3" color="blue">
			<a href="?language=en"><img src="images/ing.png" width="50" height="50" alt="Ingles" /></a> | <a href="?language=es"><img src="images/es.jpg" width="50" height="50" alt="Español" /></a>
		</font>
	</div>
	<security:authorize access="isAuthenticated()">
	<div class="col-xs-6 text-right">
		<font size="3" color="blue">
			<img src="images/logo4.png" width="45" height="45" alt="Logo" />
		</font>
	</div>
	</security:authorize>
</div>

<div class="row">
<div class="col-md-12">
<nav class="navbar navbar-default" style="background-color: #000000;" id="menu-superior">
	<div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Teach Easy</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand " href="#"><img src="images/logo3.png" width="120" height="30" alt="Ingles" /></a>
        </div>
    	<div id="navbar" class="navbar-collapse collapse">
    	<ul class="nav navbar-nav">    	
    	<security:authorize access="isAnonymous()">
			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown"><spring:message code="master.page.register.menu" /> <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="student/register.do"><spring:message code="master.page.student.register" /></a></li>
					<li><a href="teacher/register.do"><spring:message code="master.page.teacher.register" /></a></li>
					<li><a href="academy/register.do"><spring:message code="master.page.academy.register" /></a></li>
				</ul>
			</li>
			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown"><spring:message code="master.page.basic.menu" /> <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="proposal/list.do"><spring:message code="master.page.proposal" /></a></li>
					<li><a href="course/list.do"><spring:message code="master.page.course" /></a></li>
				</ul>
			</li>
		</security:authorize>
    	
    	<security:authorize access="isAuthenticated()">
			
		</security:authorize>
		
		<security:authorize access="hasRole('STUDENT')">
			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown"><spring:message code="master.page.student.searchFor" /><span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="teacher/browse.do"><spring:message code="master.page.administrator.teacher.browse" /></a></li>
					<li><a href="academy/browse.do"><spring:message code="master.page.administrator.academy.browse" /></a></li>
					<li><a href="proposal/list.do"><spring:message code="master.page.proposal" /></a></li>
					<li><a href="course/list.do"><spring:message code="master.page.course" /></a></li>
				</ul>
			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown"><spring:message code="master.page.student.finder" /><span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="student/finder/display.do"><spring:message code="master.page.student.proposal" /></a></li>
					<li><a href="student/finder/course/display2.do"><spring:message code="master.page.student.course" /> </a></li>	
				</ul>
			</li>
			<li><a href="student/request/list.do"><spring:message code="master.page.student.request" /> </a></li>
			<li><a href="student/invoice/list.do"><spring:message code="master.page.invoice" /> </a></li>
			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown"><spring:message code="master.page.profile" /> <security:authentication property="principal.username" />
				<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="student/display.do"><spring:message code="master.page.display" /> </a></li>
						<li><a href="student/edit.do"><spring:message code="master.page.edit" /> </a></li>
						<li><a href="socialIdentity/list.do"><spring:message code="master.page.socialIdentity" /> </a></li>
					</ul>
				</li>
		</security:authorize>
		
		<security:authorize access="hasRole('TEACHER')">
			<li><a href="subjectMatter/list.do"><spring:message code="master.page.list.subjectMatter" /></a></li>
			<li><a href="proposal/teacher/list.do"><spring:message code="master.page.teacher.proposal" /> </a></li>
			<li><a href="teacher/request/list.do"><spring:message code="master.page.teacher.request" /> </a></li>
			
			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown"> <spring:message code="master.page.profile" /> <security:authentication property="principal.username" />
				<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="teacher/display.do"><spring:message code="master.page.display" /> </a></li>
					<li><a href="teacher/edit.do"><spring:message code="master.page.edit" /> </a></li>
					<li><a href="teacher/curricula/edit.do"><spring:message code="master.page.curricula" /> </a></li>
					<li><a href="socialIdentity/list.do"><spring:message code="master.page.socialIdentity" /> </a></li>
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="hasRole('ACADEMY')">
			<li><a href="subjectMatter/list.do"><spring:message code="master.page.list.subjectMatter" /></a></li>
			<li><a href="course/academy/listCourse.do"><spring:message code="master.page.academy.course" /></a></li>		
			<li><a href="academy/request/list.do"><spring:message code="master.page.teacher.request" /> </a></li>
			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown"> <spring:message code="master.page.profile" /> <security:authentication property="principal.username" />
				<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="academy/display.do"><spring:message code="master.page.display" /> </a></li>
					<li><a href="academy/edit.do"><spring:message code="master.page.edit" /> </a></li>
					<li><a href="socialIdentity/list.do"><spring:message code="master.page.socialIdentity" /> </a></li>
				</ul>
			</li>	
		</security:authorize>
		
		<security:authorize access="hasRole('ADMIN')">
			<li><a href="subjectMatter/administrator/list.do"><spring:message code="master.page.list.subjectMatter" /></a></li>
			<li><a href="administrator/request/list.do"><spring:message code="master.page.list.requestCanceled" /></a></li>
			<li><a href="administrator/fee/edit.do"><spring:message code="master.page.fee" /> </a></li>
			<li><a href="administrator/listToPay.do"><spring:message code="master.page.pays" /> </a></li>
			
		</security:authorize>
		
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<security:authorize access="isAnonymous()">
   	   			<li><a href="security/login.do"><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;<spring:message code="master.page.login" /></a></li>
   	   		</security:authorize>
   	   		<security:authorize access="isAuthenticated()">
   	   			<li><a href="j_spring_security_logout"><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;<spring:message code="master.page.logout" /> </a></li>
   	   		</security:authorize>
   		</ul>
		</div>
  	</div>
</nav>
</div>
</div>




