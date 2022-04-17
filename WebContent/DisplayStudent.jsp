<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%

String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/college";
//String database = "ro";
String userid = "root";
String password = "root";
try {
	Class.forName(driver);
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet rs = null;
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Practical-9</title>
<!-- <link rel="stylesheet" type="text/css" href="loginCSS.css"> -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<br>
	<center>
		<h3>Retrieve data from database in JSP</h3>
	</center>
	<br>
	<table class="table table-hover container">
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Name</th>
			<th scope="col">Email</th>
			<th scope="col">Password</th>
			<th scope="col">Phone</th>
			<th scope="col">Gender</th>
			<th scope="col">DOB</th>
		</tr>

		<%
			try {
			connection = DriverManager.getConnection(connectionUrl, userid, password);
			statement = connection.createStatement();
			String sql = "select * from student2";
			rs = statement.executeQuery(sql);
			while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("sid")%></td>
			<td><%=rs.getString("sfname")%>&nbsp;<%=rs.getString("smname")%>&nbsp;<%=rs.getString("slname")%></td>
			<td><%=rs.getString("semail")%></td>
			<td><%=rs.getString("spassword")%></td>
			<td><%=rs.getString("sphone")%></td>
			<td><%=rs.getString("sgender")%></td>
			<td><%=rs.getDate("sdob")%></td>
		</tr>
		<%
			}
		connection.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		%>
	</table>
</body>
</html>