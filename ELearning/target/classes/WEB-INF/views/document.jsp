<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.List, com.elearning.model.Document" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="upload" method="post" enctype="multipart/form-data" >
		<label for="name"></label>
		<input type="text" name="name" id="name" /><br/><br/>
		
		<label for="document"></label>
		<input type="file" name="document" id="document" /><br/><br/>
		
		<input id="submit" type="submit" tabindex="5" value="Add Document">
		
	</form>
	
	<%if(request.getAttribute("successStatus") != null){
		String message = (String)request.getAttribute("successStatus");
		%>
		<p><%=message %> </p>
		<%
	}
		%>
	
	
	
	<div>
		<% if(request.getAttribute("documentList") != null){
				
				List<Document> documents = (List<Document>)request.getAttribute("documentList");
				
				if(!documents.isEmpty()){
					
					for(Document doc: documents){
				
			%>
				<p>document name: <%=doc.getName()%></p>
				<p>document location: <%=doc.getLocation()%></p>
				<a href=<%="download/" + doc.getId() %> ><%=doc.getName()%></a>
			<%
			
					}
				}
			
		}
		
			%>
		
	</div>

</body>
</html>