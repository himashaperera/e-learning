package com.elearning.dao;

import java.util.List;

import com.elearning.model.CourseMaterial;

public interface CourseMaterialDAO {

	CourseMaterial getCourseMaterialById(Long id);
	List<CourseMaterial> getAllCourseMaterial();
	Long createCourseMaterial(CourseMaterial courseMaterial);
	Integer updateteCourseMaterial(CourseMaterial courseMaterial);
}
