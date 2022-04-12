package com.elearning.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elearning.model.Course;
import com.elearning.model.Lesson;

public class LessonRowMapper implements RowMapper<Lesson>{

	@Override
	public Lesson mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Lesson lesson = new Lesson();
		lesson.setId(rs.getLong("lessonId"));
		lesson.setName(rs.getString("lessonName"));
		lesson.setDescription(rs.getString("description"));
		lesson.setStartDate(rs.getString("startDate"));
		lesson.setEndDate(rs.getString("endDate"));
		
		Course course = new Course();
		course.setId(rs.getLong("lesCourseid"));
		lesson.setCourse(course);;
		return lesson;
	}

}
