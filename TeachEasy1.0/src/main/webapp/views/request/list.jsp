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
<spring:message code="request.amount" var="amountH" />
<spring:message code="request.name" var="nameH" />
<spring:message code="request.surname" var="surnameH" />


<div class="table-responsive">
<table class="table table-striped" id="example width="100%"">
	<thead>
      <tr>
        <th>${checkin}</th>
        <th>${checkout}</th>
        <th>${status}</th>
        <th>${rClass}</th>
        <th>${nameH}</th>
        <th>${surnameH}</th>
        <th>${amountH}</th>
       
        <th></th>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${requests}" var="request" >
      <tr>
      <jstl:if test="${request.checkIn == null}">
     	 <td></td><td></td>
      </jstl:if>
      <jstl:if test="${request.checkIn != null}">
        <td>${request.checkIn}</td>
        <td>${request.checkOut}</td>
      </jstl:if>
        <td>${request.status}</td>
        <td>${request.rclass.title}</td>
        <td>${request.student.name}</td>
         <td>${request.student.surname}</td>
      	<td><jstl:out value="${amount[request.id]}"/></td>
        <security:authorize access="hasRole('ADMIN')">
        <td>
        	<jstl:if test="${request.status eq 'DENIED' }">
        	<a class="btn btn-success" href="javascript: window.location.replace('administrator/request/manage.do?requestId=${request.id}')"><spring:message code="request.manage" /></a>
       		</jstl:if>
		</td>
        </security:authorize>
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
	       <jstl:if test="${request.status eq 'AWAITING PAYMENT'}">
	       
	        <td>
	         <form name="_xclick" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
			   <input type="hidden" name="cmd" value="_xclick">
			   <input type="hidden" name="business" value="TeachEasy@gmail.com">
			   <input type="hidden" name="currency_code" value="EUR">
			   <input type="hidden" name="item_name" value="${request.rclass.title}">
			   <input type="hidden" name="amount" value="${amount[request.id]}">
			   <input type='hidden' name='return' value="http://teacheasy.jelastic.cloudhosted.es/student/request/paid.do?requestId=${request.id}">
			   <input type='hidden' name='cancel' value="http://teacheasy.jelastic.cloudhosted.es/student/request/list.do">
			   <input class="btn btn-primary" type="submit" name="save" alt="PayPal, la forma rápida y segura de pagar en Internet." value="<spring:message code="request.pay" />">
			  
			 </form>
	        </td>
	        	<td>
        			<a class="btn btn-danger" href="javascript: window.location.replace('student/request/cancel.do?requestId=${request.id}')"><spring:message code="request.cancel" /></a>
        		</td>
	        </jstl:if>
	         </td>
	        <td>
       		<jstl:if test="${request.status eq 'ACCEPTED' }">
       			<jstl:if test="${oneDay[request.id] == true}">
	       			
	        			<a class="btn btn-danger" href="javascript: window.location.replace('student/request/cancel.do?requestId=${request.id}')"><spring:message code="request.cancel" /></a>
	        		
	        	</jstl:if>
        	</jstl:if>
        	</td>
        	<td>
        	<jstl:if test="${request.status eq 'PENDING' }">
     			
        			<a class="btn btn-danger" href="javascript: window.location.replace('student/request/cancel.do?requestId=${request.id}')"><spring:message code="request.cancel" /></a>
        		
        	</jstl:if>
        	</td>
	    </security:authorize>
	      </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</div>
<script>
function target_popup(form) {
	posicion_x=(screen.width/2)-200; 
	posicion_y=(screen.height/2)-200; 
    window.open('', 'formpopup', 'width=400,height=400,resizeable,scrollbars,left='+posicion_x+",top="+posicion_y+"");
    form.target = 'formpopup';
}
</script>
<script>
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>



