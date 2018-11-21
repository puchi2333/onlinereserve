package com.onlinexam.po;

public class Course {
	private int id;
	private String course_id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Course(String name, int id) {
		this.id=id;
		this.name = name;
	}
	public Course() {}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
