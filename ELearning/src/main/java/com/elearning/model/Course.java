package com.elearning.model;

import java.util.List;

public class Course {

	private Long id;
	private String name;
	private String description;
	private String code;
	private Long duration;
	private String startDate;
	private String endDate;
	private Admin createdBy;
	private List<Trainer> trainersList;
	private List<Feedback> feedbackList;
	private List<Learner> learnersList;
	private List<Lesson> lessonList;
	
	
	public Course() {
		super();
	}

	
	public Course(Long id, String name, String description, String code, Long duration, String startDate, String endDate,
			Admin createdBy) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.code = code;
		this.duration = duration;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdBy = createdBy;
	}


	public Course(Long id, String name, String description, String code, Long duration, String startDate, String endDate,
			Admin createdBy, List<Trainer> trainersList, List<Feedback> feedbackList, List<Learner> learnersList,
			List<Lesson> lessonList) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.code = code;
		this.duration = duration;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdBy = createdBy;
		this.trainersList = trainersList;
		this.feedbackList = feedbackList;
		this.learnersList = learnersList;
		this.lessonList = lessonList;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Long getDuration() {
		return duration;
	}


	public void setDuration(Long duration) {
		this.duration = duration;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public Admin getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(Admin createdBy) {
		this.createdBy = createdBy;
	}


	public List<Trainer> getTrainersList() {
		return trainersList;
	}


	public void setTrainersList(List<Trainer> trainersList) {
		this.trainersList = trainersList;
	}


	public List<Feedback> getFeedbackList() {
		return feedbackList;
	}


	public void setFeedbackList(List<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}


	public List<Learner> getLearnersList() {
		return learnersList;
	}


	public void setLearnersList(List<Learner> learnersList) {
		this.learnersList = learnersList;
	}


	public List<Lesson> getLessonList() {
		return lessonList;
	}


	public void setLessonList(List<Lesson> lessonList) {
		this.lessonList = lessonList;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", description=" + description + ", code=" + code + ", duration="
				+ duration + ", startDate=" + startDate + ", endDate=" + endDate + ", createdBy=" + createdBy
				+ ", trainersList=" + trainersList + ", feedbackList=" + feedbackList + ", learnersList=" + learnersList
				+ ", lessonList=" + lessonList + "]";
	}
	
	

}
