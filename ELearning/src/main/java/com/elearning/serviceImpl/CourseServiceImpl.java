package com.elearning.serviceImpl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dao.CourseDAO;
import com.elearning.model.Admin;
import com.elearning.model.Course;
import com.elearning.model.Lesson;
import com.elearning.service.CourseService;
import com.elearning.service.LessonService;
import com.elearning.util.ApplicationException;
import com.elearning.util.Constants;
import com.elearning.util.ELearningDateFormatter;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private LessonService LessonService;
	
	@Override
	public void createCourse(Course course) throws ApplicationException {
		
		long differenceDays = 0;
		try {
			Date start = ELearningDateFormatter.formatStringDateHTML(course.getStartDate());
			Date end = ELearningDateFormatter.formatStringDateHTML(course.getEndDate());
			differenceDays = getDifferenceDays(start, end);
			
		} catch (ParseException e) {
			throw new ApplicationException(e.getMessage());
		}
		course.setDuration(differenceDays);
		Admin admin = new Admin();
		admin.setId(1l);
		
		course.setCreatedBy(admin);
		Long createCourse = this.courseDAO.createCourse(course);
		if(createCourse == null)
			throw new ApplicationException(Constants.CREATE_ERROR_MESSAGE);
	}


	@Override
	public Course getCourseById(Long id) throws ApplicationException {
		Course courseById = this.courseDAO.getCourseById(id);
		if(courseById == null)
			throw new ApplicationException(Constants.NOT_FOUND_MESSAGE);
		List<Lesson> lessonByCourseId = LessonService.getLessonByCourseId(courseById.getId());
		courseById.setLessonList(lessonByCourseId);
		return courseById;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> allCourses = this.courseDAO.getAllCourses();
		return allCourses;
	}


	@Override
	public void updateCourse(Course course) throws ApplicationException {
		
		long differenceDays = 0;
		try {
			Date start = ELearningDateFormatter.formatStringDateHTML(course.getStartDate());
			Date end = ELearningDateFormatter.formatStringDateHTML(course.getEndDate());
			differenceDays = getDifferenceDays(start, end);
			
		} catch (ParseException e) {
			throw new ApplicationException(e.getMessage());
		}
	    
	    
		course.setDuration(differenceDays);
		Integer updateCourse = this.courseDAO.updateCourse(course);
		if(updateCourse < 0)
			throw new ApplicationException(Constants.UPDATE_ERROR_MESSAGE);
		
	}
	
	
	public long getDifferenceDays(Date d1, Date d2) {
	    long diff = d2.getTime() - d1.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

}
