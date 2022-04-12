package com.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.elearning.model.Course;
import com.elearning.service.CourseService;
import com.elearning.util.ApplicationException;
import com.elearning.util.Constants;
import com.elearning.util.SuccessStatus;
import com.elearning.util.UrlConstants;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = UrlConstants.ALL_COURSES, method=RequestMethod.GET )
	public String getAllCourses(@ModelAttribute("successStatus") SuccessStatus status,Model model) {
		List<Course> allCourses = this.courseService.getAllCourses();
		model.addAttribute("courses", allCourses);
		return Constants.COURSE_VIEW;
	}
	
	@RequestMapping(value = UrlConstants.GET_COURSE, method=RequestMethod.GET )
	public String getCourseById(@PathVariable("id") Long id,Model model) {
		Course courseById;
		int status = 1;
		try {
			courseById = this.courseService.getCourseById(id);
			model.addAttribute("course", courseById);
		} catch (ApplicationException e) {
			status = 0;
			model.addAttribute(Constants.SUCCESS_STATUS, e.getMessage());
		}
		model.addAttribute(Constants.STATUS, status);
		return Constants.COURSE_DETAIL_VIEW;
	}
	
	@RequestMapping(value = UrlConstants.GET_UPDATE_COURSE_FORM, method=RequestMethod.GET )
	public String showUpdateFormById(@PathVariable("id") Long id,Model model) {
		Course courseById;
		int status = 1;
		try {
			courseById = this.courseService.getCourseById(id);
			model.addAttribute("course", courseById);
		} catch (ApplicationException e) {
			status = 0;
			model.addAttribute(Constants.SUCCESS_STATUS, e.getMessage());
		}
		model.addAttribute(Constants.STATUS, status);
		return Constants.COURSE_UPDATE_FORM_VIEW;
	}
	
	@RequestMapping(value = UrlConstants.CREATE_COURSE, method=RequestMethod.POST )
	public String createCourse(@ModelAttribute  Course course, Model model, RedirectAttributes redirectAttributes) {
		SuccessStatus successStatus = new SuccessStatus();
		successStatus.sStatus = 1;
		try {
			this.courseService.createCourse(course);
			successStatus.statusMessage = Constants.CREATE_SUCCESS_MESSAGE;
		} catch (ApplicationException e) {
			successStatus.sStatus = 0;
			successStatus.statusMessage = e.getMessage();
		}
		redirectAttributes.addFlashAttribute(Constants.SUCCESS_STATUS, successStatus);
		return  UrlConstants.REDIRECT+UrlConstants.ALL_COURSES;
	}
	
	@RequestMapping(value = UrlConstants.UPDATE_COURSE, method=RequestMethod.POST )
	public String updateCourse(@ModelAttribute  Course course, Model model) {
		SuccessStatus successStatus = new SuccessStatus();
		successStatus.sStatus = 1;
		try {
			this.courseService.updateCourse(course);
			successStatus.statusMessage = Constants.UPDATE_SUCCESS_MESSAGE;
		} catch (ApplicationException e) {
			successStatus.sStatus = 0;
			successStatus.statusMessage = e.getMessage();
		}
		model.addAttribute(Constants.SUCCESS_STATUS, successStatus);
		return  Constants.COURSE_UPDATE_FORM_VIEW;
	}
	
	
}
