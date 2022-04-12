package com.elearning.model;

import java.io.Serializable;
import java.util.List;

public class Lesson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8587040121212148363L;
	private Long id;
	private String name;
	private String description;
	private String duration;
	private String startDate;
	private String endDate;
	private Course course;
	private List<CourseMaterial> courseMaterialList;
	private List<Assignment> assignmentList;

	public Lesson() {
		super();
	}

	public Lesson(Long id, String name, String description, String duration, String startDate, String endDate, Course course,
			List<CourseMaterial> courseMaterialList) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.startDate = startDate;
		this.endDate = endDate;
		this.course = course;
		this.courseMaterialList = courseMaterialList;
	}

	public Lesson(Long id, String name, String description, String duration, String startDate, String endDate, Course course,
			List<CourseMaterial> courseMaterialList, List<Assignment> assignmentList) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.startDate = startDate;
		this.endDate = endDate;
		this.course = course;
		this.courseMaterialList = courseMaterialList;
		this.assignmentList = assignmentList;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<CourseMaterial> getCourseMaterialList() {
		return courseMaterialList;
	}

	public void setCourseMaterialList(List<CourseMaterial> courseMaterialList) {
		this.courseMaterialList = courseMaterialList;
	}

	public List<Assignment> getAssignmentList() {
		return assignmentList;
	}

	public void setAssignmentList(List<Assignment> assignmentList) {
		this.assignmentList = assignmentList;
	}

	@Override
	public String toString() {
		return "Lesson [id=" + id + ", name=" + name + ", description=" + description + ", duration=" + duration
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", course=" + course + ", courseMaterialList="
				+ courseMaterialList + ", assignmentList=" + assignmentList + "]";
	}

}
