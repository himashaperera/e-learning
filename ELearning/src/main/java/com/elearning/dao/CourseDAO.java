package com.elearning.dao;

import java.util.List;

import com.elearning.model.Course;

public interface CourseDAO {

	Long createCourse(Course course);
	Long updateCourse(Course course);
	List<Course> getAllCourses();
	Course getCourseById(Long id);
}
