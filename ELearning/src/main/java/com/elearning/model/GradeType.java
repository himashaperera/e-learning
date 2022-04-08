package com.elearning.model;

public class GradeType {

	private Long id;
	private String name;

	public GradeType() {
		super();
	}

	public GradeType(Long id, String name) {
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
		return "GradeType [id=" + id + ", name=" + name + "]";
	}

}
