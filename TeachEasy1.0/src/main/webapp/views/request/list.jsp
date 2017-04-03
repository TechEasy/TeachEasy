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
        <th></th>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${requests}" var="request" >
      <tr>
        <td>${request.checkIn}</td>
        <td>${request.checkOut}</td>
        <td>${request.status}</td>
        <td>${request.rclass.title}</td>
        <security:authorize access="hasRole('TEACHER')">
        <td>
        	<jstl:if test="${request.status eq 'PENDING' }">
        	<a class="btn btn-success" href="javascript: window.location.replace('teacher/request/accept.do?requestId=${request.id}')"><spring:message code="request.accept" /></a>
        	<a class="btn btn-danger" href="javascript: window.location.replace('teacher/request/deny.do?requestId=${request.id}')"><spring:message code="request.deny" /></a>
       		</jstl:if>
		</td>
        </security:authorize>
        <security:authorize access="hasRole('ACADEMY')">
        <td>
       		<jstl:if test="${request.status eq 'PENDING' }">
        	<a class="btn btn-success" href="javascript: window.location.replace('academy/request/accept.do?requestId=${request.id}')"><spring:message code="request.accept" /></a>
        	<a class="btn btn-danger" href="javascript: window.location.replace('academy/request/deny.do?requestId=${request.id}')"><spring:message code="request.deny" /></a>
        	</jstl:if>
        </td>
        </security:authorize>
        
        <security:authorize access="hasRole('STUDENT')">
         <td>
	       <jstl:if test="${request.status eq 'WAITING'}">
	       
	         <form name="_xclick" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
			   <input type="hidden" name="cmd" value="_xclick">
			   <input type="hidden" name="business" value="TeachEasy@gmail.com">
			   <input type="hidden" name="currency_code" value="EUR">
			   <input type="hidden" name="item_name" value="Clase">
			   <input type="hidden" name="amount" value="${amount[request.id]}">
			   <input type='hidden' name='return' value="http://localhost:8080/TeachEasy/student/request/paid.do?requestId=${request.id}">
			   <input type="image" src="https://www.paypalobjects.com/es_ES/ES/i/btn/btn_paynow_SM.gif" border="0" name="submit" alt="PayPal, la forma rápida y segura de pagar en Internet.">
			 </form>
	        </jstl:if>
	         </td>
	    </security:authorize>
	      </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<script>
function target_popup(form) {
	posicion_x=(screen.width/2)-200; 
	posicion_y=(screen.height/2)-200; 
    window.open('', 'formpopup', 'width=400,height=400,resizeable,scrollbars,left='+posicion_x+",top="+posicion_y+"");
    form.target = 'formpopup';
}
</script>




