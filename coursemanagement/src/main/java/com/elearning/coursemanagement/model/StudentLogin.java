package com.elearning.coursemanagement.model;

public class StudentLogin {

	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public StudentLogin() {
		super();
	}
	@Override
	public String toString() {
		return "StudentLogin [name=" + name + ", password=" + password + "]";
	}
	
	
}
