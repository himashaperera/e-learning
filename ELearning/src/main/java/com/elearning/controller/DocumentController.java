package com.elearning.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elearning.model.Document;
import com.elearning.service.DocumentService;
import com.elearning.util.ApplicationException;
import com.elearning.util.Constants;
import com.elearning.util.UrlConstants;

@Controller
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	@RequestMapping(path = UrlConstants.DOCUMENT_UPLOAD, method = RequestMethod.POST)
	public String createDocument(@ModelAttribute Document document, Model model) {
		try {
			this.documentService.createDocument(document);
			model.addAttribute(Constants.SUCCESS_STATUS, Constants.CREATE_SUCCESS_MESSAGE);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return Constants.DOCUMENT_VIEW;
	}

	@RequestMapping(path = UrlConstants.GET_ALL_DOCUMENTS, method = RequestMethod.GET)
	public String getAllDocuments(Model model) {
		List<Document> allDocuments = this.documentService.getAllDocuments();
		model.addAttribute("documentList", allDocuments);
		return Constants.DOCUMENT_VIEW;
	}

	@RequestMapping(path= UrlConstants.DOCUMENT_DOWNLOAD_BY_ID, method = RequestMethod.GET)
	public void doDownload(@PathVariable("id") Long id,HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		try {
			this.documentService.downLoadDocument(id, request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

}
