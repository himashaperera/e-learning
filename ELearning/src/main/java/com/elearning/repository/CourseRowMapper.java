package com.elearning.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elearning.model.Course;

public class CourseRowMapper implements RowMapper<Course>{

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = new Course();
		course.setId(rs.getLong("courseId"));
		course.setCode(rs.getString("code"));
		course.setName(rs.getString("courseName"));
		course.setDescription(rs.getString("description"));
		course.setDuration(rs.getLong("duration"));
		course.setStartDate(rs.getString("startDate"));
		course.setEndDate(rs.getString("endDate"));
		return course;
	}

}
