<%--
 * display.jsp
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

<jstl:out value="${teacher.name }" />
<table id="row" class="table">
	
	<tbody>
		<tr>
			<td rowspan="10">
				<img src="${teacher.picture}" width="200" height="200" >
			</td>
		</tr>
		<tr>
			<th>
				<spring:message code = "teacher.feeAmount"/>
			</th>
			<td>
				<jstl:out value="${teacher.feeAmount }" />
			</td>
		</tr>
		<tr>
			<th>
				<spring:message code="teacher.avgStars" />
			</th>
			<td>
				<jstl:out value="${teacher.avgStars }" />
			</td>
		</tr>
		<tr>
			<th>
				<spring:message code="teacher.timeTable" />
			</th>
			<td>
				<jstl:out value="${teacher.timeTable }" />
			</td>
		</tr>
	</tbody>

</table>