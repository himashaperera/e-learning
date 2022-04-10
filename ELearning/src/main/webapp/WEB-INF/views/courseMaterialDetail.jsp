<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List, com.elearning.model.CourseMaterial, com.elearning.model.Document" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% if(request.getAttribute("courseMaterial") != null){
			CourseMaterial material = (CourseMaterial)request.getAttribute("courseMaterial") ;
		
			List<Document> documents = material.getDocumentList();
			%>
			
				<form action="" method="post">
					<label for="id">Id</label>
					<input type="text" name="id" value=<%=material.getId() %> />
					
					<label for="name">Name</label>
					<input type="text" name="name" value=<%=material.getName() %> />
					
					<label for="name">Document</label>
					<input type="file" name="documents" multiple="multiple" />
					
					<%
					if(documents!= null && (!documents.isEmpty())){
						
					
						for(Document document: documents){
					%>
					
					<a href=<%="download/"+document.getId() %>><%=document.getName() %></a>
				</form>
			
			<% 
						}
					}
		}
	
	%>

</body>
</html>