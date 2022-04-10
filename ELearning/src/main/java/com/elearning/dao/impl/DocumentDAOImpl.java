package com.elearning.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.elearning.dao.DocumentDAO;
import com.elearning.model.Document;
import com.elearning.repository.DocumentRowMapper;
import com.elearning.util.Constants;
import com.elearning.util.ELearningDateFormatter;

@Repository
public class DocumentDAOImpl implements DocumentDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Integer createDocument(Document document) {
		String sql = "insert into document(id, name, location, createdAt, updatedAt, docMaterialid, docAssignid) values(?, ?, ?, TO_DATE( ?, ?), TO_DATE( ?, ?), ?, ?)";
		
		String createdAt = ELearningDateFormatter.formatDate(document.getCreatedAt());
		String updatedAt = ELearningDateFormatter.formatDate(document.getUpdatedAt());
		
		int update = this.jdbcTemplate.update(sql, document.getId(), document.getName(),document.getLocation(),
				createdAt, Constants.DATE_FORMAT, 
				updatedAt, Constants.DATE_FORMAT, 
				document.getCourseMaterial() == null ? null: document.getCourseMaterial().getId(), 
				document.getAssignment() == null ? null: document.getAssignment().getId());
		return update;
	}

	public Integer updateDocument(Document document) {
		// TODO Auto-generated method stub
		return null;
	}

	public Document getDocumentById(Long id) {
		String sql = "select * from document where id = ?";
		List<Document> documentList = this.jdbcTemplate.query(sql, new DocumentRowMapper(), id);
		if(documentList.isEmpty()) {
			return null;
		}else {
			return documentList.get(0);
		}
	}

	public List<Document> getAllDocuments() {
		
		String sql = "select * from document";
		List<Document> documentList = this.jdbcTemplate.query(sql, new DocumentRowMapper());
		return documentList;
	}

	public List<Document> getDocumentsByCourseMaterialId(Long id) {
		String sql = "select * from document where docMaterialid = ?";
		List<Document> documentList = this.jdbcTemplate.query(sql, new DocumentRowMapper(), id);
		return documentList;
	}

}
