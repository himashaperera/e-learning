package com.elearning.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.elearning.dao.LearnerDAO;
import com.elearning.model.Learner;
import com.elearning.repository.LearnerRowMapper;

@Repository
public class LearnerDAOImpl implements LearnerDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Integer createLearner(Learner learner) {
		System.out.println(learner.getPassword().hashCode());
		String sql = "insert into learner(learnerid, firstName, lastName, email, userName, password) values(?, ?, ?, ?, ?, ?)";
		int update = this.jdbcTemplate.update(sql, learner.getId(), learner.getFirstName(), learner.getLastName(), learner.getEmail(),
				learner.getUserName(), learner.getPassword().hashCode());
		return update;
	}

	public Integer updateLearner(Learner learner) {
		String sql = "update learner set firstname = ?, lastname = ? , email = ?, username = ?, password =  ? where id = ?";
		int update = this.jdbcTemplate.update(sql, learner.getFirstName(), learner.getLastName(), learner.getEmail(),
				learner.getUserName(), learner.getPassword(), learner.getId());
		return update;

	}

	public Learner getLearnerById(Long id) {
		String sql = "select * from learner where id = ? ";
		List<Learner> learnerList = this.jdbcTemplate.query(sql, new LearnerRowMapper(), id);
		
		if(learnerList.isEmpty()) {
			return null;
		}else {
			return learnerList.get(0);
		}
	}

	public Learner getLearnerByEmail(String email) {
		String sql = "select * from learner where email = ? ";
		List<Learner> learnerList = this.jdbcTemplate.query(sql, new LearnerRowMapper(), email);
		
		if(learnerList.isEmpty()) {
			return null;
		}else {
			return learnerList.get(0);
		}
	}
	
	public List<Learner> getAllLearners() {
		
		String sql = "select * from learner";
		List<Learner> learnerList = this.jdbcTemplate.query(sql, new LearnerRowMapper());
		System.out.println(learnerList);
		return learnerList;
	}

}
