package com.elearning.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dao.LecturerDAO;
import com.elearning.model.Lecturer;
import com.elearning.service.LecturerService;
import com.elearning.util.ApplicationException;
import com.elearning.util.Constants;

@Service
public class LecturerServiceImpl implements LecturerService{
	
	@Autowired
	private LecturerDAO lecturerDAO;

	public void createLecturer(Lecturer lecturer) throws ApplicationException {
		
		Integer createLecturer = this.lecturerDAO.createLecturer(lecturer);
		if(createLecturer < 1) {
			throw new ApplicationException(Constants.CREATE_ERROR_MESSAGE);
		}
	}

	public void updateLecturer(Lecturer lecturer) throws ApplicationException {
		
		Integer updateLecturer = this.lecturerDAO.updateLecturer(lecturer);
		if(updateLecturer == 0) {
			throw new ApplicationException(Constants.UPDATE_ERROR_MESSAGE);
		}
	}

	public List<Lecturer> getAllLecturers() {
		List<Lecturer> allLecturers = this.lecturerDAO.getAllLecturers();
		return allLecturers;
	}

	public Lecturer getLecturerById(Long id) throws ApplicationException {
		Lecturer lecturerById = this.lecturerDAO.getLecturerById(id);
		if(lecturerById == null) {
			throw new ApplicationException(Constants.NOT_FOUND_MESSAGE);
		}
		return lecturerById;
	}


}
