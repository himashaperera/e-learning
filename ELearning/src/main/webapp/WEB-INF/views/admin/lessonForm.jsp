<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List, com.elearning.model.Course, com.elearning.model.Lesson, com.elearning.model.CourseMaterial, com.elearning.model.Document,java.util.Date, com.elearning.util.ELearningDateFormatter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add Lesson</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h3>Add New Lesson</h3>
		<%
		Course course = (Course) request.getAttribute("course");
		%>
		<form class="form needs-validation" action="add" method="post" enctype="multipart/form-data" novalidate>

			<div class="row">
				<div class="col mb-2">
					<label for="name" class="form-label">Lesson Name</label> <input
						type="text" id="name" name="name"
						class="form-control form-control-sm"
						aria-describedby="courseNameSupport" required/>
					<div class="invalid-feedback">Lesson Name cannot be empty</div>
				</div>

				<div class="col mb-2">
					<label for="courseId" class="form-label">Course Name</label> <input
						type="text" id="courseId" name="course.name"
						value=<%=course.getName() + " (" + course.getCode() + ")"%>
						class="form-control form-control-sm" aria-describedby="" readOnly />
					<div id="" class="form-text"></div>
					<input type="number" id="courseId" name="course.id"
						value=<%=course.getId()%> class="form-control form-control-sm"
						aria-describedby="" hidden />
				</div>
			</div>
			<div class="row">
				<div class="col mb-2">
					<label for="startDate" class="form-label">Start Date</label> <input
						type="date" id="startDate" name="startDate"
						class="form-control form-control-sm" aria-describedby="" required/>
					<div class="invalid-feedback">start date cannot be empty</div>
				</div>

				<div class="col mb-2">
					<label for="endDate" class="form-label">End Date</label> <input
						type="date" id="endDate" name="endDate"
						class="form-control form-control-sm" aria-describedby="" required/>
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


			<!-- Accordian -->



			<div class="accordion mb-2" id="accordionPanelsStayOpenExample">
				<div class="accordion-item">
					<h2 class="accordion-header" id="panelsStayOpen-headingOne">
						<button class="accordion-button" type="button"
							data-bs-toggle="collapse"
							data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true"
							aria-controls="panelsStayOpen-collapseOne">Add Course
							Material</button>
					</h2>
					<div id="panelsStayOpen-collapseOne"
						class="accordion-collapse collapse show"
						aria-labelledby="panelsStayOpen-headingOne">
						<div class="accordion-body" id="cm-body">



							<div class="row" id="cm-0">
								<div class="col-md-5 mb-2">
									<label for="courseMaterialList[0].name" class="form-label">Name</label> <input
										type="text" id="courseMaterialList[0].name" name="courseMaterialList[0].name"
										class="form-control form-control-sm" aria-describedby="" />
									<div id="" class="form-text"></div>
								</div>

								<div class="col-md-5 mb-2">
									<label for="courseMaterialList[0].documents" class="form-label">Files</label> <input
										type="file" id="courseMaterialList[0].documents" name="courseMaterialList[0].documents"
										class="form-control form-control-sm" aria-describedby="" multiple="multiple" />
									<div id="" class="form-text"></div>
								</div>
								<div class="col-md-1 mt-4">
									<button type="button" class="btn btn-danger" onClick="addCourseMaterialFeild()">Add</button>
								</div>
							</div>


						</div>
					</div>
				</div>

			</div>

			<div class="float-end">
				<input type="submit" class="btn btn-primary" value="Add" />
								
				<a href=<%="/ELearning/courses/"+course.getId() %>>
				<button type="button" class="btn btn-info">Go Back</button>
				
				</a>
			</div>

		</form>

	</div>
	<script>
	
		function addCourseMaterialFeild(){
			
			var count = document.getElementById("cm-body").childElementCount;
			console.log(count);
			var literal = `<div class="row" id="${"cm-"+count }"><div class="col-md-5 mb-2">
			<label for="courseMaterialList[${count}].name" class="form-label">Name</label> <input
					type="text" id="courseMaterialList[${count}].name" name="courseMaterialList[${count}].name"
					class="form-control form-control-sm" aria-describedby="" />
				<div id="" class="form-text"></div>
			</div>

			<div class="col-md-5 mb-2">
				<label for="courseMaterialList[${count}].documents" class="form-label">Files</label> <input
					type="file" id="courseMaterialList[${count}].documents" name="courseMaterialList[${count}].documents"
					class="form-control form-control-sm" aria-describedby="" multiple="multiple" />
				<div id="" class="form-text"></div>
			</div>
		</div>`;
			document.getElementById("cm-body").insertAdjacentHTML('beforeend', literal);
		}
		
	</script>

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