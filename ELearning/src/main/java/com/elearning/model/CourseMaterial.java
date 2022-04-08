package com.elearning.model;

import java.util.Date;
import java.util.List;

public class CourseMaterial {

	private Long id;
	private String name;
	private Date createdAt;
	private Date updatedAt;
	private Lesson lesson;
	private List<Document> documentList;

	public CourseMaterial() {
		super();
	}

	public CourseMaterial(Long id, String name, Date createdAt, Date updatedAt, Lesson lesson,
			List<Document> documentList) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.lesson = lesson;
		this.documentList = documentList;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public List<Document> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<Document> documentList) {
		this.documentList = documentList;
	}

	@Override
	public String toString() {
		return "CourseMaterial [id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", lesson=" + lesson + ", documentList=" + documentList + "]";
	}

}
