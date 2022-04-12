package com.elearning.model;

import java.util.List;

public class Lecturer extends Person{

	private String joinedDate;
	private List<Course> courseList;
	private List<Assignment> submittedAssignmentList;
	private List<Quiz> attemptedQuizList;
	private List<Feedback> givenFeedbackList;

	public Lecturer() {
		super();
	}
	
	public Lecturer(String joinedDate) {
		super();
		this.joinedDate = joinedDate;
	}

	public Lecturer(Long id, String firstName, String lastName, String userName, String password, String email) {
		super(id, firstName, lastName, userName, password, email);
	}
	
	public Lecturer(Long id, String firstName, String lastName, String userName, String password, String email, String joinedDate) {
		super(id, firstName, lastName, userName, password, email);
		this.joinedDate = joinedDate;
	}

	public Lecturer(String joinedDate, List<Course> courseList, List<Assignment> submittedAssignmentList,
			List<Quiz> attemptedQuizList, List<Feedback> givenFeedbackList) {
		super();
		this.joinedDate = joinedDate;
		this.courseList = courseList;
		this.submittedAssignmentList = submittedAssignmentList;
		this.attemptedQuizList = attemptedQuizList;
		this.givenFeedbackList = givenFeedbackList;
	}
	
	//check

	public String getjoinedDate() {
		return joinedDate;
	}

	public void setjoinedDate(String joinedDate) {
		this.joinedDate = joinedDate;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public List<Assignment> getSubmittedAssignmentList() {
		return submittedAssignmentList;
	}

	public void setSubmittedAssignmentList(List<Assignment> submittedAssignmentList) {
		this.submittedAssignmentList = submittedAssignmentList;
	}

	public List<Quiz> getAttemptedQuizList() {
		return attemptedQuizList;
	}

	public void setAttemptedQuizList(List<Quiz> attemptedQuizList) {
		this.attemptedQuizList = attemptedQuizList;
	}

	public List<Feedback> getGivenFeedbackList() {
		return givenFeedbackList;
	}

	public void setGivenFeedbackList(List<Feedback> givenFeedbackList) {
		this.givenFeedbackList = givenFeedbackList;
	}

	@Override
	public String toString() {
		return "Lecturer [joinedDate=" + joinedDate +  "]"  + super.toString();
	}
	
	
	
	
	
	
}
