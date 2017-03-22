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
				<th><spring:message code="academy.iban"/></th>
				<td><jstl:out value="${academy.iban}"/></td>
			</tr>
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
	
	
<display:table pagesize="10" class="displaytag" keepStatus="true" name="comments" id="row" requestURI="${requestURI}">	
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

<security:authorize access="hasAnyRole('STUDENT')">
	<input type="button" name="comment" value="<spring:message code="academy.comment" />"
			onclick="javascript: window.location.replace('commentator/comment/create.do?commentableId=${academy.id}')" />
<br/>
</security:authorize>