<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.List, com.elearning.model.Learner" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="learners/add" method="post">
		<label for="firstName"> firstName </label>
		<input type="text" id="firstName" name="firstName" /><br/><br/>
		<label for="lastName"> lastName</label>
		<input type="text" id="lastName" name="lastName" /><br/><br/>
		<label for="userName">userName</label>
		<input type="text" id="userName" name="userName"  /><br/><br/>
		<label for="email">email</label>
		<input type="text" id="email"  name="email" /><br/><br/>
		<label for="password">password</label>
		<input type="text" id="password" name="password"  /><br/><br/>
		<label for="retypePassword">retypePassword</label>
		<input type="text" id="retypePassword" name="retypePassword" /><br/><br/>
		<label for="numberOfCoursesTaken">Number of Courses taken</label>
		<input type="number" id="numberOfCoursesTaken" name="numberOfCoursesTaken" /><br/><br/>
		
		<input type="submit" value="Register" />
	</form>
	<div>
		<% 
		List<Learner> learners= (List<Learner>) request.getAttribute("learners");
		
		if( learners == null && learners.isEmpty()){ %>
		<p>No users found</p>
		<%		
		}else{
		
		
		for(Learner learner: learners){
		
		%>
			<p><%=learner.getId() %><%=learner.getFirstName() %> <%=learner.getLastName() %> : <%=learner.getEmail() %></p>
		
		<%} 
		
		}%>
	
	</div>
</body>
</html>