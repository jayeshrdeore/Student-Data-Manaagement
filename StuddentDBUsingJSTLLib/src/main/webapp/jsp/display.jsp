<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.dao.StudentDAO"%>
<%@ page import="com.model.Student"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Display</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="../css/table.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="background-color: rgb(126, 209, 209);">

	<%!StudentDAO dao;

	public void jspInit() {

		dao = new StudentDAO();

	}%>

	<%
	String url = application.getInitParameter("url");
	String username = application.getInitParameter("username");
	String password = application.getInitParameter("password");
	%>


	<%
	List<Student> list = dao.getAllStudents(url, username, password);
	Iterator<Student> itr = list.iterator();

	application.setAttribute("list", list);
	%>
	<h1 style="text-align: center;">
		<b>Student Data Management</b>
	</h1>
	<h3 style="text-align: center;">
		<b>STUDENT DATA TABLE</b>
	</h3>

	<div class="container">
		<table class="table">
			<tr>
				<th bgcolor="#BDF516";>ID</th>
				<th bgcolor="#DAEE01";>Name</th>
				<th bgcolor="#E2F516";>Marks</th>
				<th bgcolor="#CCFB5D";>DELETE</th>
				<th bgcolor="#BCE954";>UPDATE</th>
			</tr>

			<c:forEach var="stud" items="${applicationScope.list }">
				<tr>
					<td><c:out value="${stud.id}"></c:out></td>
					<td><c:out value="${stud.name}"></c:out></td>
					<td><c:out value="${stud.marks}"></c:out></td>
					<td><a
						href="${pageContext.request.contextPath}/DeleteServlet?id=${stud.id}">DELETE</a></td>
					<td><a
						href="${pageContext.request.contextPath}/UpdateServlet?id=${stud.id}">UPDATE</a></td>
				</tr>
			</c:forEach>

		</table>
		
			<a href="<c:url value = "/index.html"/>">ADD NEW STUDENT DATA</a>
		
		</div>
		
		
		



	</div>
</body>
</html>
