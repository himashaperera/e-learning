package com.elearning.dao;

import java.util.List;

import com.elearning.model.Document;

public interface DocumentDAO {

	Integer createDocument(Document document);
	Integer updateDocument(Document document);
	Document getDocumentById(Long id);
	List<Document> getAllDocuments();
	List<Document> getDocumentsByCourseMaterialId(Long id);
	
}
