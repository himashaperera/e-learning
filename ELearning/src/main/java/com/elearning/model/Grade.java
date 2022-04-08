package com.elearning.model;

public class Grade {

	private Long id;
	private Integer marks;
	private GradeType gradeType;

	public Grade() {
		super();
	}

	public Grade(Long id, Integer marks, GradeType gradeType) {
		super();
		this.id = id;
		this.marks = marks;
		this.gradeType = gradeType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public GradeType getGradeType() {
		return gradeType;
	}

	public void setGradeType(GradeType gradeType) {
		this.gradeType = gradeType;
	}

	@Override
	public String toString() {
		return "Grade [id=" + id + ", marks=" + marks + ", gradeType=" + gradeType + "]";
	}

}
