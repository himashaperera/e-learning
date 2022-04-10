<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List, com.elearning.model.CourseMaterial, com.elearning.model.Document" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to course Material</h1>
	
	<form action="course-material" method="post" enctype="multipart/form-data">
		<label for="name">Name of File</label>
		<input type="text" name="name" id="name" />
		<label for="documents">Files</label>
		<input type="file" name="documents" id="documents"  multiple="multiple"/>
		<input type="submit" name="submitBtn" id="submitBtn"  value="Add"/>
	</form>
	<%	
	
		if(request.getAttribute("courseMaterial") != null){
			List<CourseMaterial> material  = (List<CourseMaterial>)request.getAttribute("courseMaterial");
			if(material.isEmpty()){
				%>
				<p>List is empty</p>
				<% 
			}else{
				%>
				<table>
					<tr>	
						<th>#ID</th>
						<th>Course Material Name</th>
						<th>Documents</th>
						<th>created At</th>
						<th>updated at</th>
						
						<th>Action</th>
						
					</tr>
					<% for(CourseMaterial m: material){ %>
							<tr>
								<td><%=m.getId() %> </td>
								<td><%=m.getName() %> </td>
								<td><%
										List<Document> documents = m.getDocumentList();
										if(!documents.isEmpty()){
											for(Document document: documents){
												%> 
												<a href=<%="download/" +document.getId() %>><%=document.getName() %></a>
												<%
											}
										}
									%> 
								
								</td>
								<td><%=m.getCreatedAt() %> </td>
								<td><%=m.getUpdatedAt() %> </td>
								<td>
									<a href=<%="course-material/"+m.getId() %>>View</a>
								</td>
								
							</tr>
					<% 
					} 
					
					
					%>
					
				</table>
				
				
				<%
				
				
			}
			
		}
	%>

</body>
</html>