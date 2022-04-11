package com.elearning.service;

import java.util.List;

import com.elearning.model.CourseMaterial;
import com.elearning.util.ApplicationException;

public interface CourseMaterialService {
	
	CourseMaterial getCourseMaterialById(Long id) throws ApplicationException;
	List<CourseMaterial> getAllCourseMaterial();
	List<CourseMaterial> getAllCourseMaterialByLessonId(Long id);
	void createCourseMaterial(CourseMaterial courseMaterial) throws ApplicationException;
	void updateCourseMaterial(CourseMaterial courseMaterial) throws ApplicationException;
	

}
