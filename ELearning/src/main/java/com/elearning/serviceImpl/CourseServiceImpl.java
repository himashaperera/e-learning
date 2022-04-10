package com.elearning.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dao.CourseDAO;
import com.elearning.model.Admin;
import com.elearning.model.Course;
import com.elearning.service.CourseService;
import com.elearning.util.ApplicationException;
import com.elearning.util.Constants;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDAO courseDAO;
	
	@Override
	public void createCourse(Course course) throws ApplicationException {
		course.setDuration(course.getEndDate());
		Admin admin = new Admin();
		admin.setId(1l);
		
		course.setCreatedBy(admin);
		Long createCourse = this.courseDAO.createCourse(course);
		if(createCourse == null)
			throw new ApplicationException(Constants.CREATE_ERROR_MESSAGE);
	}

	@Override
	public void updateCourse(Course course) throws ApplicationException {
		
	}

	@Override
	public Course getCourseById(Long id) throws ApplicationException {
		Course courseById = this.courseDAO.getCourseById(id);
		if(courseById == null)
			throw new ApplicationException(Constants.NOT_FOUND_MESSAGE);
		return courseById;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> allCourses = this.courseDAO.getAllCourses();
		return allCourses;
	}

}
