package com.mindtree.student.dto;

public class College {
	
	private Long college_id;
	
	private String name;
	
	private Long noOfStudents;

	public Long getCollege_id() {
		return college_id;
	}

	public void setCollege_id(Long college_id) {
		this.college_id = college_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(Long noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

}
