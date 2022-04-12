package com.elearning.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dao.FeedbackDAO;
import com.elearning.model.Feedback;
import com.elearning.service.FeedbackService;
import com.elearning.util.ApplicationException;
import com.elearning.util.Constants;

@Service
public class FeedbackServiceImpl implements FeedbackService{

		
		@Autowired
		private FeedbackDAO feedbackDAO;



	
		public void createFeedback(Feedback feedback) throws ApplicationException {
			Integer createFeedback = this.feedbackDAO.createFeedback(feedback);
			if(createFeedback < 1) {
				throw new ApplicationException(Constants.CREATE_ERROR_MESSAGE);
			}
		}


		
		public void updateFeedback(Feedback feedback) throws ApplicationException {
			
						Integer updateFeedback = this.feedbackDAO.updateFeedback(feedback);
						if(updateFeedback == 0) {
							throw new ApplicationException(Constants.UPDATE_ERROR_MESSAGE);
						}
			
		}
		
		public List<Feedback> getAllFeedbacks() {
			List<Feedback> allFeedbacks = this.feedbackDAO.getAllFeedbacks();
			return allFeedbacks;
		}
		

		public Feedback getFeedbackById(Long id) throws ApplicationException {
			Feedback feedbackById = this.feedbackDAO.getFeedbackById(id);
			if(feedbackById == null) {
				throw new ApplicationException(Constants.NOT_FOUND_MESSAGE);
			}
			return feedbackById;
		}

}