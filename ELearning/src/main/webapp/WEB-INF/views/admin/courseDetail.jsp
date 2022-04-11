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
	<div class="container">
		<%
		if (request.getAttribute("course") != null) {

			Course course = (Course) request.getAttribute("course");
			String startDate = course.getStartDate();
			String endDate = course.getEndDate();
			Date start = ELearningDateFormatter.formatStringDateHTML(startDate);
			Date end = ELearningDateFormatter.formatStringDateHTML(endDate);
			
			
			
		%>

		<h1><%=course.getName()%>
		</h1>
		<h4 class="text-secondary"><%=course.getCode()%>   <small>( <%=ELearningDateFormatter.formatDateHTML(start)%>
			- <%=ELearningDateFormatter.formatDateHTML(end)%> )</small>
		</h4>
		<p><%=course.getDescription()%>
		</p>

		<a href=<%=course.getId()+"/lessons/form" %> ><button class="btn btn-success">Add Lesson</button></a>
		<br/>
		<hr/>

		<%
		if (course.getLessonList() != null) {
			for (Lesson lesson : course.getLessonList()) {
				
				Date beginning = ELearningDateFormatter.formatStringDateHTML(lesson.getStartDate());
				Date endding = ELearningDateFormatter.formatStringDateHTML(lesson.getEndDate());

				
				
		%>
		<div class="container">
			<h4><%=lesson.getName()%></h4>
			<h6><small class="text-secondary"><%=ELearningDateFormatter.formatDateHTML(beginning) %>
					- <%=ELearningDateFormatter.formatDateHTML(endding) %></small></h6>
			
			<br />
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
					
					<a href=<%="/ELearning/download/"+document.getId() %> class="link-primary"><%=document.getName() %></a>
					
				<%}
				
						}
					}
				}
				
				%>
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