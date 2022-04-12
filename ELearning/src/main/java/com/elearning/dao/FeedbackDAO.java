package com.elearning.dao;

import java.util.List;

import com.elearning.model.Feedback;


public interface FeedbackDAO {

	public Integer createFeedback(Feedback feedback);
	public Integer updateFeedback(Feedback feedback);
	public Feedback getFeedbackById(Long id);
	public List<Feedback> getAllFeedbacks();

	
	
}
