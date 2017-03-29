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
	<div class="row mt-lg">
		<div class="col-md-12">
			<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
			<input type="hidden" name="cmd" value="_s-xclick">
			<input type="hidden" name="hosted_button_id" value="EH2WRB79Z6KJL">
			<input type="image" src="https://www.paypalobjects.com/es_ES/ES/i/btn/btn_buynowCC_LG.gif" border="0" name="submit" alt="PayPal, la forma rápida y segura de pagar en Internet.">
			<img alt="" border="0" src="https://www.paypalobjects.com/es_ES/i/scr/pixel.gif" width="1" height="1">
			</form>
		</div>
	</div>

</div>
<div class="col-md-3"></div>



	


			
	
	



	
