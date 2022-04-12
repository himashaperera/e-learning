package com.elearning.dao;

import java.util.List;

import com.elearning.model.Lecturer;


public interface LecturerDAO {

	public Integer createLecturer(Lecturer lecturer);
	public Integer updateLecturer(Lecturer lecturer);
	public Lecturer getLecturerById(Long id);
	public List<Lecturer> getAllLecturers();
	
}
