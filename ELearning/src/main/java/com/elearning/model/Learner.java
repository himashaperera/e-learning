package com.elearning.model;

import java.util.List;

public class Learner extends Person{

	private Integer numberOfCoursesTaken;
	private List<Course> courseList;
	private List<Assignment> submittedAssignmentList;
	private List<Quiz> attemptedQuizList;
	private List<Feedback> givenFeedbackList;

	public Learner() {
		super();
	}
	
	public Learner(Integer numberOfCoursesTaken) {
		super();
		this.numberOfCoursesTaken = numberOfCoursesTaken;
	}

	public Learner(Long id, String firstName, String lastName, String userName, String password, String email) {
		super(id, firstName, lastName, userName, password, email);
	}
	
	public Learner(Long id, String firstName, String lastName, String userName, String password, String email, Integer numberOfCoursesTaken) {
		super(id, firstName, lastName, userName, password, email);
		this.numberOfCoursesTaken = numberOfCoursesTaken;
	}

	public Learner(Integer numberOfCoursesTaken, List<Course> courseList, List<Assignment> submittedAssignmentList,
			List<Quiz> attemptedQuizList, List<Feedback> givenFeedbackList) {
		super();
		this.numberOfCoursesTaken = numberOfCoursesTaken;
		this.courseList = courseList;
		this.submittedAssignmentList = submittedAssignmentList;
		this.attemptedQuizList = attemptedQuizList;
		this.givenFeedbackList = givenFeedbackList;
	}

	public int getNumberOfCoursesTaken() {
		return numberOfCoursesTaken;
	}

	public void setNumberOfCoursesTaken(Integer numberOfCoursesTaken) {
		this.numberOfCoursesTaken = numberOfCoursesTaken;
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
		return "Learner [numberOfCoursesTaken=" + numberOfCoursesTaken +  "]"  + super.toString();
	}
	
	
	
	
	
	
}
