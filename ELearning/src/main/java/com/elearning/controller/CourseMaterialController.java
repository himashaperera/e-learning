package com.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elearning.model.CourseMaterial;
import com.elearning.service.CourseMaterialService;
import com.elearning.util.ApplicationException;
import com.elearning.util.Constants;
import com.elearning.util.UrlConstants;

@Controller
public class CourseMaterialController {
	
	@Autowired
	private CourseMaterialService courseMaterialService;

	@RequestMapping(path = UrlConstants.GET_ALL_COURSE_MATERIAL, method=RequestMethod.GET)
	public String getCourseMaterial(Model model) {
		List<CourseMaterial> allCourseMaterial = this.courseMaterialService.getAllCourseMaterial();
		model.addAttribute("courseMaterial", allCourseMaterial);
		return Constants.COURSE_MATERIAL_VIEW;
		
	}
	@RequestMapping(path = UrlConstants.GET_COURSE_MATERIAL, method=RequestMethod.GET)
	public String getCourseMaterialById(@PathVariable("id") Long id, Model model) {
		try {
			CourseMaterial courseMaterial = this.courseMaterialService.getCourseMaterialById(id);
			model.addAttribute("courseMaterial", courseMaterial);
		} catch (ApplicationException e) {
			model.addAttribute(Constants.SUCCESS_STATUS, e.getMessage());
		}
		return Constants.COURSE_MATERIAL_DETAIL_VIEW;
		
	}
	@RequestMapping(path = UrlConstants.CREATE_COURSE_MATERIAL, method=RequestMethod.POST)
	public String createCourseMaterial(@ModelAttribute CourseMaterial courseMaterial, Model model) {
		System.out.println(courseMaterial);
		try {
			this.courseMaterialService.createCourseMaterial(courseMaterial);
			model.addAttribute(Constants.SUCCESS_STATUS, Constants.CREATE_SUCCESS_MESSAGE);
		} catch (ApplicationException e) {
			model.addAttribute(Constants.SUCCESS_STATUS, e.getMessage());
		}
		return UrlConstants.REDIRECT + UrlConstants.GET_ALL_COURSE_MATERIAL;
		
	}
	@RequestMapping(path = UrlConstants.UPDATE_COURSE_MATERIAL, method=RequestMethod.PUT)
	public String updateMaterial(@ModelAttribute CourseMaterial courseMaterial, Model model) {
		
		try {
			this.courseMaterialService.updateCourseMaterial(courseMaterial);
			model.addAttribute(Constants.SUCCESS_STATUS, Constants.UPDATE_SUCCESS_MESSAGE);
		} catch (ApplicationException e) {
			model.addAttribute(Constants.SUCCESS_STATUS, e.getMessage());
		}
		return Constants.COURSE_MATERIAL_DETAIL_VIEW;
		
	}
	
	
	
	
}
