<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% if (request.getAttribute("msg") !=null) { %>

<%=request.getAttribute("msg") %>
<%
}
%>
	<form:form modelAttribute="loginPojo" action="login.htm" method="post">
	<table align="center">
							<tr>
								<td>
									Username:
							</td>
							<td>
									<form:input path="userName" name="userName" id="userName" />
								</td>
							</tr>
							
							<tr>
								<td>
									Password:
							</td>
							<td>
									<form:input path="pwd" name="password" id="password" />
								</td>
							</tr>
	
							<tr>
								<td></td>
								<td align ="left">
									<form:button id="login" name="login">Login</form:button>
								</td>
							</tr>
							<tr></tr>		
	
	</table>

	</form:form>
	
	
</body>
</html>