<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.List, com.elearning.model.Feedback" %>
    
<!DOCTYPE>
<html>
<head>

<meta charset="utf-8">
	
</head>
<body>

<center><p style="font-size: 30px ; color:#035491; padding: 30px">ADD YOUR FEEDBACK</p></center>
	
   <form action="feedbacks/add" method="post">
			
         <div style="padding-left:450px ; font-size: 18px " >
		
				<label>Id</label><br>
				<input type="text" id="id" name="id" style="width:50% ; height:8%" required="required"> <br><br>  
		
				<label>Name</label><br>
				<input type="text" id="learner " name="learner"  style="width: 50% ; height:8%" required="required"><br><br>
			
				<label>Course</label><br>
				<input type="text" id="course " name="course" style="width: 50% ; height:8%" required="required"><br><br>
				
				<label>Feedback</label><br>
			    <input type="text" id="content " name="content" style="width: 50% ; height:15%" required="required"><br><br>
				
					
	<!-- 	
	<textarea id="content " name="content " style="width: 50%" required="required" ></textarea><br><br> 	
    
    -->
						
	<div style="padding-left:100px">	
	<input type="submit" value="submit your feedback" style="height: 10% ; background-color:#91fff8 ; border: none; padding: 5px 25px;
                 text-align: center;text-decoration: none;display: inline-block;font-size: 18px;border-radius: 6px;"/><br><br><br><br>  
	</div>
    </div>
    
    </form>
			

	 <h2 style="color:#025778 ; padding-left:35px " >Learners Feedbacks</h2> 
	
		<% 
		List<Feedback> feedbacks= (List<Feedback>) request.getAttribute("feedbacks");
		
				
		if( feedbacks == null && feedbacks.isEmpty()){ %>
		<p>No feedback found</p>
		<%		

		
		
		 }else{
		
			%>
	
	<div style=" padding-left:35px ; padding-right:35px;"> 
			
			<table table id="t01">
			<tr>	
				<th>ID</th>
				<th>Name</th>
				<th>Course</th>
				<th>Feedback</th>

			</tr>

          <%  for(Feedback feedback: feedbacks){  %>

			<tr>
				<td><%=feedback.getId() %> </td>
				<td><%=feedback.getLearner() %> </td>
				<td><%=feedback.getCourse() %> </td>
				<td><%=feedback.getContent() %> </td>

			</tr>
		<% 
		} 
	%>

	</table>
</div>
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