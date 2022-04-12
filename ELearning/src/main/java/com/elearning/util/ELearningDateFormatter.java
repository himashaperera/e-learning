package com.elearning.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ELearningDateFormatter {

	private static SimpleDateFormat dateFormatter = new SimpleDateFormat(Constants.DATE_FORMAT);
	private static DateTimeFormatter  dateTimeFormatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT_HTML);
	private static SimpleDateFormat htmlDateFormatter = new SimpleDateFormat(Constants.DATE_FORMAT_HTML);
	
	public static String formatDate(Date date) {
		return dateFormatter.format(date);
	}
	
	public static Date formatStringDate(String date) throws ParseException {
		return dateFormatter.parse(date);
	}
	
	public static String formatDateHTML(Date date) {
		return htmlDateFormatter.format(date);
	}
	
	public static Date formatStringDateHTML(String date) throws ParseException {
		return htmlDateFormatter.parse(date);
	}

	public static DateTimeFormatter getDateTimeFormatter() {
		return dateTimeFormatter;
	}

	public static void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
		ELearningDateFormatter.dateTimeFormatter = dateTimeFormatter;
	}
	
	
	
}
