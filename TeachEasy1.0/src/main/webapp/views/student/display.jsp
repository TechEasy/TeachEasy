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
	<div class="row border-bottom-section">
		<div class="col-md-1"></div>
		<div class="col-md-4 mt-md">
			<img src="${student.picture}" width="250" height="250" >
		</div>
		<div class="col-md-6">
			<div class="row border-bottom">
				<div class="col-md-4">
					<h4><strong><spring:message code="student.name"/>: </strong></h4>
				</div>
				<div class="col-md-8 text-right">
					<h4>${student.name}</h4>
				</div>
			</div>
			<div class="row border-bottom">
				<div class="col-md-4">
					<h4><strong><spring:message code="student.surname"/>: </strong></h4>
				</div>
				<div class="col-md-8 text-right">
					<h4>${student.surname}</h4>
				</div>
			</div>
			<div class="row border-bottom">
				<div class="col-md-4">
					<h4><strong><spring:message code="student.email"/>: </strong></h4>
				</div>
				<div class="col-md-8 text-right">
					<h4>${student.email}</h4>
				</div>
			</div>
			<div class="row border-bottom">
				<div class="col-md-4">
					<h4><strong><spring:message code="student.phone"/>: </strong></h4>
				</div>
				<div class="col-md-8 text-right">
					<h4>${student.phone}</h4>
				</div>
			</div>
			<div class="row border-bottom">
				<div class="col-md-4">
					<h4><strong><spring:message code="student.date"/>: </strong></h4>
				</div>
				<div class="col-md-8 text-right">
					<h4><fmt:formatDate value="${student.date }" pattern="dd/MM/yyyy" /></h4>
				</div>
			</div>
			<div class="row border-bottom">
				<div class="col-md-4">
					<h4><strong><spring:message code="student.city"/>: </strong></h4>
				</div>
				<div class="col-md-8 text-right">
					<h4>${student.city}</h4>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<h4><strong><spring:message code="student.address"/>: </strong></h4>
				</div>
				<div class="col-md-8 text-right">
					<h4>${student.address}</h4>
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>	
	</div>
	<jstl:if test="${not empty socialIdentities}">
	<div class="row mt-md mb-md border-bottom-section">
		<div class="col-md-12">
			<div class="row text-center">
				<div class="col-md-4"><strong><spring:message code="socialIdentity.socialNetwork"/></strong></div>
				<div class="col-md-4"><strong><spring:message code="socialIdentity.nick"/></strong></div>
				<div class="col-md-4"><strong><spring:message code="socialIdentity.profileURL"/></strong></div>
			</div>
			<c:forEach items="${socialIdentities}" var="socialIdentity" >
				<div class="row mt-md text-center">
					<div class="col-md-4">${socialIdentity.socialNetwork}</div>
					<div class="col-md-4">${socialIdentity.nick}</div>
					<div class="col-md-4">${socialIdentity.profileUrl}</div>
				</div>
			</c:forEach>
		</div>
	</div>
	</jstl:if>
	<jstl:if test="${not empty comments}">
	<div class="row mt-md mb-md border-bottom-section">
		<div class="col-md-12">
			<c:forEach items="${comments}" var="comment" >
				<div class="row mt-md border-bottom">
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
								<p>${comment.text}</p>
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
	</jstl:if>
</div>

<script>
	$(document).ready(function(){
	    $('[id^="star-comment-"]').rating({displayOnly: true, step: 0.5});
	;
	});
</script>