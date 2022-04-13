<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List, com.elearning.model.Course, com.elearning.model.Lesson, java.util.Date, com.elearning.util.SuccessStatus"%>
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
	<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
  <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
    <path
			d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z" />
  </symbol>
  <symbol id="exclamation-triangle-fill" fill="currentColor"
			viewBox="0 0 16 16">
    <path
			d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
  </symbol>
</svg>

	<div class="container">
		<!-- Content here -->
		<h2>Courses</h2>
		<div class="container">
			<%
			Integer status = 0;
			SuccessStatus successStatus = (SuccessStatus) request.getAttribute("successStatus");
			status = (request.getAttribute("successStatus") == null) ? 2 : ((successStatus.sStatus == null) ? 2: successStatus.sStatus);
			String successMsg = "";
			if (status != 2) {
				successMsg = successStatus.statusMessage;

			}
			%>
			<form class="form needs-validation" action="/ELearning/courses/" method="post"
				novalidate>
				<div class="row">

					<div class="col mb-2">
						<label for="name" class="form-label">Course Name</label> <input
							type="text" id="name" name="name"
							class="form-control form-control-sm"
							aria-describedby="courseNameSupport" required />
						<div class="invalid-feedback">Course Name cannot be empty</div>
					</div>

					<div class="col mb-2">
						<label for="code" class="form-label">Course Code</label> <input
							type="text" id="code" name="code"
							class="form-control form-control-sm" aria-describedby="" required />
						<div class="invalid-feedback">Course Code cannot be empty</div>
					</div>
				</div>
				<div class="row">

					<div class="col mb-2">
						<label for="startDate" class="form-label">Start Date</label> <input
							type="date" id="startDate" name="startDate"
							class="form-control form-control-sm" aria-describedby="" required />
						<div class="invalid-feedback">start date cannot be empty</div>
					</div>

					<div class="col mb-2">
						<label for="endDate" class="form-label">End Date</label> <input
							type="date" id="endDate" name="endDate"
							class="form-control form-control-sm" aria-describedby="" required />
						<div class="invalid-feedback">end date cannot be empty</div>
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

				<div class="float-end">
					<input type="submit" class="btn btn-primary" value="Add Course" />
				</div>

			</form>
			<br />
			<div>
				<%
				if (status == 1) {
				%>
				<div
					class="alert alert-success d-flex align-items-center alert-dismissible fade show"
					role="alert">
					<svg class="bi flex-shrink-0 me-2" width="24" height="24"
						role="img" aria-label="Success:">
						<use xlink:href="#check-circle-fill" /></svg>
					<div><%=successMsg%>
					</div>
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>

				<%
				} else if (status == 0) {
				%>

				<div
					class="alert alert-danger d-flex align-items-center alert-dismissible fade show"
					role="alert">
					<svg class="bi flex-shrink-0 me-2" width="24" height="24"
						role="img" aria-label="Danger:">
						<use xlink:href="#exclamation-triangle-fill" /></svg>
					<div><%=successMsg%>
					</div>
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>

				<%
				}
				%>



			</div>
		</div>
		<br />
		<table class="table table-hover">
			<thead>
				<tr>
					<th span="col">#</th>
					<th span="col">Name</th>
					<th span="col">Code</th>
					<th span="col">Duration <small>(days)</small></th>
					<th span="col">Start Date</th>
					<th span="col">End Date</th>
					<th span="col" colspan="2">Actions</th>
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
					<td><%=course.getName()%></td>
					<td><%=course.getCode()%></td>
					<td style="text-align: center;"><%=course.getDuration() %></td>
					<td><%=course.getStartDate()%></td>
					<td><%=course.getEndDate()%></td>
					<td>
						<a href=<%="/ELearning/courses/" +course.getId()+"/update" %>><button class="btn btn-danger ml-2">Update</button></a>
					</td>
					<td>
						<a href=<%="/ELearning/courses/"+ course.getId()%>><button class="btn btn-success">View</button></a>
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


	<script>
		(function() {
			'use strict'

			// Fetch all the forms we want to apply custom Bootstrap validation styles to
			var forms = document.querySelectorAll('.needs-validation')

			// Loop over them and prevent submission
			Array.prototype.slice.call(forms).forEach(function(form) {
				form.addEventListener('submit', function(event) {
					if (!form.checkValidity()) {
						event.preventDefault()
						event.stopPropagation()
					}

					form.classList.add('was-validated')
				}, false)
			})
		})()
	</script>
</body>
</html>