package com.elearning.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ELearningDateFormatter {

	private static SimpleDateFormat dateFormatter = new SimpleDateFormat(Constants.DATE_FORMAT);
	
	public static String formatDate(Date date) {
		return dateFormatter.format(date);
	}
	
	public static Date formatStringDate(String date) throws ParseException {
		return dateFormatter.parse(date);
	}
	
}
