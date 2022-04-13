package com.elearning.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.elearning.dao.LecturerDAO;
import com.elearning.model.Lecturer;
import com.elearning.repository.LecturerRowMapper;

@Repository
public class LecturerDAOImpl implements LecturerDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Integer createLecturer(Lecturer lecturer) {
		String sql = "insert into lecturer(id, firstname, lastname, email, username, password) values(?, ?, ?, ?, ?, ?)";
		int update = this.jdbcTemplate.update(sql, lecturer.getId(), lecturer.getFirstName(), lecturer.getLastName(), lecturer.getEmail(),
				lecturer.getUserName(), lecturer.getPassword());
		return update;
	}

	public Integer updateLecturer(Lecturer lecturer) {
		
		String sql = "update lecturer set firstname = ?, lastname = ? , email = ?, username = ?, password =  ? where id = ?";
		int update = this.jdbcTemplate.update(sql, lecturer.getFirstName(), lecturer.getLastName(), lecturer.getEmail(),
				lecturer.getUserName(), lecturer.getPassword(), lecturer.getId());
		return update;

	}

	public Lecturer getLecturerById(Long id) {
		String sql = "select * from lecturer where id = ? ";
		List<Lecturer> lecturerList = this.jdbcTemplate.query(sql, new LecturerRowMapper(), id);
		
		if(lecturerList.isEmpty()) {
			return null;
		}else {
			return lecturerList.get(0);
		}
	}

	public List<Lecturer> getAllLecturers() {
		
		String sql = "select * from lecturer";
		List<Lecturer> lecturerList = this.jdbcTemplate.query(sql, new LecturerRowMapper());
		System.out.println(lecturerList);
		return lecturerList;
	}

}
