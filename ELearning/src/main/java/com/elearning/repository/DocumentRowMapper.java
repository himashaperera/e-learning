package com.elearning.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elearning.model.Document;

public class DocumentRowMapper implements RowMapper<Document>{

	public Document mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Document document = new Document();
		document.setId(rs.getLong("id"));
		document.setName(rs.getString("name"));
		document.setLocation(rs.getString("location"));
		
		//add dates
		return document;
	}

}
