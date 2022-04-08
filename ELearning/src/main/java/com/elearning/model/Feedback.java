package com.elearning.model;

public class Feedback {

	private Long id;
	private String content;
	private Course course;
	private Learner learner;

	public Feedback() {
		super();
	}

	public Feedback(Long id, String content, Course course, Learner learner) {
		super();
		this.id = id;
		this.content = content;
		this.course = course;
		this.learner = learner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Learner getLearner() {
		return learner;
	}

	public void setLearner(Learner learner) {
		this.learner = learner;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", content=" + content + ", course=" + course + ", learner=" + learner + "]";
	}

}
