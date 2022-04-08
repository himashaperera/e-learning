package com.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elearning.util.Constants;
import com.elearning.util.UrlConstants;

@Controller
public class CourseController {

	@RequestMapping(value = UrlConstants.ALL_COURSES, method=RequestMethod.GET )
	public String getAllCourses() {
		return Constants.COURSE_VIEW;
	}
}
