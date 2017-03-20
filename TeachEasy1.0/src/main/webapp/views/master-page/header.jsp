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

<div>
	<img src="images/logo.png" alt="Sample Project Co., Inc." />
</div>

<div>
	<ul id="jMenu">
		<!-- Do not forget the "fNiv" class for the first level links !! -->
			<li><a class="fNiv" href="teacher/browse.do"><spring:message code="master.page.administrator.teacher.browse" /></a></li>
			<li><a class="fNiv" href="academy/browse.do"><spring:message code="master.page.administrator.academy.browse" /></a></li>
			<li><a class="fNiv" href="student/browse.do"><spring:message code="master.page.administrator.student.browse" /></a></li>

		<security:authorize access="isAnonymous()">
			<li><a class="fNiv" href="student/register.do"><spring:message code="master.page.student.register" /></a></li>
			<li><a class="fNiv" href="teacher/register.do"><spring:message code="master.page.teacher.register" /></a></li>
			<li><a class="fNiv" href="security/login.do"><spring:message code="master.page.login" /></a></li>
			<li><a class="fNiv" href="proposal/list.do"><spring:message code="master.page.proposal" /></a></li>
			<li><a class="fNiv" href="course/list.do"><spring:message code="master.page.course" /></a></li>
			
		</security:authorize>
			
		<security:authorize access="hasRole('STUDENT')">
		<li><a class="fNiv"><spring:message code="master.page.student.finder" /></a>
		<ul>
					<li class="arrow"></li>
					<li><a href="student/finder/display.do"><spring:message code="master.page.student.proposal" /></a></li>
					<li><a href="student/finder/display2.do"><spring:message code="master.page.student.course" /> </a></li>
				</ul>
			</li>
			<li><a class="fNiv"> 
					<spring:message code="master.page.profile" /> 
			        (<security:authentication property="principal.username" />)
				</a>
				<ul>
					<li class="arrow"></li>
					<li><a href="j_spring_security_logout"><spring:message code="master.page.logout" /> </a></li>
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="hasRole('TEACHER')">
			<li><a href="subjectMatter/list.do"><spring:message code="master.page.list.subjectMatter" /></a></li>
			<li><a class="fNiv"> 
					<spring:message code="master.page.profile" /> 
			        (<security:authentication property="principal.username" />)
				</a>
				<ul>
					<li class="arrow"></li>
					<li><a href="subjectMatter/list.do"><spring:message code="master.page.list.subjectMatter" /></a></li>
					<li><a href="teacher/display.do"><spring:message code="master.page.teacher.display" /></a></li>
					<li><a href="j_spring_security_logout"><spring:message code="master.page.logout" /> </a></li>
				</ul>
			</li>

		</security:authorize>
		
		<security:authorize access="hasRole('ACADEMY')">
			<li><a href="subjectMatter/list.do"><spring:message code="master.page.list.subjectMatter" /></a></li>	
			<li><a class="fNiv"> 
					<spring:message code="master.page.profile" /> 
			        (<security:authentication property="principal.username" />)
				</a>
				<ul>
					<li class="arrow"></li>
					<li><a href="j_spring_security_logout"><spring:message code="master.page.logout" /> </a></li>
				</ul>
			</li>	
		</security:authorize>
		
		<security:authorize access="hasRole('ADMIN')">
			<li><a href="administrator/subjectMatter/list.do"><spring:message code="master.page.list.subjectMatter" /></a></li>
						<li><a class="fNiv"> 
					<spring:message code="master.page.profile" /> 
			        (<security:authentication property="principal.username" />)
				</a>
				<ul>
					<li class="arrow"></li>
					<li><a href="j_spring_security_logout"><spring:message code="master.page.logout" /> </a></li>
				</ul>
			</li>
		</security:authorize>
	</ul>
</div>

<div>
	<a href="?language=en">en</a> | <a href="?language=es">es</a>
</div>

