<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>

	<form action="CheckRegi">
		<table>
			<tr>
				<td>First Name :</td>
				<td><input type="text" name="fn" value="Enter first name here..."/></td>
				<!-- <br> -->
			</tr>

			<tr>
				<td>Last Name :</td>
				<td><input type="text" name="ln" value="x"/> <!-- <br>  --></td>
			</tr>

			<tr>
				<td>User Name :</td>
				<td><input type="text" name="un" value="x"/></td>
				<!-- <br>  -->
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="passwd" value="1"/> <!-- <br> --></td>
			</tr>

			<tr>
				<td>Confirm Password:</td>
				<td><input type="password" name="c_passwd" /></td>

			</tr>
			<tr>
				<td><input type="submit" name="sub" value="Sign up!"/></td>
				<td></td>
			</tr>
		</table>
	</form>


</body>
</html>