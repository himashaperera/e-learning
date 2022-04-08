package com.elearning.model;

public class QuizType {

	private Long id;
	private String name;

	public QuizType() {
		super();
	}

	public QuizType(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "QuizType [id=" + id + ", name=" + name + "]";
	}

}
