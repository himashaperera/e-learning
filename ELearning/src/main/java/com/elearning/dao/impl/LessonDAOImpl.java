package com.elearning.dao.impl;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.elearning.dao.LessonDAO;
import com.elearning.model.Lesson;
import com.elearning.repository.LessonRowMapper;
import com.elearning.util.Constants;

@Repository
public class LessonDAOImpl implements LessonDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Long createLesson(Lesson lesson) {
		
		String sql = "insert into lesson(lessonId, lessonName, description, startDate, endDate, lesCourseid) "
				+ "values(?, ?, ?, TO_DATE(?, ?), TO_DATE(?, ?), ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, new String[] {"lessonId"});
			ps.setNull(1, Types.NULL);
			ps.setString(2, lesson.getName());
			ps.setString(3, lesson.getDescription());
			ps.setString(4, lesson.getStartDate());
			ps.setString(5, Constants.DB_DATE_FORMAT);
			ps.setString(6, lesson.getEndDate());
			ps.setString(7, Constants.DB_DATE_FORMAT);
			ps.setLong(8, lesson.getCourse().getId());
			return ps;
		}, keyHolder);
		
		return keyHolder.getKey().longValue();
		
	}

	@Override
	public Integer updateLesson(Lesson lesson) {
		String sql = "update lesson set  lessonName = ?, description = ?, startDate =  TO_DATE(?, ?), endDate = TO_DATE(?, ?) , lesCourseid = ? ) where lessonId = ?";
		int updateCount = this.jdbcTemplate.update(sql, lesson.getName(), lesson.getDescription(), lesson.getStartDate(), Constants.DB_DATE_FORMAT, 
				lesson.getEndDate(), Constants.DB_DATE_FORMAT, lesson.getCourse().getId(), lesson.getId());
		return updateCount;
	}

	@Override
	public List<Lesson> getAllLessons() {
		String sql = "select * from lesson";
		List<Lesson> lessonList = this.jdbcTemplate.query(sql, new LessonRowMapper());
		return lessonList;
	}

	@Override
	public Lesson getLessonById(Long id) {
		String sql = "select * from lesson where lessonId = ? ";
		List<Lesson> lessonList = this.jdbcTemplate.query(sql, new LessonRowMapper(), id);
		if(lessonList.isEmpty())
			return null;
		else 
			return lessonList.get(0);
	}

	@Override
	public List<Lesson> getAllLessonsByCourseId(Long id) {
		String sql = "select * from lesson where lesCourseid = ?";
		List<Lesson> lessonList = this.jdbcTemplate.query(sql, new LessonRowMapper(), id);
		return lessonList;

	}

}
