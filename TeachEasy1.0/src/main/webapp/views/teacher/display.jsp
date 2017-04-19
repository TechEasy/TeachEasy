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
			<div class="row">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="teacher.address"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right">
					<h4>${teacher.address}</h4>
				</div>
			</div>
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
	<div class="row border-bottom">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="teacher.curricula.educationSection"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right mt-sm">
					${teacher.curricula.educationSection}
				</div>
	</div>
			<div class="row border-bottom">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="teacher.curricula.experienceSection"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right mt-sm">
					${teacher.curricula.experienceSection}
				</div>
			</div>
			<div class="row ">
				<div class="col-md-4 col-xs-4">
					<h4><strong><spring:message code="teacher.curricula.hobbiesSection"/>: </strong></h4>
				</div>
				<div class="col-md-8 col-xs-8 text-right mt-sm">
					${teacher.curricula.hobbiesSection}
				</div>
			</div>
		</div>
	</div>
	</div>
	<jstl:if test="${not empty socialIdentities}">
	<h2><strong><spring:message code="socialIdentity.info"/></strong></h2>
	<div class="row">
	<div class="col-md-12">
	<div class="card-bordered">
	<div class="row">
				<div class="col-md-3 col-xs-3"><strong><spring:message code="socialIdentity.socialNetwork"/></strong></div>
				<div class="col-md-3 col-xs-3"><strong><spring:message code="socialIdentity.nick"/></strong></div>
				<div class="col-md-6 col-xs-6"><strong><spring:message code="socialIdentity.profileURL"/></strong></div>
	</div>		
			<c:forEach items="${socialIdentities}" var="socialIdentity" >
			<div class="row">
					<div class="col-md-3 col-xs-3">${socialIdentity.socialNetwork}</div>
					<div class="col-md-3 col-xs-3">${socialIdentity.nick}</div>
					<div class="col-md-6 col-xs-6">${socialIdentity.profileUrl}</div>
			</div>
			</c:forEach>
	</div>
	</div>
	</div>
	</jstl:if>
	<h2><strong><spring:message code="schedule.info"/></strong></h2>
	<div class="row">
	<div class="col-md-12">
	<div class="card-bordered">
	<div class="row">
		<div class="col-md-12">
			<jstl:if test="${teacher.timeTable != null}">
			<table id="row" class="table">
			<jstl:forEach items="${teacher.timeTable.days}" var="day">
				<tr>
					<th><jstl:out value="${day.name}" /></th>
					<jstl:forEach items="${day.workTimes}" var="work">
						<tr>
							<td>
								<jstl:out value="${work.checkIn}-${work.checkOut}" />

							</td>
						</tr>
					</jstl:forEach>
				</tr>
			</jstl:forEach>
			</table>
			</jstl:if>
		</div>
	</div>
	</div>
	</div>
	</div>

	<jstl:if test="${not empty commentable}">
	<h2><strong><spring:message code="comment.info"/></strong></h2>
	<div class="row">
	<div class="col-md-12">
	<div class="card-bordered">
	<div class="row">
		<div class="col-md-12">
			<c:forEach items="${commentable}" var="comment" >
				<div class="row border-bottom">
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
								<p>${comment.text}</p>
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
	;
  	 	 $('[id^="star-teacher-"]').rating({displayOnly: true, step: 0.5});
	;
	});
</script>