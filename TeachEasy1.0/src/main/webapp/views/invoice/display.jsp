<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<table id="row" class="table">
	<tbody>
		<tr>
			<th><spring:message code="invoice.authoredMoment"/></th>
			<th><spring:message code="invoice.vatNumber"/></th>
			
		</tr>
		<tr>
			<td><fmt:formatDate value="${invoice.authoredMoment}" pattern="dd/MM/yyyy" /></td>
			<td><jstl:out value="${invoice.vatNumber}"/></td>
		</tr>
		<tr>
			<th><spring:message code="invoice.information"/></th>
			<th><spring:message code="invoice.details"/></th>
			
		</tr>
		<tr>
			<td><jstl:out value="${invoice.information}"/></td>
			<td><jstl:out value="${invoice.details}"/></td>
			
		</tr>
		<tr>
			<th><spring:message code="invoice.total"/></th>
			<th></th>
		</tr>
		<tr>
			<td><jstl:out value="${invoice.total}"/></td>
			<td><form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
<input type="hidden" name="cmd" value="_s-xclick">
<input type="hidden" name="hosted_button_id" value="EH2WRB79Z6KJL">
<input type="image" src="https://www.paypalobjects.com/es_ES/ES/i/btn/btn_buynowCC_LG.gif" border="0" name="submit" alt="PayPal, la forma r�pida y segura de pagar en Internet.">
<img alt="" border="0" src="https://www.paypalobjects.com/es_ES/i/scr/pixel.gif" width="1" height="1">
</form></td>
			
			
			
		</tr>
	</tbody>
</table>


	


			
	
	



	
