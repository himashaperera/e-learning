package com.elearning.model;

import java.util.Date;
import java.util.List;

public class Trainer extends Person {

	private Date joinDate;
	private List<Course> assignedCourseList;

	public Trainer() {
		super();
	}

	public Trainer(Date joinDate) {
		super();
		this.joinDate = joinDate;
	}

	public Trainer(Long id, String firstName, String lastName, String userName, String password, String email) {
		super(id, firstName, lastName, userName, password, email);
	}

	public Trainer(Long id, String firstName, String lastName, String userName, String password, String email,
			Date joinDate) {
		super(id, firstName, lastName, userName, password, email);
		this.joinDate = joinDate;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public List<Course> getAssignedCourseList() {
		return assignedCourseList;
	}

	public void setAssignedCourseList(List<Course> assignedCourseList) {
		this.assignedCourseList = assignedCourseList;
	}

	@Override
	public String toString() {
		return "Trainer [joinDate=" + joinDate + "]" + super.toString();
	}

}
