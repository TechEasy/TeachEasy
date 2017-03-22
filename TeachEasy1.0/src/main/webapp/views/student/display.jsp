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
				<img src="${student.picture}" width="100" height="100" >
				
			</td>
		</tr>
		<tr>
			<th><spring:message code="student.name"/></th>
			<th><spring:message code="student.surname"/></th>
			
		</tr>
		<tr>
			<td><jstl:out value="${student.name}"/></td>
			<td><jstl:out value="${student.surname}"/></td>
		</tr>
		<tr>
			<th><spring:message code="student.email"/></th>
			<th><spring:message code="student.phone"/></th>
			
		</tr>
		<tr>
			<td><jstl:out value="${student.email}"/></td>
			<td><jstl:out value="${student.phone}"/></td>
			
		</tr>
		<tr>
			<th><spring:message code="student.date"/></th>
			<th><spring:message code="student.city"/></th>
		
			
		</tr>
		<tr>
			<td><fmt:formatDate value="${student.date }" pattern="dd/MM/yyyy" /></td>
			<td><jstl:out value="${student.city}"/></td>
		</tr>
		<tr>
			
			<th><spring:message code="student.address"/></th>
				<th></th>
		</tr>
		<tr>
			<td><jstl:out value="${student.address}"/></td>
				<td></td>
		</tr>
	</tbody>
</table>
			
	<jstl:if test="${student.userAccount.username == pageContext.request.remoteUser}">
	
		<table id="row" class="table">
			<tbody>
				<tr>
					<th><spring:message code="student.creditCard.brandName"/></th>
					<td><jstl:out value="${student.creditCard.brandName}"/></td>
				</tr>
				<tr>
					<th><spring:message code="student.creditCard.number"/></th>
					<td><jstl:out value="${student.creditCard.number}"/></td>
				</tr>
				<tr>
					<th><spring:message code="student.creditCard.expirationMonth"/></th>
					<td><jstl:out value="${student.creditCard.expirationMonth}"/></td>
				</tr>
				<tr>
					<th><spring:message code="student.creditCard.expirationYear"/></th>
					<td><jstl:out value="${student.creditCard.expirationYear}"/></td>
				</tr>
				<tr>
					<th><spring:message code="student.creditCard.cvv"/></th>
					<td><jstl:out value="${student.creditCard.cvv}"/></td>
				</tr>
				<tr>	
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
	<spring:message code="student.comment.title" var="titleHeader"/>
	<display:column title="${titleHeader }" property="title"/>
	
	<spring:message code="student.comment.postedMoment" var="postedMomentHeader"/>
	<display:column title="${postedMomentHeader}" sortable="true"><fmt:formatDate value="${row.createMoment }" pattern="dd/MM/yyyy HH:mm" /></display:column>
	
	<spring:message code="student.comment.text" var="textHeader"/>
	<display:column title="${textHeader }" property="text"/>
	
	<spring:message code="student.comment.commentator" var="commentatorHeader"/>
	<display:column title="${commentatorHeader }">
			<jstl:out value="${row.student.name}"/>
	</display:column>
	<spring:message code="student.comment.stars" var="starsHeader"/>
	<display:column title="${starsHeader }" property="stars"/>
</display:table>

<security:authorize access="hasAnyRole('STUDENT','TEACHER', 'ACADEMY')">
	<input type="button" name="comment" value="<spring:message code="student.comment" />"
			onclick="javascript: window.location.replace('commentator/comment/create.do?commentableId=${student.id}')" />
<br/>
</security:authorize>