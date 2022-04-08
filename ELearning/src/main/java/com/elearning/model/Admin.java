package com.elearning.model;

public class Admin extends Person{

	public Admin() {
		super();
	}

	public Admin(Long id, String firstName, String lastName, String userName, String password, String email) {
		super(id, firstName, lastName, userName, password, email);
	}

	@Override
	public String toString() {
		return "Admin" + super.toString();
	}

	
	
}
