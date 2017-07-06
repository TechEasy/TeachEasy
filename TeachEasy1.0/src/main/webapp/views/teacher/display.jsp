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
	<h2><strong><spring:message code="teacher.info"/></strong></h2>
		<div class="row">
		<div class="col-md-12">
		<div class="card-bordered">
		<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-4 mt-md">
			<img src="${teacher.picture}" width="250" height="250" class="mb-md">
			<input id="star-teacher-${teacher.id}" name="star-teacher-${teacher.id}" value="${teacher.avgStars}" class="rating-loading" data-size="xs">
		</div>
		<div class="col-md-6">
			<div class="row border-bottom">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="teacher.name"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right">
					<h4>${teacher.name}</h4>
				</div>
			</div>
			<div class="row border-bottom">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="teacher.surname"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right">
					<h4>${teacher.surname}</h4>
				</div>
			</div>
			<div class="row border-bottom">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="teacher.email"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right">
					<h4>${teacher.email}</h4>
				</div>
			</div>
			<div class="row border-bottom">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="teacher.phone"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right">
					<h4>${teacher.phone}</h4>
				</div>
			</div>
			<div class="row border-bottom">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="teacher.date"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right">
					<h4><fmt:formatDate value="${teacher.date }" pattern="dd/MM/yyyy" /></h4>
				</div>
			</div>
			<div class="row border-bottom">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="teacher.city"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right">
					<h4>${teacher.city}</h4>
				</div>
			</div>
			<div class="row border-bottom">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="teacher.address"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right">
					<h4>${teacher.address}</h4>
				</div>
			</div>
			<security:authorize access="hasRole('TEACHER')">
			<jstl:if test="${pageContext.request.userPrincipal.name==teacher.userAccount.username }">
			<div class="row border-bottom">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="teacher.paypalMail"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right">
					<h4>${teacher.paypalMail}</h4>
				</div>
			</div>	
			
			<div class="row">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="teacher.feeAmount"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right">
					<h4>${teacher.feeAmount}</h4>
				</div>
			</div>	
			</jstl:if>
			</security:authorize>
		</div>
		<div class="col-md-1"></div>	
	</div>
	</div>
	</div>
	</div>
	
	<h2><strong><spring:message code="teacher.aditionalinfo"/></strong></h2>
	<div class="row">
	<div class="col-md-12">
	<div class="card-bordered">
	<div class="table-responsive">
	<table class="table table-striped">
	    <tbody>
	      <tr>    
	        <td><strong><spring:message code="teacher.curricula.educationSection"/>: </strong></td>
	        <td>${teacher.curricula.educationSection}</td>
	      </tr>
	      <tr>    
	        <td><strong><spring:message code="teacher.curricula.experienceSection"/>: </strong></td>
	        <td>${teacher.curricula.experienceSection}</td>
	      </tr>
	      <tr>    
	        <td><strong><spring:message code="teacher.curricula.hobbiesSection"/>: </strong></td>
	        <td>${teacher.curricula.hobbiesSection}</td>
	      </tr>

	    </tbody>
	</table>
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
	<jstl:if test="${not empty commentable}">
	<h2><strong><spring:message code="comment.info"/></strong></h2>
	<div class="row">
	<div class="col-md-12">
	<div class="card-bordered">
	<div class="row">
		<div class="col-md-12" id="contenedor-tarjetas">
			<c:forEach items="${commentable}" var="comment" >
				<div class="row border-bottom paginador-item mb-md">
					<div class="col-md-12">
						<div class="row">
							<div class="col-md-12">
								<h3>${comment.title}</h3>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<h4>${comment.student.name} ${comment.student.surname}</h4>
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
						<div class="row mb-md">
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
	<security:authorize access="hasRole('STUDENT')">
		<div class="row mt-md">
		<div class="col-md-12">
			<a class="btn btn-primary" href="javascript: window.location.replace('comment/create.do?idEntity=${teacher.id}')"><spring:message code="teacher.comment" /></a>
		</div>
		</div>
	</security:authorize>
</div>

<script>
	$(document).ready(function(){
	    $('[id^="star-comment-"]').rating({displayOnly: true, step: 0.5});
  	 	$('[id^="star-teacher-"]').rating({displayOnly: true, step: 0.5});
  	 	getPagination('#table-socialIde', 5);
  	 	$ ('#contenedor-tarjetas').easyPaginate({
  	 	    	paginateElement: 'div.paginador-item',
  	 	    	elementsPerPage: 5,
  	 	    	effect: 'climb'
  	 	});
	});
</script>
