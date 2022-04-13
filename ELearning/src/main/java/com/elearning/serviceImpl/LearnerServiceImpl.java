package com.elearning.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dao.LearnerDAO;
import com.elearning.model.Learner;
import com.elearning.service.LearnerService;
import com.elearning.util.ApplicationException;
import com.elearning.util.Constants;

@Service
public class LearnerServiceImpl implements LearnerService{
	
	@Autowired
	private LearnerDAO learnerDAO;

	public void createLearner(Learner learner) throws ApplicationException {
		
		Integer createLearner = this.learnerDAO.createLearner(learner);
		if(createLearner < 1) {
			throw new ApplicationException(Constants.CREATE_ERROR_MESSAGE);
		}
	}

	public void updateLearner(Learner learner) throws ApplicationException {
		
		Integer updateLearner = this.learnerDAO.updateLearner(learner);
		if(updateLearner == 0) {
			throw new ApplicationException(Constants.UPDATE_ERROR_MESSAGE);
		}
	}

	public List<Learner> getAllLearners() {
		List<Learner> allLearners = this.learnerDAO.getAllLearners();
		return allLearners;
	}

	public Learner getLearnerById(Long id) throws ApplicationException {
		Learner learnerById = this.learnerDAO.getLearnerById(id);
		if(learnerById == null) {
			throw new ApplicationException(Constants.NOT_FOUND_MESSAGE);
		}
		return learnerById;
	}

	@Override
	public Learner getLearnerByEmail(Learner learner) throws ApplicationException{
		
		Learner learnerByEmail = this.learnerDAO.getLearnerByEmail(learner.getEmail());
		if(learnerByEmail == null) {
			throw new ApplicationException(Constants.NOT_FOUND_MESSAGE);
		}
		
		String password = Integer.toString(learner.getPassword().hashCode());
		
		if(password.equals(learnerByEmail.getPassword()))
			return learnerByEmail;
		else 
			throw new ApplicationException(Constants.PASSWORD_INCORRECT_MESSAGE);
	}


}
