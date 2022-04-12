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

import com.elearning.model.Feedback;
import com.elearning.service.FeedbackService;
import com.elearning.util.ApplicationException;
import com.elearning.util.Constants;
import com.elearning.util.SuccessStatus;
import com.elearning.util.UrlConstants;


@Controller
public class FeedbackController {

		
		@Autowired
		private FeedbackService feedbackService;

		@RequestMapping(value = UrlConstants.ALL_FEEDBACKS, method = RequestMethod.GET)
		//public String getAllFeedback(Model model) {
			public String getAllFeedbacks(@ModelAttribute("successStatus") SuccessStatus status,Model model) {
			
			List<Feedback> allFeedbacks= this.feedbackService.getAllFeedbacks();
			model.addAttribute("feedbacks", allFeedbacks);
			return Constants.FEEDBACK_VIEW;
		}

		@RequestMapping(value = UrlConstants.GET_FEEDBACK, method = RequestMethod.GET)
		public String getFeedbackById(@PathVariable("id") Long id, Model model) {
			Feedback feedbackById;
			int status = 1;
			try {
				feedbackById = this.feedbackService.getFeedbackById(id);
				model.addAttribute("feedback", feedbackById);
			} 
			catch (ApplicationException e) {
				status = 0;
				model.addAttribute(Constants.SUCCESS_STATUS, e.getMessage());
			}
			
			model.addAttribute(Constants.STATUS, status);
			return Constants.FEEDBACK_DETAIL;
/////////////////////////////////////////////////////////////
		}

		@RequestMapping(value = UrlConstants.CREATE_FEEDBACK, method = RequestMethod.POST)
		public String createFeedback(@ModelAttribute Feedback feedback, Model model, RedirectAttributes redirectAttributes) {
			SuccessStatus successStatus = new SuccessStatus();
			successStatus.sStatus = 1;
			
			try {
				this.feedbackService.createFeedback(feedback);
				successStatus.statusMessage = Constants.CREATE_SUCCESS_MESSAGE;

			} catch (ApplicationException e) {
				successStatus.sStatus = 0;
				successStatus.statusMessage = e.getMessage();
				
			}
			redirectAttributes.addFlashAttribute(Constants.SUCCESS_STATUS, successStatus);
			return  UrlConstants.REDIRECT+UrlConstants.ALL_FEEDBACKS;
		}

}




