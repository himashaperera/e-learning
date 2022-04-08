package com.elearning.util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class UploadFolderNameFormatter {

	private static SimpleDateFormat SimpleDateFormat = new SimpleDateFormat(Constants.FILE_UPLOAD_FOLDER_FORMAT);
	
	public static String getUploadFolderName(Date date) {
		return SimpleDateFormat.format(date);
	}
	
	
}
