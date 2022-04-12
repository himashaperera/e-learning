package com.elearning.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.elearning.dao.FeedbackDAO;
import com.elearning.model.Feedback;
import com.elearning.repository.FeedbackRowMapper;

@Repository
public class FeedbackDAOImpl implements FeedbackDAO{



		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		
		public Integer createFeedback(Feedback feedback) {
			String sql = "insert into feedback(id, learner, course, content) values(?, ?, ?, ?)";
			System.out.println(feedback.getLearner());
			
			int update = this.jdbcTemplate.update(sql, feedback.getId(), feedback.getLearner(), feedback.getCourse(), feedback.getContent());
			return update;
		}
		
		
		public Integer updateFeedback(Feedback feedback) {
			
			String sql = "update feedback set learner = ?, course = ? , content = ? where id = ?";
			int update = this.jdbcTemplate.update(sql, feedback.getId(), feedback.getLearner(), feedback.getCourse(), feedback.getContent());
			return update;
		}
		

		public Feedback getFeedbackById(Long id) {
			String sql = "select * from feedback where id = ? ";
			List<Feedback> feedbackList = this.jdbcTemplate.query(sql, new FeedbackRowMapper(), id);
			
			if(feedbackList.isEmpty()) {
				return null;
			}else {
				return feedbackList.get(0);
			}
		}
		

		public List<Feedback> getAllFeedbacks() {
			
			String sql = "select * from feedback";
			List<Feedback> feedbackList = this.jdbcTemplate.query(sql, new FeedbackRowMapper());
			System.out.println(feedbackList);
			return feedbackList;
			
		}
	}



