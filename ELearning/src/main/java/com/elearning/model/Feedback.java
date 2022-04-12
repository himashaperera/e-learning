package com.elearning.model;

public class Feedback {

	private Long id;
	private String learner;
	private String course;
	private String content;
	
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(Long id, String learner, String course, String content) {
		super();
		this.id = id;
		this.learner = learner;
		this.course = course;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLearner() {
		return learner;
	}

	public void setLearner(String learner) {
		this.learner = learner;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", learner=" + learner + ", course=" + course + ", content=" + content + "]";
	}
	


}
