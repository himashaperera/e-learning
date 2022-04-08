package com.elearning.dao;

import java.util.List;

import com.elearning.model.Learner;


public interface LearnerDAO {

	Integer createLearner(Learner learner);
	Integer updateLearner(Learner learner);
	Learner getLearnerById(Long id);
	List<Learner> getAllLearners();
	
}
