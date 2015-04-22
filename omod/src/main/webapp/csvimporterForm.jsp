<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<!-- There is no "action" on this form, so it posts back to the same url.  This is needed so that spring picks up and uses the same
controller.  When spring sees a "post", it calls the onSubmit methods on the controller -->
<form method="post">
	<fieldset>
		<table>
			<tr>
				<td><openmrs:message code="general.name" /></td>
				<td><spring:bind path="department.name">
						<input type="text" name="name" value="${status.value}" size="35" />
						<c:if test="${status.errorMessage != ''}">
							<span class="error">${status.errorMessage}</span>
						</c:if>
					</spring:bind></td>
			</tr>
			<tr>
				<td valign="top"><openmrs:message code="general.description" /></td>
				<td valign="top"><spring:bind path="department.description">
						<textarea name="description" rows="3" cols="40"
							onkeypress="return forceMaxLength(this, 1024);">${status.value}</textarea>
						<c:if test="${status.errorMessage != ''}">
							<span class="error">${status.errorMessage}</span>
						</c:if>
					</spring:bind></td>
			</tr>
		</table>
		<br /> <input type="submit"
			value="<openmrs:message code="csvimporter.save"/>" name="save">
	</fieldset>
</form>

<br />
<br />
This page is accessed at
"localhost:8080/openmrs/module/csvimporter/csvimporterForm.htm" because
we set it to that in the /metadata/moduleApplicationContext.xml file in
the awesomeExampleMapping element.

<%@ include file="/WEB-INF/template/footer.jsp"%>