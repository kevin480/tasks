<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.springmvc.dao.databasecon"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>List of users</h3>
<table border="1">

<%
com.springmvc.dao.databasecon obj = com.springmvc.dao.databasecon.getObject();
List l1 = obj.listofusers();
Iterator i1 = l1.iterator();
while(i1.hasNext())
{
	%>
<tr>
<td>
<% 
	out.println((String)i1.next());

%>
</td>
</tr>
<%
}

%>
</table>

</body>
</html>