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
			<td>
				<img src="${teacher.picture}" width="100" height="100" >
				
			</td>
		</tr>
		<tr>
			<th><spring:message code="teacher.name"/></th>
			<th><spring:message code="teacher.surname"/></th>
			
		</tr>
		<tr>
			<td><jstl:out value="${teacher.name}"/></td>
			<td><jstl:out value="${teacher.surname}"/></td>
		</tr>
		<tr>
			<th><spring:message code="teacher.email"/></th>
			<th><spring:message code="teacher.phone"/></th>
			<th><spring:message code="teacher.date"/></th>
		</tr>
		<tr>
			<td><jstl:out value="${teacher.email}"/></td>
			<td><jstl:out value="${teacher.phone}"/></td>
			<td><fmt:formatDate value="${teacher.date }" pattern="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<th><spring:message code="teacher.city"/></th>
			<th><spring:message code="teacher.address"/></th>
			
		</tr>
		<tr>
			<td><jstl:out value="${teacher.city}"/></td>
			<td><jstl:out value="${teacher.address}"/></td>
		</tr>
		<tr>
			<th><spring:message code="teacher.avgStars"/></th>			
		</tr>
		<tr>
			<td><jstl:out value="${teacher.avgStars}"/></td>
		</tr>
	</tbody>
</table>

<jstl:if test="${teacher.curricula != null}">
	<table id="row" class="table">
		<tbody>
			<tr>
				<th><spring:message code="teacher.curricula.educationSection"/></th>
				
			</tr>
			<tr>
				<td><jstl:out value="${teacher.curricula.educationSection}"/></td>
			</tr>
			<tr>
				<th><spring:message code="teacher.curricula.experienceSection"/></th>
			</tr>
			<tr>
				<td><jstl:out value="${teacher.curricula.experienceSection}"/></td>
			</tr>
			<tr>
				<th><spring:message code="teacher.curricula.hobbiesSection"/></th>
			</tr>
			<tr>
				<td><jstl:out value="${teacher.curricula.hobbiesSection}"/></td>
	
			</tr>
		</tbody>
	</table>
</jstl:if>	

<jstl:if test="${teacher.userAccount.username == pageContext.request.remoteUser}">
	<table id="row" class="table">
		<tbody>
			<tr>
				<th><spring:message code="teacher.iban"/></th>
				<td><jstl:out value="${teacher.iban}"/></td>
			</tr>
			<tr>
				<th><spring:message code="teacher.feeAmount"/></th>
				<td><jstl:out value="${teacher.feeAmount}"/></td>
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
	
	
<display:table pagesize="10" class="displaytag" keepStatus="true" name="comments" id="row" requestURI="${requestURI}">	
	<spring:message code="teacher.comment.title" var="titleHeader"/>
	<display:column title="${titleHeader }" property="title"/>
	
	<spring:message code="teacher.comment.postedMoment" var="postedMomentHeader"/>
	<display:column title="${postedMomentHeader}" sortable="true"><fmt:formatDate value="${row.createMoment }" pattern="dd/MM/yyyy HH:mm" /></display:column>
	
	<spring:message code="teacher.comment.text" var="textHeader"/>
	<display:column title="${textHeader }" property="text"/>
	
	<spring:message code="teacher.comment.commentator" var="commentatorHeader"/>
	<display:column title="${commentatorHeader }">
			<jstl:out value="${row.student.name}"/>
	</display:column>
	<spring:message code="teacher.comment.stars" var="starsHeader"/>
	<display:column title="${starsHeader }" property="stars"/>
</display:table>

<security:authorize access="hasAnyRole('teacher','TEACHER', 'ACADEMY')">
	<input type="button" name="comment" value="<spring:message code="teacher.comment" />"
			onclick="javascript: window.location.replace('commentator/comment/create.do?commentableId=${teacher.id}')" />
<br/>
</security:authorize>