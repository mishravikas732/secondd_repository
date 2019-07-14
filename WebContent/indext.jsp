<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form name="insert" method="Post" action="ActionController">
<table>
<tr>
<td>First Name</td>
<td><input type="text" name="fname"></td>
</tr>
<tr>
<td>Last Name</td>
<td><input type="text" name="lname"></td>
</tr>
<tr>
<td>Email</td>
<td><input type="text" name="email"></td>
</tr>
<tr>
<td>Mobile Number</td>
<td><input type="text" name="mobile"></td>
<tr>
<td>Address</td>
<td><input type="text" name="address"></td>
</tr>
<tr>
<td>Salary</td>
<td><input type="text" name="salary"></td>
</tr>
<tr>
<td>ID</td>
<td><input type="text" name="id"></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" name="action" value="insert">
</tr>
</table>

</form>

</body>
</html>