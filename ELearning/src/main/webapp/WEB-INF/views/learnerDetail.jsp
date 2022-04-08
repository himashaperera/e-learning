<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.elearning.model.Learner" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%	Learner learner = (Learner)request.getAttribute("learner"); %>

	<form action="update" method="post" >
	
		<input type="hidden" name="id"  value=<%=learner.getId()%> />
		<label for="firstName"> firstName </label>
		<input type="text" id="firstName" name="firstName" value=<%=learner.getFirstName() %> /><br/><br/>
		<label for="lastName"> lastName</label>
		<input type="text" id="lastName" name="lastName"  value=<%=learner.getLastName()%> /><br/><br/>
		<label for="userName">userName</label>
		<input type="text" id="userName" name="userName" value=<%=learner.getUserName()%>   /><br/><br/>
		<label for="email">email</label>
		<input type="text" id="email"  name="email" value=<%=learner.getEmail()%> /><br/><br/>
		<label for="password">password</label>
		<input type="password" id="password" name="password" value=<%=learner.getPassword()%>  /><br/><br/>
		<label for="retypePassword">retypePassword</label>
		<input type="text" id="retypePassword" name="retypePassword"   /><br/><br/>
		<label for="numberOfCoursesTaken">Number of Courses taken</label>
		<input type="number" id="numberOfCoursesTaken" name="numberOfCoursesTaken" /><br/><br/>
		
		<input type="submit" value="Update" />
	</form>

</body>
</html>