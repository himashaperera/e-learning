package com.elearning.model;

import java.util.Date;
import java.util.List;

public class Assignment {

	private Long id;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private Date submittedDate;
	private Learner submittedBy;
	private AssignmentType assignmentType;
	private List<Document> document;
	private Grade grade;
	private Lesson lesson;

	public Assignment() {
		super();
	}

	public Assignment(Long id, String name, String description, Date startDate, Date endDate, Date submittedDate,
			Learner submittedBy, AssignmentType assignmentType, List<Document> document, Grade grade, Lesson lesson) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.submittedDate = submittedDate;
		this.submittedBy = submittedBy;
		this.assignmentType = assignmentType;
		this.document = document;
		this.grade = grade;
		this.lesson = lesson;
	}

	public Assignment(String name, String description, Date startDate, Date endDate, AssignmentType assignmentType,
			List<Document> document, Lesson lesson) {
		super();
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.assignmentType = assignmentType;
		this.document = document;
		this.lesson = lesson;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Learner getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(Learner submittedBy) {
		this.submittedBy = submittedBy;
	}

	public AssignmentType getAssignmentType() {
		return assignmentType;
	}

	public void setAssignmentType(AssignmentType assignmentType) {
		this.assignmentType = assignmentType;
	}

	public List<Document> getDocument() {
		return document;
	}

	public void setDocument(List<Document> document) {
		this.document = document;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	@Override
	public String toString() {
		return "Assignment [id=" + id + ", name=" + name + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", submittedDate=" + submittedDate + ", submittedBy=" + submittedBy
				+ ", assignmentType=" + assignmentType + ", document=" + document + ", grade=" + grade + ", lesson="
				+ lesson + "]";
	}

}
