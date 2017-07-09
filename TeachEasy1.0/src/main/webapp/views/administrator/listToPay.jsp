<%--
 * action-1.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-md-12">
<div class="row">
<div class="col-md-12">
<h3><spring:message code="teachers"/></h3>
<div class="table-responsive">
<table class="table table-striped" id="listToPay">
	<thead>
      <tr>
        <th><spring:message code="teacher.name"/></th>
        <th><spring:message code="teacher.surname"/></th>
        <th><spring:message code="teacher.paypalMail"/></th>
        <th><spring:message code="teacher.feeAmount" /></th>
        <th></th>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${teachers}" var="teacher" >
      <jstl:if test="${teacher.id != null}">
      <tr>
      
        <td>${teacher.name}</td>
        <td>${teacher.surname}</td>
        <td>${teacher.paypalMail}</td>
       	<td>${teacher.feeAmount}</td>
       	<td>
       	<form name="_xclick" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
	   <input type="hidden" name="cmd" value="_xclick">
	   <input type="hidden" name="business" value="${teacher.paypalMail}">
	   <input type="hidden" name="currency_code" value="EUR">
	   <input type="hidden" name="item_name" value="Pago mensual">
	   <input type="hidden" name="amount" value="${teacher.feeAmount}">
	   <input type='hidden' name='return' value="http://teacheasy.jelastic.cloudhosted.es/administrator/teacherPay.do?teacherId=${teacher.id}">
	   <input type='hidden' name='cancel' value="http://teacheasy.jelastic.cloudhosted.es/administrator/listToPay.do">
	   <input class="btn btn-primary" type="submit" name="save" alt="PayPal, la forma rápida y segura de pagar en Internet." value="<spring:message code="request.pay" />">
	  
	 </form>
       	</td>
      </tr>
      </jstl:if>
    </c:forEach>
    </tbody>
</table>
</div>
</div>
</div>

<div class="row">
<div class="col-md-12">
<h3><spring:message code="academies"/></h3>
<div class="table-responsive">
<table class="table table-striped" id="listToPay2">
	<thead>
      <tr>
        <th><spring:message code="academy.name"/></th>
        <th><spring:message code="academy.cif"/></th>
        <th><spring:message code="academy.paypalMail"/></th>
        <th><spring:message code="academy.feeAmount" /></th>
        <th></th>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${academies}" var="academy" >
      <jstl:if test="${academy.id != null}">
      <tr>
      
        <td>${academy.name}</td>
        <td>${academy.cif}</td>
        <td>${academy.paypalMail}</td>
       	<td>${academy.feeAmount}</td>
       	<td>
       	<form name="_xclick" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
	   <input type="hidden" name="cmd" value="_xclick">
	   <input type="hidden" name="business" value="${academy.paypalMail}">
	   <input type="hidden" name="currency_code" value="EUR">
	   <input type="hidden" name="item_name" value="Pago mensual">
	   <input type="hidden" name="amount" value="${academy.feeAmount}">
	   <input type='hidden' name='return' value="http://teacheasy.jelastic.cloudhosted.es/administrator/academyPay.do?academyId=${academy.id}">
	   <input type='hidden' name='cancel' value="http://teacheasy.jelastic.cloudhosted.es/administrator/listToPay.do">
	   <input class="btn btn-primary" type="submit" name="save" alt="PayPal, la forma rápida y segura de pagar en Internet." value="<spring:message code="request.pay" />">
	  
	 </form>
       	</td>
      </tr>
      </jstl:if>
    </c:forEach>
    </tbody>
</table>
</div>
</div>
</div>
</div>
<script>
$(document).ready(function() {
	getPagination('#table-listToPay', 5);
} );
</script>
<script>
$(document).ready(function() {
	getPagination('#table-listToPay2', 5);
} );
</script>
