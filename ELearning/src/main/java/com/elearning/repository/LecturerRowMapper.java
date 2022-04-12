package com.elearning.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elearning.model.Lecturer;

public class LecturerRowMapper implements RowMapper<Lecturer>{

	public Lecturer mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Lecturer lecturer= new Lecturer();
		lecturer.setId(rs.getLong("id"));
		lecturer.setFirstName(rs.getString("firstname"));
		lecturer.setLastName(rs.getString("lastname"));
		lecturer.setUserName(rs.getString("username"));
		lecturer.setEmail(rs.getString("email"));
		lecturer.setPassword(rs.getString("password"));
		lecturer.setjoinedDate(rs.getString("joined_date"));
		return lecturer;
	}

}
