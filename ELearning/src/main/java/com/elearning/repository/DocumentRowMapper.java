package com.elearning.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.elearning.model.Assignment;
import com.elearning.model.CourseMaterial;
import com.elearning.model.Document;

public class DocumentRowMapper implements RowMapper<Document>{

	public Document mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Document document = new Document();
		document.setId(rs.getLong("id"));
		document.setName(rs.getString("name"));
		document.setLocation(rs.getString("location"));
		
		if(rs.getLong("docMaterialid") != 0) {
			CourseMaterial courseMaterial = new CourseMaterial();
			courseMaterial.setId(rs.getLong("docMaterialid"));
		}
		
		if(rs.getLong("docAssignid") != 0) {
			Assignment Assignment  = new Assignment();
			Assignment.setId(rs.getLong("docAssignid"));
		}
		
		Date createdAt = rs.getDate("createdAt");
		Date updatedAt = rs.getDate("updatedAt");
		document.setCreatedAt(createdAt);
		document.setUpdatedAt(updatedAt);
		return document;
	}

}
