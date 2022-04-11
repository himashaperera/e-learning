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
import com.elearning.model.CourseMaterial;
import com.elearning.model.Lesson;
import com.elearning.service.CourseService;
import com.elearning.service.LessonService;
import com.elearning.util.ApplicationException;
import com.elearning.util.Constants;
import com.elearning.util.UrlConstants;

@Controller
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(path=UrlConstants.CREATE_LESSON, method=RequestMethod.POST)
	public String createLesson(@ModelAttribute Lesson lesson, Model model) {
		
		System.out.println(lesson);
		List<CourseMaterial> courseMaterialList = lesson.getCourseMaterialList();
		System.out.println(courseMaterialList);
		for (CourseMaterial courseMaterial : courseMaterialList) {
			System.out.println("courseMaterial: " + courseMaterial);
		}
		try {
			this.lessonService.createLesson(lesson);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return UrlConstants.REDIRECT + UrlConstants.ALL_COURSES + "/" + lesson.getCourse().getId();
	}

	@RequestMapping(path=UrlConstants.UPDATE_LESSON, method=RequestMethod.POST)
	public String updateLesson(@ModelAttribute Lesson lesson, Model model) {
		try {
			this.lessonService.updateLesson(lesson);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return UrlConstants.REDIRECT + UrlConstants.ALL_COURSES + "/" + lesson.getCourse().getId();
	}
	
	@RequestMapping(path=UrlConstants.ALL_LESSON, method=RequestMethod.GET)
	public String getAllLesson( Model model) {
		List<Lesson> allLessons = this.lessonService.getAllLessons();
		model.addAttribute("lessons", allLessons);
		return Constants.LESSON_VIEW;
	}
	
	@RequestMapping(path=UrlConstants.CREATE_LESSON_FORM, method=RequestMethod.GET)
	public String getLessonFormView(@PathVariable Long id, Model model) {
		try {
			Course courseById = this.courseService.getCourseById(id);
			model.addAttribute("course", courseById);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return Constants.LESSON_ADD_VIEW;
	}
	
	@RequestMapping(path=UrlConstants.GET_LESSON, method=RequestMethod.GET)
	public String getLessonById(@PathVariable Long id,Model model) {
		
		try {
			Lesson lessonById = this.lessonService.getLessonById(id);
			model.addAttribute("lesson", lessonById);
			
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return Constants.LESSON_DETAIL_VIEW;
	}
	
}
