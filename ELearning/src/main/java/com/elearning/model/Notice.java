package com.elearning.model;

public class Notice {
	
	private Long id;
	private String title;
	private String description;
	private String postedBy;
	private String position;
	private String postDate;
	
	public Notice() {
		super();
	}

	public Notice(Long id, String title, String description, String postedBy, String position, String subDate) {
		
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.postedBy = postedBy;
		this.position = position;
		this.postDate = subDate;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPostedBy() {
		return postedBy;
	}


	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", description=" + description + ", postedBy=" + postedBy
				+ ", position=" + position + ", postDate=" + postDate + "]";
	}



}
