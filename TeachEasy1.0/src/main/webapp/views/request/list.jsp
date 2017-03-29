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
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="col-md-12">
<spring:message code="request.checkin" var="checkin" />
<spring:message code="request.checkout" var="checkout" />
<spring:message code="request.status" var="status" />
<spring:message code="request.rClass" var="rClass"/>

<table class="table table-striped">
	<thead>
      <tr>
        <th>${checkin}</th>
        <th>${checkout}</th>
        <th>${status}</th>
        <th>${rClass}</th>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${requests}" var="request" >
      <tr>
        <td>${request.checkIn}</td>
        <td>${request.checkOut}</td>
        <td>${request.status}</td>
        <td>${request.rclass.title}</td>
      </tr>
    </c:forEach>
    </tbody>
</table>
</div>






