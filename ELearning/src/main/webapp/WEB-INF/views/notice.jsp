<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.List, com.elearning.model.Notice" %>
    
<!DOCTYPE>
<html>
<head>

<meta charset="utf-8">

<style>  

h3{
	font-size: 20px ; 
	text-align:center; 
	color:#0469b5;
	padding: 35px;
}

.btn{
	padding-left:100px
}

.t-table{
	padding-left:35px; 
	padding-right:35px;
}

.formh{
	font-size: 15px; 
	padding-left:500px;

}

.btn-ds{
	background-color:#5568e4;
	display: inline-block;
	text-align: center;
	height: 10%; 
	border-radius: 6px; 
	border: none;
	padding: 5px 25px;
    text-decoration: none;
    font-size: 15px;
}

.button {
  font-size: 18px;
  background-color: #4c6baf;
  color: white;
  text-align: center;
  border: #4f6fb5;
  padding: 15px 32px;
  display: inline-block;
  text-decoration: none;
 }
 	
 table .thead {  
    width: 100%;  
    background-color: #05b0ff;  
   
 }   
  
 table .thead tr:nth-child(even) {  
    background-color: #eee;  
 }  
  table .thead tr:nth-child(odd) {  
    background-color: #fff;  
 }  
  table .thead th {  
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

</head>
<body>

	<h3>ADD NOTICE</h3>
	
   	<form action="notices/add" method="post">
			
         <div class="formh" >
         
				<label>NOTICE ID</label>
				<br>
				<input type="text" id="id" name="id" style="width:50% ; height:8%" required="required"> <br><br>  
		
				<label>TITLE</label>
				<br>
				<input type="text" id="title " name="title"  style="width: 50% ; height:8%" required="required"><br><br>
			
				<label>DISCRIPTION</label>
				<br>
				<input type="text" id="description " name="description" style="width: 50% ; height:8%" required="required"><br><br>
				
				<label>NAME</label>
				<br>
			    <input type="text" id="postedBy " name="postedBy" style="width: 50% ; height:15%" required="required"><br><br>
				
				<label>POSITION</label>
				<br>
			    <input type="text" id="position " name="position" style="width: 50% ; height:15%" required="required"><br><br>
				
				<label>POST DATE</label>
				<br>
			    <input type="text" id="postDate" name="postDate" style="width: 50% ; height:15%" required="required"><br><br>
											
	<div class="btn">		
		<input class = "btn-ds"type="submit" value="Submit it"/>               
	</div>
    </div>
    
    </form>
			
	 <h3>NOTICE LIST</h3> 
	
		<% 
		List<Notice> notices = (List<Notice>) request.getAttribute("notices");
		
				
		if( notices == null && notices.isEmpty()){ %>
		<p>No notices found</p>
		<%			
		
		 }else{
		
			%>
	
	<div class="t-table"> 
			
			<table class="thead">
			<tr>	
				<th>NOTICE ID</th>
				<th>TITLE</th>
				<th>DISCRIPTION</th>
				<th>NAME</th>
				<th>POSITION</th>
				<th>POST DATE</th>
			</tr>

          <%  for(Notice notice: notices){  %>

			<tr>
				<td><%=notice.getId() %> </td>
				<td><%=notice.getTitle() %> </td>
				<td><%=notice.getDescription() %> </td>
				<td><%=notice.getPostedBy() %> </td>
				<td><%=notice.getPosition() %> </td>
				<td><%=notice.getPostDate() %> </td>

			</tr>
		<% 
		} 
	%>

	</table>
</div>
        <%
		}
	%>

</body>
</html> 