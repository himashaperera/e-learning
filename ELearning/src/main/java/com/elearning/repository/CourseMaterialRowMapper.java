package com.elearning.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.elearning.model.CourseMaterial;
import com.elearning.model.Lesson;

public class CourseMaterialRowMapper implements RowMapper<CourseMaterial>{

	public CourseMaterial mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CourseMaterial courseMaterial = new CourseMaterial();
		courseMaterial.setId(rs.getLong("materialid"));
		courseMaterial.setName(rs.getString("name"));
		Date createdAt = rs.getDate("createdAt");
		Date updatedAt = rs.getDate("updatedAt");
		courseMaterial.setCreatedAt(createdAt);
		courseMaterial.setUpdatedAt(updatedAt);
		
		Lesson lesson = new Lesson();
		lesson.setId(rs.getLong("lesnMaterialid"));
		courseMaterial.setLesson(lesson);
		return courseMaterial;
	}

}
