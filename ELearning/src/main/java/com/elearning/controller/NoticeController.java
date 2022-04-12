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

import com.elearning.model.Notice;
import com.elearning.service.NoticeService;
import com.elearning.util.ApplicationException;
import com.elearning.util.Constants;
import com.elearning.util.SuccessStatus;
import com.elearning.util.UrlConstants;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;

	@RequestMapping(path = UrlConstants.ALL_NOTICES, method = RequestMethod.GET)
	public String getAllNoices(Model model) {

		List<Notice> allNotices = this.noticeService.getAllNoices();
		model.addAttribute("notices", allNotices);
		return Constants.NOTICE_VIEW;
	}

	@RequestMapping(path = UrlConstants.GET_NOTICE, method = RequestMethod.GET)
	public String getNoticeById(@PathVariable("id") Long id, Model model) {
		
		Notice noticeId;
		int status = 1;
		
		try {
			noticeId = this.noticeService.getNoticeById(id);
			model.addAttribute("feedback", noticeId);
		} 
		catch (ApplicationException e) {
			status = 0;
			model.addAttribute(Constants.SUCCESS_STATUS, e.getMessage());
		}
		
		model.addAttribute(Constants.STATUS, status);
		
		return Constants.NOTICE_DETAIL;
	}

	@RequestMapping(path = UrlConstants.CREATE_NOTICE, method = RequestMethod.POST)
	public String createNotice(@ModelAttribute("notice") Notice notice, Model model,  RedirectAttributes redirectAttributes) {

		SuccessStatus successStatus = new SuccessStatus();
		
		successStatus.sStatus = 1;
		
		try {
			this.noticeService.createNotice(notice);
			successStatus.statusMessage = Constants.CREATE_SUCCESS_MESSAGE;

		} catch (ApplicationException e) {
			successStatus.sStatus = 0;
			successStatus.statusMessage = e.getMessage();
			
		}
		redirectAttributes.addFlashAttribute(Constants.SUCCESS_STATUS, successStatus);
		return  UrlConstants.REDIRECT+UrlConstants.ALL_NOTICES;
	}

}
