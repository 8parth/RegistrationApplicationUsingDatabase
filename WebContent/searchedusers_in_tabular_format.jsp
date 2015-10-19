<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String fna = (String) session.getAttribute("fn");
String lna = (String) session.getAttribute("ln");
String una = (String) session.getAttribute("un");
String password = (String) session.getAttribute("passwd");
String id = (String) session.getAttribute("id");

 %>
	<table>
			<tr>
				<th>First Name :</th>
				<td><% out.print(fna); %></td>
			</tr>

			<tr>
				<th>Last Name :</th>
				<td><% out.print(lna); %></td>
			</tr>

			<tr>
				<th>User Name :</th>
				<td><% out.print(una); %></td>
			</tr>

			<tr>
				<th>Password:</th>
				<td><% out.print(password); %></td>
			</tr>
		</table>
 
 

</body>
</html>