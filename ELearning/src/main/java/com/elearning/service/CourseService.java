package com.elearning.service;

import java.util.List;

import com.elearning.model.Course;
import com.elearning.util.ApplicationException;

public interface CourseService {

	void createCourse(Course course) throws ApplicationException;
	Course getCourseById(Long id) throws ApplicationException;
	List<Course> getAllCourses();
}
