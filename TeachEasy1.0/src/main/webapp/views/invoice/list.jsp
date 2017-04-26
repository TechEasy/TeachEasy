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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<div class="col-md-12">
<table class="table table-striped">
	<thead>
      <tr>
        <th><spring:message code="invoice.authoredMoment"/></th>
        <th><spring:message code="invoice.vatNumber"/></th>
        <th><spring:message code="invoice.total"/></th>
        <th><spring:message code="invoice.display" /></th>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${invoices}" var="invoice" >
      <jstl:if test="${invoice.id != null}">
      <tr>
      
        <td>${invoice.authoredMoment}</td>
        <td>${invoice.vatNumber}</td>
        <td>${invoice.total}</td>
       	<td><a class="btn btn-primary" href="student/invoice/display.do?invoiceId=${invoice.id}"><spring:message code="invoice.display" /></a></td>
      </tr>
      </jstl:if>
    </c:forEach>
    </tbody>
</table>
</div>