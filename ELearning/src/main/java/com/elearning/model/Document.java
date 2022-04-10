package com.elearning.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Document implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8059701789646068604L;

	private Long id;
	private String name;
	private String location;
	private Date createdAt;
	private Date updatedAt;
	private CourseMaterial courseMaterial;
	private Assignment assignment;
	
	private MultipartFile document;

	public Document() {
		super();
	}

	public Document(Long id, String name, String location, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Document(Long id, String name, String location, Date createdAt, Date updatedAt, MultipartFile document) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.document = document;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public MultipartFile getDocument() {
		return document;
	}

	public void setDocument(MultipartFile document) {
		this.document = document;
	}
	

	public CourseMaterial getCourseMaterial() {
		return courseMaterial;
	}

	public void setCourseMaterial(CourseMaterial courseMaterial) {
		this.courseMaterial = courseMaterial;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", name=" + name + ", location=" + location + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

}
