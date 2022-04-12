package com.elearning.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.elearning.model.Notice;


public class NoticeRowMapper implements RowMapper<Notice>{

	@Override
	public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Notice notice = new Notice();
		notice.setId(rs.getLong("id"));
		notice.setTitle(rs.getString("title"));
		notice.setTitle(rs.getString("description"));
		notice.setTitle(rs.getString("postedBy"));
		notice.setTitle(rs.getString("position"));
		notice.setPostDate(rs.getString("postDate"));
		
		return notice;
	}
}
