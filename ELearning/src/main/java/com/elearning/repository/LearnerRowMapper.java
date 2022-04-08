package com.elearning.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elearning.model.Learner;

public class LearnerRowMapper implements RowMapper<Learner>{

	public Learner mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Learner learner= new Learner();
		learner.setId(rs.getLong("id"));
		learner.setFirstName(rs.getString("firstname"));
		learner.setLastName(rs.getString("lastname"));
		learner.setUserName(rs.getString("username"));
		learner.setEmail(rs.getString("email"));
		learner.setPassword(rs.getString("password"));
		learner.setNumberOfCoursesTaken(rs.getInt("no_of_courses"));
		return learner;
	}

}
