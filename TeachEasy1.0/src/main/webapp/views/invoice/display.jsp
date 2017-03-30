<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<div class="col-md-3"></div>
<div class="col-md-6">

	<div class="row">
		<div class="col-md-6"><h3><strong><spring:message code="invoice.authoredMoment"/>: </strong></h3></div>
		<div class="col-md-6"><h3><fmt:formatDate value="${invoice.authoredMoment}" pattern="dd/MM/yyyy" /></h3></div>
	</div>
	<div class="row">
		<div class="col-md-6"><h3><strong><spring:message code="invoice.vatNumber"/>: </strong></h3></div>
		<div class="col-md-6"><h3><jstl:out value="${invoice.vatNumber}"/></h3></div>
	</div>
	<div class="row">
		<div class="col-md-6"><h3><strong><spring:message code="invoice.information"/>: </strong></h3></div>
		<div class="col-md-6"><h3><jstl:out value="${invoice.information}"/></h3></div>
	</div>
	<div class="row">
		<div class="col-md-6"><h3><strong><spring:message code="invoice.details"/>: </strong></h3></div>
		<div class="col-md-6"><h3><jstl:out value="${invoice.details}"/></h3></div>
	</div>
	<div class="row">
		<div class="col-md-6"><h3><strong><spring:message code="invoice.total"/>: </strong></h3></div>
		<div class="col-md-6"><h3><jstl:out value="${invoice.total}"/></h3></div>
	</div>
</div>
<div class="col-md-3"></div>



	


			
	
	



	
