<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body style="background-color: rgb(126, 209, 209);">

<h1 style="text-align: center;"><b>Student Data Management</b></h1>
	<h3 style="text-align: center;"><b>Update Student Data</b></h3>


	<form action="UpdateData" method="get">

		Id: <input type="text" name="id" value="${requestScope.stud.id}" readonly="readonly"> <br> 
		Name : <input type="text" name="uname" value="${ requestScope.stud.name }"> <br>
		Marks : <input type="text" name="marks" value="${ requestScope.stud.marks}"> <br> 
		<input type="submit" value="UPDATE">
	</form>



</body>
</html>
