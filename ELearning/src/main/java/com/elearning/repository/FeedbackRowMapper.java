package com.elearning.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.elearning.model.Feedback;


public class FeedbackRowMapper implements RowMapper<Feedback>{


		public Feedback mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Feedback feedback= new Feedback();
			feedback.setId(rs.getLong("id"));
			feedback.setLearner(rs.getString("learner"));
			feedback.setCourse(rs.getString("course"));
			feedback.setContent(rs.getString("content"));
	
			return feedback;
			
			
		}

	}