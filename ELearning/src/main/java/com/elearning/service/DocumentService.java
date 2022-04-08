package com.elearning.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elearning.model.Document;
import com.elearning.util.ApplicationException;

public interface DocumentService {

	void createDocument(Document document) throws ApplicationException;
	void updateDocument(Document document) throws ApplicationException;
	Document getDocumentById(Long id) throws ApplicationException;
	List<Document> getAllDocuments();
	void downLoadDocument(Long id,HttpServletRequest request, HttpServletResponse response) throws IOException, ApplicationException;
}
