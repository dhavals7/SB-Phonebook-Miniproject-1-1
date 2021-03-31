<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Contact Information</h3>
	<form:form action="saveContact?contactId=${contact.contactId}" method="POST" modelAttribute="contact">
	
	${successmessage}
	
	<table>
		<tr>
			<td>Name:</td>
			<td><form:input path="contactName"/></td>
		</tr>
		
		<tr>
			<td>Email:</td>
			<td><form:input path="contactEmail"/></td>
		</tr>
		
		<tr>
			<td>Phno.:</td>
			<td><form:input path="contactNo"/></td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Submit"/></td>
		</tr>
	</table>
	
	</form:form>
	
	<a href="view-contacts">View all contacts</a>
	

</body>
</html>