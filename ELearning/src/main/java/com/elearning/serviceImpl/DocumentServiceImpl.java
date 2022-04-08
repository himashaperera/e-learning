package com.elearning.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.elearning.dao.DocumentDAO;
import com.elearning.model.Document;
import com.elearning.service.DocumentService;
import com.elearning.util.ApplicationException;
import com.elearning.util.Constants;
import com.elearning.util.UploadFolderNameFormatter;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentDAO documentDAO;

	public void createDocument(Document document) throws ApplicationException {

		MultipartFile multipartFile = document.getDocument();
		if (multipartFile != null) {
			File tempFolder = new File(Constants.UPLOADED_FOLDER);
			System.out.println(tempFolder.getName());

			if (!tempFolder.exists()) {
				boolean mkdir = tempFolder.mkdir();
				System.out.println(tempFolder.getAbsolutePath());
				System.out.println("temp folder created successfully..");
			}

			String format = UploadFolderNameFormatter.getUploadFolderName(new Date());
			File uploadFolder = new File(tempFolder, format);
			boolean mkdirUploadFolder = uploadFolder.mkdir();
			System.out.println("upload folder created: " + mkdirUploadFolder);
			System.out.println(uploadFolder.getAbsolutePath());

			String fileName = multipartFile.getOriginalFilename();
			System.out.println(fileName);
			File imageFile = new File(uploadFolder, fileName);
			String absolutePath = imageFile.getAbsolutePath();
			try {
				multipartFile.transferTo(imageFile);
			} catch (IOException e) {
				e.printStackTrace();
			}

			document.setName(fileName);
			document.setLocation(absolutePath);
			document.setCreatedAt(new Date());
			document.setUpdatedAt(new Date());
		}

		Integer createDocument = this.documentDAO.createDocument(document);
		if (createDocument < 0) {
			throw new ApplicationException(Constants.CREATE_ERROR_MESSAGE);
		}
	}

	public void updateDocument(Document document) throws ApplicationException {

	}

	public Document getDocumentById(Long id) throws ApplicationException {

		Document document = this.documentDAO.getDocumentById(id);
		if (document == null) {
			throw new ApplicationException(Constants.NOT_FOUND_MESSAGE);
		}
		return document;
	}

	public List<Document> getAllDocuments() {
		return this.documentDAO.getAllDocuments();
	}

	public void downLoadDocument(Long id, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ApplicationException {

		ServletContext context = request.getServletContext();
		Document documentById = getDocumentById(id);

		// construct the complete absolute path of the file
		String fullPath = documentById.getLocation();
		File downloadFile = new File(fullPath);
		FileInputStream inputStream = new FileInputStream(downloadFile);

		// get MIME type of the file
		String mimeType = context.getMimeType(fullPath);
		if (mimeType == null) {
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}
		System.out.println("MIME type: " + mimeType);

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		// set headers for the response
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		response.setHeader(headerKey, headerValue);

		// get output stream of the response
		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[Constants.BUFFER_SIZE];
		int bytesRead = -1;

		// write bytes read from the input stream into the output stream
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inputStream.close();
		outStream.close();

	}

}
