package com.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elearning.model.Course;
import com.elearning.service.CourseService;
import com.elearning.util.ApplicationException;
import com.elearning.util.Constants;
import com.elearning.util.UrlConstants;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = UrlConstants.ALL_COURSES, method=RequestMethod.GET )
	public String getAllCourses(Model model) {
		List<Course> allCourses = this.courseService.getAllCourses();
		model.addAttribute("courses", allCourses);
		return Constants.COURSE_VIEW;
	}
	
	@RequestMapping(value = UrlConstants.GET_COURSE, method=RequestMethod.GET )
	public String getCourseById(@PathVariable("id") Long id,Model model) {
		Course courseById;
		try {
			courseById = this.courseService.getCourseById(id);
			model.addAttribute("course", courseById);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Constants.COURSE_DETAIL_VIEW;
	}
	
	@RequestMapping(value = UrlConstants.CREATE_COURSE, method=RequestMethod.POST )
	public String createCourse(@ModelAttribute  Course course, Model model) {
		
		System.out.println(course);
		try {
			this.courseService.createCourse(course);
		} catch (ApplicationException e) {
			
			e.printStackTrace();
		}
		
		
		return  UrlConstants.REDIRECT+UrlConstants.ALL_COURSES;
	}
	
	@RequestMapping(value = UrlConstants.UPDATE_COURSE, method=RequestMethod.POST )
	public String updateCourse(@ModelAttribute Course course, Model model) {
		
		
		List<Course> allCourses = this.courseService.getAllCourses();
		model.addAttribute("courses", allCourses);
		
		
		return Constants.COURSE_VIEW;
	}
	
	
	
}
