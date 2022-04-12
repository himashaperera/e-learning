package com.elearning.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.elearning.dao.CourseMaterialDAO;
import com.elearning.dao.DocumentDAO;
import com.elearning.model.CourseMaterial;
import com.elearning.model.Document;
import com.elearning.service.CourseMaterialService;
import com.elearning.service.DocumentService;
import com.elearning.util.ApplicationException;
import com.elearning.util.Constants;

@Service
public class CourseMaterialServiceImpl implements CourseMaterialService{
	
	@Autowired
	private CourseMaterialDAO courseMaterialDAO;

	@Autowired
	private DocumentDAO documentDAO;
	
	@Autowired
	private DocumentService documentService;
	
	public CourseMaterial getCourseMaterialById(Long id) throws ApplicationException {
		
		CourseMaterial courseMaterial = this.courseMaterialDAO.getCourseMaterialById(id);
		if(courseMaterial == null) {
			throw new ApplicationException(Constants.NOT_FOUND_MESSAGE);
		}
		List<Document> documentsByCourseMaterialId = this.documentDAO.getDocumentsByCourseMaterialId(id);
		courseMaterial.setDocumentList(documentsByCourseMaterialId);
		return courseMaterial;
	}

	public List<CourseMaterial> getAllCourseMaterial() {
		List<CourseMaterial> allCourseMaterial = this.courseMaterialDAO.getAllCourseMaterial();
		for (CourseMaterial courseMaterial : allCourseMaterial) {
			List<Document> documentsByCourseMaterialId = this.documentDAO.getDocumentsByCourseMaterialId(courseMaterial.getId());
			courseMaterial.setDocumentList(documentsByCourseMaterialId);
		}
		
		return allCourseMaterial;
	}
	
	@Transactional
	public void createCourseMaterial(CourseMaterial courseMaterial) throws ApplicationException {
		
		courseMaterial.setCreatedAt(new Date());
		courseMaterial.setUpdatedAt(new Date());
		Long courseMaterialId = this.courseMaterialDAO.createCourseMaterial(courseMaterial);
		if(courseMaterialId == null)
			throw new ApplicationException(Constants.CREATE_ERROR_MESSAGE);
		
		List<MultipartFile> documents = courseMaterial.getDocuments();
		courseMaterial.setId(courseMaterialId);
		if (null != documents && documents.size() > 0) {
			for (MultipartFile multipartFilefile : documents) {
				Document document = new Document();
				document.setCourseMaterial(courseMaterial);
				document.setDocument(multipartFilefile);
				this.documentService.createDocument(document);
			}
		}
		
	}

	public void updateCourseMaterial(CourseMaterial courseMaterial) throws ApplicationException {
		Integer updateCount = this.courseMaterialDAO.updateteCourseMaterial(courseMaterial);
		if(updateCount < 0) {
			throw new ApplicationException(Constants.UPDATE_ERROR_MESSAGE);
		}
	}

	@Override
	public List<CourseMaterial> getAllCourseMaterialByLessonId(Long id) {
		List<CourseMaterial> allCourseMaterialByLessonId = this.courseMaterialDAO.getAllCourseMaterialByLessonId(id);
		for (CourseMaterial courseMaterial : allCourseMaterialByLessonId) {
			List<Document> documentsByCourseMaterialId = this.documentDAO.getDocumentsByCourseMaterialId(courseMaterial.getId());
			courseMaterial.setDocumentList(documentsByCourseMaterialId);
		}
		return allCourseMaterialByLessonId;
	}

}
