<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-md-12">
	<h2><strong><spring:message code="student.personal.info"/></strong></h2>
	<div class="row">
	<div class="col-md-12">
	<div class="card-bordered">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-4 mt-md">
			<img src="${student.picture}" width="250" height="250" >
		</div>
		<div class="col-md-6">
			<div class="row border-bottom">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="student.name"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right">
					<h4>${student.name}</h4>
				</div>
			</div>
			<div class="row border-bottom">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="student.surname"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right">
					<h4>${student.surname}</h4>
				</div>
			</div>
			<div class="row border-bottom">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="student.email"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right">
					<h4>${student.email}</h4>
				</div>
			</div>
			<div class="row border-bottom">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="student.phone"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right">
					<h4>${student.phone}</h4>
				</div>
			</div>
			<div class="row border-bottom">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="student.date"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right">
					<h4><fmt:formatDate value="${student.date }" pattern="dd/MM/yyyy" /></h4>
				</div>
			</div>
			<div class="row border-bottom">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="student.city"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right">
					<h4>${student.city}</h4>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="student.address"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right">
					<h4>${student.address}</h4>
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>	
	</div>
	</div>
	</div>
	</div>
	<jstl:if test="${not empty socialIdentities}">
	<h2><strong><spring:message code="socialIdentity.info"/></strong></h2>
	<div class="row">
	<div class="col-md-12">
	<div class="card-bordered">
	<div class="table-responsive">
	<table class="table table-striped" id="table-socialIde">
		<thead>
	      <tr>
	        <th><spring:message code="socialIdentity.nick"/></th>
	        <th><spring:message code="socialIdentity.socialNetwork"/></th>
	        <th><spring:message code="socialIdentity.profileURL"/></th>
	      </tr>
	    </thead>
	    <tbody>
		<c:forEach items="${socialIdentities}" var="socialIdentity" >
	      <jstl:if test="${socialIdentity.id != null}">
	      <tr>    
	        <td>${socialIdentity.nick}</td>
	        <td>${socialIdentity.socialNetwork}</td>
	        <td><a href="${socialIdentity.profileUrl}">${socialIdentity.profileUrl}</a></td>
	      </tr>
	      </jstl:if>
	    </c:forEach>
	    </tbody>
	</table>
	<div class='pagination-container' >
	<nav>
	  <ul class="pagination" id="pagination"></ul>
	</nav>
	</div>
	</div>
	</div>
	</div>
	</div>
	</jstl:if>

	<jstl:if test="${not empty comments}">
	<h2><strong><spring:message code="comment.info"/></strong></h2>
	<div class="row">
	<div class="col-md-12">
	<div class="card-bordered">
	<div class="row">
		<div class="col-md-12" id="contenedor-tarjetas">
			<c:forEach items="${comments}" var="comment" >
				<div class="row mt-md border-bottom paginador-item mb-md">
					<div class="col-md-12">
						<div class="row">
							<div class="col-md-12">
								<h3>${comment.student.name}</h3>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<h4>${comment.title}</h4>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="table-responsive">
										<table class="table table-striped">
										<tbody>
											<tr><td>${comment.text}</td></tr>
										</tbody>
										</table>
									</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<input id="star-comment-${comment.id}" name="star-comment-${comment.id}" value="${comment.stars}" class="rating-loading" data-size="sm">
							</div>
						</div>
					</div>		
				</div>
			</c:forEach>
		</div>
	</div>
	</div>
	</div>
	</div>
	</jstl:if>
</div>

<script>
	$(document).ready(function(){
	    $('[id^="star-comment-"]').rating({displayOnly: true, step: 0.5});
	    getPagination('#table-socialIde', 5);
		$ ('#contenedor-tarjetas').easyPaginate({
		    	paginateElement: 'div.paginador-item',
		    	elementsPerPage: 5,
		    	effect: 'climb'
		 });
	});
</script>

