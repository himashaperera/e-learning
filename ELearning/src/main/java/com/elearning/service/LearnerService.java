package com.elearning.service;

import java.util.List;

import com.elearning.model.Learner;
import com.elearning.util.ApplicationException;

public interface LearnerService {
	
	public void createLearner(Learner learner) throws ApplicationException;
	public void updateLearner(Learner learner) throws ApplicationException;
	public List<Learner> getAllLearners();
	public Learner getLearnerById(Long id) throws ApplicationException ;
	
}
