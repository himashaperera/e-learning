<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List, com.elearning.model.Course, com.elearning.model.Lesson, com.elearning.model.CourseMaterial, com.elearning.model.Document,java.util.Date, com.elearning.util.ELearningDateFormatter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course Detail</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

</head>
<body>
<svg id="file-ic" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-files" viewBox="0 0 16 16">
  <path d="M13 0H6a2 2 0 0 0-2 2 2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h7a2 2 0 0 0 2-2 2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm0 13V4a2 2 0 0 0-2-2H5a1 1 0 0 1 1-1h7a1 1 0 0 1 1 1v10a1 1 0 0 1-1 1zM3 4a1 1 0 0 1 1-1h7a1 1 0 0 1 1 1v10a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V4z"/>
</svg>
	<div class="container">
		<%
		if (request.getAttribute("course") != null) {

			Course course = (Course) request.getAttribute("course");
			String startDate = course.getStartDate();
			String endDate = course.getEndDate();
			Date start = ELearningDateFormatter.formatStringDateHTML(startDate);
			Date end = ELearningDateFormatter.formatStringDateHTML(endDate);
			
			
			
		%>
<div class="container">
		<h1><%=course.getName()%>
		</h1>
		<h4 class="text-secondary"><%=course.getCode()%>   <small>( <%=ELearningDateFormatter.formatDateHTML(start)%>
			- <%=ELearningDateFormatter.formatDateHTML(end)%> )</small>
		</h4>
		<p><%=course.getDescription()%>
		</p>

		<a href=<%=course.getId()+"/lessons/form" %> ><button class="btn btn-success">Add Lesson</button></a>
		</div>
		<br/>
		<hr/>

		<%
		if (course.getLessonList() != null) {
			for (Lesson lesson : course.getLessonList()) {
				
				Date beginning = ELearningDateFormatter.formatStringDateHTML(lesson.getStartDate());
				Date endding = ELearningDateFormatter.formatStringDateHTML(lesson.getEndDate());

				
				
		%>
		<div class="container">
		<div class="shadow p-3 mb-2 bg-white rounded">
			<h4><%=lesson.getName()%></h4>
			<h6><small class="text-secondary"><%=ELearningDateFormatter.formatDateHTML(beginning) %>
					- <%=ELearningDateFormatter.formatDateHTML(endding) %></small></h6>
					</div>
			
			<br />
			
			<div class="container">
			
			
			<p><%=(lesson.getDescription() == null) ? "" : lesson.getDescription()%>
			</p>
			<h6 class="text-secondary">Course Material</h6>
			
				<%
				List<CourseMaterial> material = (List<CourseMaterial>)lesson.getCourseMaterialList();
				if(material!=null){
					if(!material.isEmpty()){
						for(CourseMaterial cm: material){
							List<Document> documents = cm.getDocumentList();
							
				
				%>
					<p><%=cm.getName()%></p>
					
					<%  
							for(Document document: documents){
								
							
					%>
					
					<p><svg class="bi bi-files flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Warning:"><use xlink:href="#file-ic"/></svg>
					
					<a href=<%="/ELearning/download/"+document.getId() %> class="link-primary"><%=document.getName() %></a>
					</p>
					
				<%}
				
						}
					}
				}
				
				%>
				</div>
			<hr/>

		</div>
		<%
		}
		}

		}
		%>
	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>