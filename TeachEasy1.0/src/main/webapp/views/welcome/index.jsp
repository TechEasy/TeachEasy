<%--
 * index.jsp
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

<security:authorize access="hasRole('STUDENT')">
<div style="text-align:center">
	<H3><spring:message code="welcome.message"/></H3>
</div>
<table>
	<tr>
		<td width="50%">
		<H2><spring:message code="welcome.academy"/></H2>
		<table id="row" class="table">
			<tr>
				<th style="text-align:center"><spring:message code="welcome.academy.picture"/></th>
				<th style="text-align:center"><spring:message code="welcome.academy.name"/></th>
				<th style="text-align:center"><spring:message code="welcome.academy.avgStars"/></th>
			</tr>
			<tr>
				<td style="text-align:center"><img src="${academy.picture}" width="100" height="100" ></td>
				<td style="text-align:center"><jstl:out value="${academy.name}"/></td>
				<td style="text-align:center"><jstl:out value="${academy.avgStars}"/></td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align:center"><input type="button" name="display" value="<spring:message code="welcome.display" />"
						onclick="javascript: window.location.replace('academy/displayById.do?id=${academy.id}')" /></td>
				<td></td>
			</tr>
		</table>
		<td width="50%">
		<h2><spring:message code="welcome.teacher"/></h2>
		<table id="row" class="table">
			<tr>
				<th style="text-align:center"><spring:message code="welcome.teacher.picture"/></th>
				<th style="text-align:center"><spring:message code="welcome.teacher.name"/></th>
				<th style="text-align:center"><spring:message code="welcome.teacher.avgStars"/></th>
			</tr>
			<tr>
				<td style="text-align:center"><img src="${teacher.picture}" width="100" height="100" ></td>
				<td style="text-align:center"><jstl:out value="${teacher.name} ${teacher.surname} "/></td>
				<td style="text-align:center"><jstl:out value="${teacher.avgStars}"/></td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align:center"><input type="button" name="display" value="<spring:message code="welcome.display" />"
						onclick="javascript: window.location.replace('teacher/displayById.do?id=${teacher.id}')" /></td>
				<td></td>
			</tr>
		</table>
		
	</td>
</tr>
</table>
</security:authorize>
