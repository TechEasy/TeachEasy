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

<display:table name="teachers"
	id="row"
	class="displaytag"
	pagesize="5"
	requestURI="${requestURI}" >
	
	<spring:message code="teacher.name" var="nameHeader" />
	<display:column title="${nameHeader}" property="name"/>
	
	<spring:message code="teacher.surname" var="surnameHeader" />
	<display:column title="${surnameHeader}" property="surname"/>
	
	<spring:message code="teacher.paypalMail" var="emailHeader" />
	<display:column title="${emailHeader}" property="paypalMail"/>
	
	<spring:message code="teacher.feeAmount" var="amountHeader" />
	<display:column title="${amountHeader}" property="feeAmount"/>
	
	<display:column>
	<form name="_xclick" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
	   <input type="hidden" name="cmd" value="_xclick">
	   <input type="hidden" name="business" value="${row.paypalMail}">
	   <input type="hidden" name="currency_code" value="EUR">
	   <input type="hidden" name="item_name" value="Clase">
	   <input type="hidden" name="amount" value="${row.feeAmount}">
	   <input type='hidden' name='return' value="http://localhost:8080/TeachEasy/administrator/teacherPay.do?teacherId=${row.id}">
	   <input type='hidden' name='cancel' value="http://localhost:8080/TeachEasy/administrator/listToPay.do">
	   <input class="btn btn-primary" type="submit" name="save" alt="PayPal, la forma rápida y segura de pagar en Internet." value="<spring:message code="request.pay" />">
	  
	 </form>
	</display:column>
</display:table>

<display:table name="academies"
	id="row"
	class="displaytag"
	pagesize="5"
	requestURI="${requestURI}" >
	
	<spring:message code="academy.name" var="nameHeader" />
	<display:column title="${nameHeader}" property="name"/>
	
	<spring:message code="academy.cif" var="cifHeader" />
	<display:column title="${cifHeader}" property="cif"/>
	
	<spring:message code="academy.paypalMail" var="emailHeader" />
	<display:column title="${emailHeader}" property="paypalMail"/>
	
	<spring:message code="academy.feeAmount" var="amountHeader" />
	<display:column title="${amountHeader}" property="feeAmount"/>
	
	<display:column>
	<form name="_xclick" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
	   <input type="hidden" name="cmd" value="_xclick">
	   <input type="hidden" name="business" value="${row.paypalMail}">
	   <input type="hidden" name="currency_code" value="EUR">
	   <input type="hidden" name="item_name" value="Clase">
	   <input type="hidden" name="amount" value="${row.feeAmount}">
	   <input type='hidden' name='return' value="http://localhost:8080/TeachEasy/administrator/academyPay.do?academyId=${row.id}">
	   <input type='hidden' name='cancel' value="http://localhost:8080/TeachEasy/administrator/listToPay.do">
	   <input class="btn btn-primary" type="submit" name="save" alt="PayPal, la forma rápida y segura de pagar en Internet." value="<spring:message code="request.pay" />">
	  
	 </form>
	</display:column>	
	
</display:table>
