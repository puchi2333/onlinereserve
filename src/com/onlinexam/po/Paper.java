package com.onlinexam.po;

import java.util.Date;

public class Paper {
   
	private int id;
    private String test_time;
    private int course_id;
    private int test_id;
    private double score;
    private String wrong_que_ids;
    private String wrong_anses;
    private int student_id;
    private Date sub_time;
    private int visited;
    private int teacher_id;
    public  Paper() {
		
	}
    public Paper(Integer test_id, String test_time, int course_id, double score, String wrong_que_ids, String wrong_anses, int student_id,
			Date sub_time,int visited, int teacher_id) {
		
    		this.test_id = test_id;
		this.test_time = test_time;
		this.course_id = course_id;
		this.score = score;
		this.wrong_que_ids = wrong_que_ids;
		this.wrong_anses = wrong_anses;
		this.student_id = student_id;
		this.sub_time = sub_time;
		this.visited = visited;
		this.teacher_id = teacher_id;
	}
    
	public int getVisited() {
		return visited;
	}
	public void setVisited(int visited) {
		this.visited = visited;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTest_time() {
		return test_time;
	}
	public void setTest_time(String test_time) {
		this.test_time = test_time;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getWrong_que_ids() {
		return wrong_que_ids;
	}
	public void setWrong_que_ids(String wrong_que_ids) {
		this.wrong_que_ids = wrong_que_ids;
	}
	public String getWrong_anses() {
		return wrong_anses;
	}
	public void setWrong_anses(String wrong_anses) {
		this.wrong_anses = wrong_anses;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public Date getSub_time() {
		return sub_time;
	}
	public void setSub_time(Date sub_time) {
		this.sub_time = sub_time;
	}
	public int getTest_id() {
		return test_id;
	}
	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

    
}