package com.elearning.dao.impl;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.elearning.dao.CourseDAO;
import com.elearning.model.Course;
import com.elearning.repository.CourseRowMapper;
import com.elearning.util.Constants;

@Repository
public class CourseDAOImpl implements CourseDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Long createCourse(Course course) {
		
		String sql = "insert into course(courseId, courseName, description, code, duration, startDate, endDate) "
				+ "values(?, ?, ?, ?, TO_DATE(?, ?), TO_DATE(?, ?),TO_DATE(?, ?))";
	    KeyHolder keyHolder = new GeneratedKeyHolder();
	    this.jdbcTemplate.update(connection -> {
	        PreparedStatement ps = connection
	          .prepareStatement(sql, new String[] {"courseId"});
	          if(course.getId() == null )
	        	  ps.setNull(1, Types.NULL);
	          else
	        	  ps.setLong(1, course.getId());
	          
	          ps.setString(2, course.getName());
	          ps.setString(3, course.getDescription());
	          ps.setString(4, course.getCode());
	          ps.setString(5, course.getStartDate());
	          ps.setString(6, Constants.DB_DATE_FORMAT);
	          ps.setString(7, course.getStartDate());
	          ps.setString(8, Constants.DB_DATE_FORMAT);
	          ps.setString(9, course.getEndDate());
	          ps.setString(10, Constants.DB_DATE_FORMAT);
	          return ps;
	        }, keyHolder);
	    
	    	System.out.println(keyHolder.getKey().longValue());
	        return keyHolder.getKey().longValue();

	}

	@Override
	public Long updateCourse(Course course) {
		String sql = "update course set courseName=?, description=?, code=?, duration=?, startDate=?, endDate=? where courseId = ?";
		int update = this.jdbcTemplate.update(sql, course.getName(), course.getDescription(), course.getCode(), 
				course.getDuration(), course.getStartDate(), course.getEndDate(), course.getId());
		return (long)update;
	}

	@Override
	public List<Course> getAllCourses() {
		String sql = "select * from course";
		List<Course> list = this.jdbcTemplate.query(sql, new CourseRowMapper());
		return list;
	}

	@Override
	public Course getCourseById(Long id) {
		String sql = "select * from course where courseId = ?";
		List<Course> list = this.jdbcTemplate.query(sql, new CourseRowMapper(), id);
		if(list.isEmpty())
			return null;
		else
			return list.get(0);
	}

}
