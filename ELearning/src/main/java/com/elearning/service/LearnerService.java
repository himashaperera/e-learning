package com.elearning.service;

import java.util.List;

import com.elearning.model.Learner;
import com.elearning.util.ApplicationException;

public interface LearnerService {
	
	void createLearner(Learner learner) throws ApplicationException;
	void updateLearner(Learner learner) throws ApplicationException;
	List<Learner> getAllLearners();
	Learner getLearnerByEmail(Learner learner) throws ApplicationException;
	Learner getLearnerById(Long id) throws ApplicationException ;
	
}
