<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<ul id="menu">
	<li class="first">
		<a href="${pageContext.request.contextPath}/admin">
		<spring:message code="admin.title.short"/></a>
	</li>
	<li <c:if test='<%= request.getRequestURI().contains("spreadsheetimportForm") %>'>class="active"</c:if>>
		<a href="spreadsheetimport.form">
			New Import Template
		</a>
	</li>
	<li <c:if test='<%= request.getRequestURI().contains("spreadsheetimportTemplateList") %>'>class="active"</c:if>>
		<a href="spreadsheetimport.list">
			Import Templates
		</a>
	</li>
</ul>

<br/>
<table>
  <tr>
   <th>Patient Id</th>
   <th>Name</th>
   <th>Identifier</th>
  </tr>
  <c:forEach var="patient" items="${thePatientList}">
      <tr>
        <td>${patient.patientId}</td>
        <td>${patient.personName}</td>
        <td>${patient.patientIdentifier}</td>
      </tr>		
  </c:forEach>
</table>

<%@ include file="/WEB-INF/template/footer.jsp"%>
