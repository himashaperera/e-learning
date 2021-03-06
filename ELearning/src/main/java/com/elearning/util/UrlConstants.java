package com.elearning.util;

public class UrlConstants {

	public static final String REDIRECT = "redirect:";
	
	public static final String GET_COURSE = "/courses/{id}";
	public static final String GET_UPDATE_COURSE_FORM = "/courses/{id}/update";
	public static final String ALL_COURSES = "/courses";
	public static final String CREATE_COURSE = "/courses";
	public static final String UPDATE_COURSE = "courses/{id}/update";
	
	public static final String GET_COURSE_MATERIAL = "/course-material/{id}";
	public static final String GET_ALL_COURSE_MATERIAL  = "/course-material";
	public static final String CREATE_COURSE_MATERIAL  = "/course-material";
	public static final String UPDATE_COURSE_MATERIAL  = "/course-material/update";
	
	public static final String GET_LEARNER = "/learners/{id}";
	public static final String ALL_LEARNERS = "/learners";
	public static final String SIGN_IN_LEARNERS_VIEW = "/";
	public static final String SIGN_IN_LEARNERS = "/sign-in";
	public static final String CREATE_LEARNER = "/learners/add";
	public static final String UPDATE_LEARNER = "/learners/update";
	
	public static final String GET_LESSON = "/courses/lessons/{id}";
	public static final String ALL_LESSON = "/courses/lessons";
	public static final String CREATE_LESSON = "/courses/{id}/lessons/add";
	public static final String CREATE_LESSON_FORM = "/courses/{id}/lessons/form";
	public static final String UPDATE_LESSON = "/lessons/update";
	
	
	public static final String DOCUMENT_UPLOAD = "/upload";
	public static final String DOCUMENT_DOWNLOAD_BY_ID = "/download/{id}";
	public static final String GET_ALL_DOCUMENTS =  "/document";

	public static final String GET_FEEDBACK = "/feedbacks/{id}";
	public static final String ALL_FEEDBACKS = "/feedbacks";
	public static final String CREATE_FEEDBACK = "/feedbacks/add";
	public static final String UPDATE_FEEDBACK = "/feedbacks/update";
	
	public static final String GET_LECTURER = "/lecturers/{id}";
	public static final String ALL_LECTURERS = "/lecturers";
	public static final String CREATE_LECTURER = "/lecturers/add";
	public static final String UPDATE_LECTURER = "/lecturers/update";
	
	public static final String GET_NOTICE = "/notices/{id}";
	public static final String ALL_NOTICES = "/notices";
	public static final String CREATE_NOTICE = "/notices";
	public static final String UPDATE_NOTICE = "/notices/update";
	
	
}
