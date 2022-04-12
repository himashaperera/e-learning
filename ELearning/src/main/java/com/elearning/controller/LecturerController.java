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

import com.elearning.model.Lecturer;
import com.elearning.service.LecturerService;
import com.elearning.util.ApplicationException;
import com.elearning.util.Constants;
import com.elearning.util.SuccessStatus;
import com.elearning.util.UrlConstants;

@Controller
public class LecturerController {


	@Autowired
	private LecturerService lecturerService;
	
	@RequestMapping(value = UrlConstants.ALL_LECTURERS, method=RequestMethod.GET )
	public String getAllLecturers(@ModelAttribute("successStatus") SuccessStatus status,Model model) {
		List<Lecturer> allLecturers = this.lecturerService.getAllLecturers();
		model.addAttribute("lecturers", allLecturers);
		return Constants.LECTURER_VIEW;
	}
	
	@RequestMapping(value = UrlConstants.GET_LECTURER, method=RequestMethod.GET )
	public String getLecturerById(@PathVariable("id") Long id,Model model) {
		Lecturer lecturerById;
		int status = 1;
		try {
			lecturerById = this.lecturerService.getLecturerById(id);
			model.addAttribute("lecturer", lecturerById);
		} catch (ApplicationException e) {
			status = 0;
			model.addAttribute(Constants.SUCCESS_STATUS, e.getMessage());
		}
		model.addAttribute(Constants.STATUS, status);
		return Constants.LECTURER_DETAIL;
	}
	
	@RequestMapping(value = UrlConstants.CREATE_LECTURER, method=RequestMethod.POST )
	public String createLecturer(@ModelAttribute  Lecturer lecturer, Model model, RedirectAttributes redirectAttributes) {
		SuccessStatus successStatus = new SuccessStatus();
		successStatus.sStatus = 1;
		try {
			this.lecturerService.createLecturer(lecturer);
			successStatus.statusMessage = Constants.CREATE_SUCCESS_MESSAGE;
		} catch (ApplicationException e) {
			successStatus.sStatus = 0;
			successStatus.statusMessage = e.getMessage();
		}
		redirectAttributes.addFlashAttribute(Constants.SUCCESS_STATUS, successStatus);
		return  UrlConstants.REDIRECT+UrlConstants.ALL_LECTURERS;
	}
	
	
}
