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

import com.elearning.model.Learner;
import com.elearning.service.LearnerService;
import com.elearning.util.ApplicationException;
import com.elearning.util.Constants;
import com.elearning.util.SuccessStatus;
import com.elearning.util.UrlConstants;

@Controller
public class LearnerController {

	@Autowired
	private LearnerService learnerService;

	@RequestMapping(path = UrlConstants.SIGN_IN_LEARNERS_VIEW, method = RequestMethod.GET)
	public String getSignInLearnerView(@ModelAttribute("successStatus") SuccessStatus status, Model model) {
		return Constants.LEARNER_VIEW;
	}
	
	@RequestMapping(path = UrlConstants.ALL_LEARNERS, method = RequestMethod.GET)
	public String getAllLearner(Model model) {
		List<Learner> allLearners = this.learnerService.getAllLearners();
		model.addAttribute("learners", allLearners);
		return Constants.LEARNER_VIEW;
	}

	@RequestMapping(path = UrlConstants.GET_LEARNER, method = RequestMethod.GET)
	public String getLearnerById(@PathVariable("id") Long id, Model model) {
		try {
			Learner learnerById = this.learnerService.getLearnerById(id);
			model.addAttribute("learner", learnerById);
		} catch (ApplicationException e) {
			model.addAttribute(Constants.SUCCESS_STATUS, e.getMessage());
		}
		return Constants.LEARNER_DETAIL;
	}

	@RequestMapping(path = UrlConstants.CREATE_LEARNER, method = RequestMethod.POST)
	public String createLearner(@ModelAttribute("learn") Learner learner, Model model, RedirectAttributes redirectAttributes) {
		SuccessStatus successStatus = new SuccessStatus();
		successStatus.sStatus = 1;
		try {
			this.learnerService.createLearner(learner);
			successStatus.statusMessage = Constants.CREATE_SUCCESS_MESSAGE;
		} catch (ApplicationException e) {
			successStatus.sStatus = 0;
			successStatus.statusMessage = e.getMessage();
		}
		redirectAttributes.addFlashAttribute(Constants.SUCCESS_STATUS, successStatus);
		return  UrlConstants.REDIRECT+UrlConstants.SIGN_IN_LEARNERS_VIEW;
	}

	@RequestMapping(path = UrlConstants.SIGN_IN_LEARNERS, method = RequestMethod.POST)
	public String signInLearner(@ModelAttribute("learn") Learner learner, Model model, RedirectAttributes redirectAttributes) {
		SuccessStatus successStatus = new SuccessStatus();
		successStatus.sStatus = 1;
		try {
			Learner learnerByEmail = this.learnerService.getLearnerByEmail(learner);
			model.addAttribute("learner", learnerByEmail);
			return Constants.LEARNER_WELCOME;
		} catch (ApplicationException e) {
			successStatus.sStatus = 0;
			successStatus.statusMessage = e.getMessage();
			redirectAttributes.addFlashAttribute(Constants.SUCCESS_STATUS, successStatus);
			return  UrlConstants.REDIRECT+UrlConstants.SIGN_IN_LEARNERS_VIEW;
		}
	}
	
	@RequestMapping(path = UrlConstants.UPDATE_LEARNER, method = RequestMethod.POST)
	public String updateLearner(@ModelAttribute("learn") Learner learner, Model model) {

		try {
			this.learnerService.updateLearner(learner);
			model.addAttribute(Constants.SUCCESS_STATUS, Constants.UPDATE_SUCCESS_MESSAGE);
			
		} catch (ApplicationException e) {
			model.addAttribute(Constants.SUCCESS_STATUS, e.getMessage());
			System.out.println(e.getMessage());
		}

		return UrlConstants.REDIRECT + UrlConstants.ALL_LEARNERS;
	}

}
