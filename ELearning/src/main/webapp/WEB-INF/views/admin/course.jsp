<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List, com.elearning.model.Course, com.elearning.model.Lesson, java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Courses</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<!-- Content here -->
		<div class="container">
			<form class="form" action="courses" method="post">

				<div class="row">

					<div class="col mb-2">
						<label for="name" class="form-label">Course Name</label> <input
							type="text" id="name" name="name" class="form-control form-control-sm"
							aria-describedby="courseNameSupport" />
						<div id="courseNameSupport" class="form-text text-info">cannot
							be empty</div>
					</div>

					<div class="col mb-2">
						<label for="code" class="form-label">Course Code</label> <input
							type="text" id="code" name="code" class="form-control form-control-sm"
							aria-describedby="" />
						<div id="" class="form-text"></div>
					</div>
				</div>
				<div class="row">

					<div class="col mb-2">
						<label for="startDate" class="form-label">Start Date</label> <input
							type="date" id="startDate" name="startDate" class="form-control form-control-sm"
							aria-describedby="" />
						<div id="" class="form-text"></div>
					</div>

					<div class="col mb-2">
						<label for="endDate" class="form-label">End Date</label> <input
							type="date" id="endDate" name="endDate" class="form-control form-control-sm"
							aria-describedby="" />
						<div id="" class="form-text"></div>
					</div>
				</div>

				<div class="mb-2">
					<label for="description" class="form-label">Description</label>
					<textarea type="text" id="description" name="description"
						class="form-control form-control-sm" rows="3"
						aria-describedby="descriptionSupport">
					</textarea>
					<div id="descriptionSupport" class="form-text">optional</div>
				</div>
				
				<div>
					<input type="submit" class="btn btn-primary" value="Add" />
				</div>

			</form>
		</div>
		<br />
		<table class="table table-hover">
			<thead>
				<tr>
					<th span="col">#</th>
					<th span="col">Name</th>
					<th span="col">Code</th>
					<th span="col">Start Date</th>
					<th span="col">End Date</th>
					<th span="col">Actions</th>
				</tr>
			</thead>
			<tbody>

				<%
				if (request.getAttribute("courses") != null) {
					List<Course> courses = (List<Course>) request.getAttribute("courses");
					String message = "";
					if (courses.isEmpty()) {
						message = "No records to display.";
					} else {
						message = courses.size() + " records.";

						for (Course course : courses) {
				%>

				<tr>
					<th span="row"><%=course.getId()%></th>
					<td><%=course.getName() %></td>
					<td><%=course.getCode() %></td>
					<td><%=course.getStartDate() %></td>
					<td><%=course.getEndDate() %></td>
					<td>
						<a href=<%="courses/" + course.getId() %> >
							<button class="btn btn-success">View</button>
						</a>
					</td>
				</tr>

				<%
				}
				}
				%>
			
			<caption><%=message%>
			</caption>
			<%
			}
			%>

			</tbody>
		</table>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>