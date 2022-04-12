package com.elearning.service;

import java.util.List;

import com.elearning.model.Lecturer;
import com.elearning.util.ApplicationException;

public interface LecturerService {
	
	public void createLecturer(Lecturer lecturer) throws ApplicationException;
	public void updateLecturer(Lecturer lecturer) throws ApplicationException;
	public List<Lecturer> getAllLecturers();
	public Lecturer getLecturerById(Long id) throws ApplicationException ;
	
}
