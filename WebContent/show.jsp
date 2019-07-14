<%@page import="java.util.ArrayList"%>
<%@page import="com.sample.util.StudentUtil"%>
<%@page import="com.sample.bean.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
StudentDao sd=new StudentDao();
List <Student> list=sd.getAllStudent();
%>
<table border="1" align="center">
<tr>
<td>First Name</td>
<td>Last Name</td>
<td>Email</td>
<td>Address</td>
<td>Mobile Number </td>
<td>Salary</td>
<td>ID</td>

</tr>


<%
for(Student s:list)
{
%>
<tr>
<td><%=s.getFname()%></td>
<td><%=s.getLname()%></td>
<td><%=s.getEmail()%></td>
<td><%=s.getAddress()%></td>
<td><%=s.getMobile()%></td>
<td><%=s.getSalary()%></td>
<td><%=s.getId() %></td>
<td>
<form name="edit" method= "post" action ="ActionController">
<input type="hidden" name="id" value="<%=s.getId()%>">
<input type="submit" name="action" value="Edit">

</form>
</td>
<td>
<form name="delete" method="post" action="ActionController">
<input type="hidden" name="id" value=<%=s.getId() %>>
<input type="submit" name="action" value="delete">


</form>

</td>
</tr>
<%
}
%>





</table>

</body>
</html>