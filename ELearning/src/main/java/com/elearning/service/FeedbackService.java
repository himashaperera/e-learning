package com.elearning.service;

import java.util.List;

import com.elearning.model.Feedback;
import com.elearning.util.ApplicationException;

public interface FeedbackService {

	public void createFeedback(Feedback feedback) throws ApplicationException;
	public void updateFeedback(Feedback feedback) throws ApplicationException;
	public List<Feedback> getAllFeedbacks();
	public Feedback getFeedbackById(Long id) throws ApplicationException ;

	}
	
