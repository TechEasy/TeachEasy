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

<table id="row" class="table">
	<tbody>
		<tr>
			<th><spring:message code="academy.name"/></th>
			<th><spring:message code="academy.city"/></th>
			
		</tr>
		<tr>
			<td><jstl:out value="${academy.name}"/></td>
			<td><jstl:out value="${academy.city}"/></td>
		</tr>
		<tr>
			<th><spring:message code="academy.address"/></th>
			<th><spring:message code="academy.cif"/></th>
		</tr>
		<tr>
			<td><jstl:out value="${academy.address}"/></td>
			<td><jstl:out value="${academy.cif}"/></td>
		</tr>
		<tr>
			<th><spring:message code="academy.description"/></th>
			<th></th>
			
		</tr>
		<tr>
			<td><jstl:out value="${academy.description}"/></td>
			<td></td>
		</tr>
		<tr>
			<th><spring:message code="academy.avgStars"/></th>	
			<th></th>			
		</tr>
		<tr>
			<td><jstl:out value="${academy.avgStars}"/></td>
			<td></td>
		</tr>
	</tbody>
</table>

<jstl:if test="${academy.userAccount.username == pageContext.request.remoteUser}">
	<table id="row" class="table">
		<tbody>
			<tr>
				<th><spring:message code="academy.feeAmount"/></th>
				<td><jstl:out value="${academy.feeAmount}"/></td>
			</tr>
	</table>
</jstl:if>	
			
	
	<display:table name="socialIdentities"
		 id="row"
		 class="displaytag"
		 pagesize="10" 
		 requestURI="${requestURI}">
		 		      
		 <spring:message code="socialIdentity.nick" var="nickHeader" />
		 <display:column property="nick" title="${nickHeader}" sortable="true"/>
		 
		 <spring:message code="socialIdentity.socialNetwork" var="socialNetworkHeader" />
		 <display:column property="socialNetwork" title="${socialNetworkHeader}" sortable="true"/>
		 
		 <spring:message code="socialIdentity.profileURL" var="profileURLHeader" />
		 <display:column property="profileUrl" title="${profileURLHeader}" sortable="false"/>  

</display:table>
	
	
<display:table pagesize="10" class="displaytag" keepStatus="true" name="commentable" id="row" requestURI="${requestURI}">	
	<spring:message code="academy.comment.title" var="titleHeader"/>
	<display:column title="${titleHeader }" property="title"/>
	
	<spring:message code="academy.comment.postedMoment" var="postedMomentHeader"/>
	<display:column title="${postedMomentHeader}" sortable="true"><fmt:formatDate value="${row.createMoment }" pattern="dd/MM/yyyy HH:mm" /></display:column>
	
	<spring:message code="academy.comment.text" var="textHeader"/>
	<display:column title="${textHeader }" property="text"/>
	
	<spring:message code="academy.comment.commentator" var="commentatorHeader"/>
	<display:column title="${commentatorHeader }">
			<jstl:out value="${row.student.name}"/>
	</display:column>
	<spring:message code="academy.comment.stars" var="starsHeader"/>
	<display:column title="${starsHeader }" property="stars"/>
</display:table>

<security:authorize access="hasRole('STUDENT')">
	<input type="button" name="comment" value="<spring:message code="academy.comment" />"
			onclick="javascript: window.location.replace('comment/create.do?idEntity=${row.commentable.id}')" />
<br/>
</security:authorize>

<div class="col-md-12">
	<h2><strong><spring:message code="academy.info"/></strong></h2>
	<div class="row border-bottom-section">
		<div class="col-md-1"></div>
		<div class="col-md-4 mt-md align-center">
			<img src="${academy.picture}" width="250" height="250" class="mb-md" >
			<input id="star-academy-${academy.id}" name="star-academy-${academy.id}" value="${academy.avgStars}" class="rating-loading" data-size="xs">
		</div>
		<div class="col-md-6">
			<div class="row border-bottom">
				<div class="col-md-4">
					<h4><strong><spring:message code="academy.name"/>: </strong></h4>
				</div>
				<div class="col-md-8 text-right">
					<h4>${academy.name}</h4>
				</div>
			</div>
			<div class="row border-bottom">
				<div class="col-md-4">
					<h4><strong><spring:message code="academy.city"/>: </strong></h4>
				</div>
				<div class="col-md-8 text-right">
					<h4>${academy.city}</h4>
				</div>
			</div>
			<div class="row border-bottom">
				<div class="col-md-4">
					<h4><strong><spring:message code="academy.cif"/>: </strong></h4>
				</div>
				<div class="col-md-8 text-right">
					<h4>${academy.cif}</h4>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<h4><strong><spring:message code="academy.description"/>: </strong></h4>
				</div>
				<div class="col-md-8 text-right">
					<h4>${academy.description}</h4>
				</div>
			</div>	
		</div>
		<div class="col-md-1"></div>	
	</div>
	<jstl:if test="${not empty socialIdentities}">
	<h2><strong><spring:message code="socialIdentity.info"/></strong></h2>
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
	<h2><strong><spring:message code="comment.info"/></strong></h2>
	<jstl:if test="${not empty commentable}">
	<div class="row mt-md mb-md ">
		<div class="col-md-12">
			<c:forEach items="${commentable}" var="comment" >
				<div class="row mt-md border-bottom">
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
								<input id="star-comment-${comment.id}" name="star-comment-${comment.id}" value="${comment.stars}" class="rating-loading" data-size="xs">
							</div>
						</div>
					</div>		
				</div>
			</c:forEach>
		</div>
	</div>
	</jstl:if>
	<security:authorize access="hasRole('STUDENT')">
	<input type="button" name="comment" value="<spring:message code="academy.comment" />"
			onclick="javascript: window.location.replace('comment/create.do?idEntity=${academy.id}')" />
	</security:authorize>
</div>

<script>
	$(document).ready(function(){
	    $('[id^="star-comment-"]').rating({displayOnly: true, step: 0.5});
	;
    $('[id^="star-academy-"]').rating({displayOnly: true, step: 0.5});
	;
	});
</script>