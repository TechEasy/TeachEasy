<%--
 * footer.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:useBean id="date" class="java.util.Date" />
<hr/>
<div class="row">

	<div class="col-md-6 col-xs-6">
		<b>Copyright &copy; <fmt:formatDate value="${date}" pattern="yyyy" /> TeachEasy Co., Inc.</b>
	</div>
	<div class="col-md-6 col-xs-6 text-right">
		<a data-toggle="modal" data-target="#myModal"><spring:message code="master.page.lopd" /></a>
		<spring:message code='master.page.cookies' var="text" javaScriptEscape="true" />
	</div>
</div>

<div class="modal fade" id="myModal" >
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"><spring:message code="lopd.title" /></h4>
        </div>
        <div class="modal-body">
          <p><spring:message code="lopd.text" /></p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
</div>

<script type="text/javascript">
	function closeCookiesWarning(){
		localStorage.setItem("cw_Enabled", 'falso');
		window.location.reload();
	}
	
	var value=localStorage.getItem("cw_Enabled");
	
	if(value!='falso'){
		document.write("<div class='cookiePopUp'><div class='cookies_close'><a href='javascript:closeCookiesWarning()'><img src='images/cpu_Close.png' alt='Close' border='0' /></a></div><p class='pCookiesText'>${text}</p></div>");
	}
</script>