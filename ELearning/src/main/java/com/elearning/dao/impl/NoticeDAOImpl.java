package com.elearning.dao.impl;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.elearning.dao.NoticeDAO;
import com.elearning.model.Notice;
import com.elearning.repository.NoticeRowMapper;
import com.elearning.util.Constants;

@Repository
public class NoticeDAOImpl implements NoticeDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Long createNotice(Notice notice) {
		// TODO Auto-generated method stub
		
		String sql = "insert into course(id, title, description, postedBy, position, postDate) "
		+ "values(?, ?, ?, ?, ?, TO_DATE(?, ?))";
		
	    KeyHolder kye = new GeneratedKeyHolder();
	    
	    this.jdbcTemplate.update(connection -> {
	       PreparedStatement preparedStatement  = connection.prepareStatement(sql, new String[] {"id"});
	        
	       if(notice.getId() == null ) {
	        	
	    	   preparedStatement.setNull(1, Types.NULL);
	       }
	       else {
	        	  
	    	   preparedStatement.setLong(1, notice.getId());
	    	   preparedStatement.setString(2, notice.getTitle());
	    	   preparedStatement.setString(3, notice.getDescription());
	    	   preparedStatement.setString(4, notice.getPostedBy());
	    	   preparedStatement.setString(4, notice.getPosition());
	    	   preparedStatement.setString(5, notice.getPostDate());
	    	   preparedStatement.setString(6, Constants.DB_DATE_FORMAT);
	        	  
	          }
			return preparedStatement;
	        	
	       	}, kye);
	    
	    	System.out.println(kye.getKey().longValue());
	        return kye.getKey().longValue();	
	}
	
	@Override
	public Notice getNoticeById(Long id) {
		// TODO Auto-generated method stub
		
		String sql = "select * from notice where id = ?";
		
		List<Notice> list = this.jdbcTemplate.query(sql, new NoticeRowMapper(), id);
		
		if(list.isEmpty()) {
			return null;
		}
		else {
			return list.get(0);
		}
	}

	@Override
	public List<Notice> getAllNoices() {
		// TODO Auto-generated method stub
		
		String sql = "select * from notice";
		
		List<Notice> list = this.jdbcTemplate.query(sql, new NoticeRowMapper());
		
		return list;

	}
	
	@Override
	public Long updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		
		String sql = "update course set title=?, description=?, postedBy=?, position=?, postDate=? where id = ?";
		
		int update = this.jdbcTemplate.update(sql, notice.getTitle(), notice.getDescription(), notice.getPostedBy(), notice.getPosition(), notice.getPostDate(), notice.getId());
		
		return (long) update;
	}
}
