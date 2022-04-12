<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List, com.elearning.model.Lecturer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lecturer</title>
</head>
<body>

	<center>
		<p style="font-size: 30px; color: #035491; padding: 30px">ADD LECTURERS</p>
	</center>

	<form action="lecturers/add" method="post">

		<div style="padding-left: 320px; font-size: 18px">

			<label>FirstName</label><br> <input type="text" id="firstName"
				name="firstName" style="width: 50%; height: 8%" required="required">
			<br>
			<br> <label>LastName</label><br> <input type="text"
				id="lastName " name="lastName" style="width: 50%; height: 8%"
				required="required"><br>
			<br> <label>User Name</label><br> <input type="text"
				id="userName " name="userName" style="width: 50%; height: 8%"
				required="required"><br>
			<br> <label>Email</label><br> <input type="text"
				id="email " name="email" style="width: 50%; height: 8%"
				required="required"><br>
			<br> <label>Password</label><br> <input type="text"
				id="password " name="password" style="width: 50%; height: 15%"
				required="required"><br>
			<br> <label>Retype Password</label><br> <input type="text"
				id="retypePassword " name="retypePassword"
				style="width: 50%; height: 8%" required="required"><br>
			<br> <label>Joined Date</label><br> <input type="date"
				id="joinedDate " name="joinedDate" style="width: 50%; height: 15%"
				required="required"><br>
			<br>


			<!-- 	
	<textarea id="content " name="content " style="width: 50%" required="required" ></textarea><br><br> 	
    
    -->

			<div style="padding-left: 100px">
				<input type="submit" value="Add Lecturer"
					style="height: 10%; background-color: #91fff8; border: none; padding: 5px 25px; text-align: center; text-decoration: none; display: inline-block; font-size: 18px; border-radius: 6px;" /><br>
				<br>
				<br>
				<br>
			</div>
		</div>

	</form>


	<h2 style="color: #025778">Lecturers</h2>


	<%
	List<Lecturer> lecturers = (List<Lecturer>) request.getAttribute("lecturers");

	if (lecturers == null && lecturers.isEmpty()) {
	%>
	<p>No users found</p>
	<%
	} else
	{
		%>
		<table table id="t01">
			<tr>	
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>

			</tr>
			
			<% for (Lecturer lecturer : lecturers) {  %>

			<tr>
				<td><%=lecturer.getId() %> </td>
				<td><%=lecturer.getFirstName() %> </td>
				<td><%=lecturer.getLastName() %> </td>
				<td><%=lecturer.getEmail() %> </td>

			</tr>
		<% 
		} 
	%>

	</table>

        <%
		}
	%>
	
	
	<style>  

.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
 }
	
 table#t01 {  
    width: 100%;  
    background-color: #05b0ff;  
 }   
  
 table#t01 tr:nth-child(even) {  
    background-color: #eee;  
 }  
  table#t01 tr:nth-child(odd) {  
    background-color: #fff;  
 }  
  table#t01 th {  
    color: white;  
    background-color:#00c4f0;  
 }  
  table, th, td {  
     border: 1px solid black;  
  }  
  table, th, td {  
    border: 1px solid black;  
    border-collapse: collapse;  
 }  
  table, th, td {  
    border: 1px solid black;  
    border-collapse: collapse;  
 }  
  th, td {  
    padding: 15px;  
 } 
 
</style>

</body>
</html> 