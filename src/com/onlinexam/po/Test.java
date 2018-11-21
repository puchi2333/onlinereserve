package com.onlinexam.po;

import java.util.Date;

public class Test {
    

	private int id;
    private int paper_id;
    private int course_id;
    private Date end_time;
    private int test_time;
    private String question_ids;
    private int teacher_id;
    private String class_ids;
    private double score;
    private String name;

    @Override
	public String toString() {
		return "Test [id=" + id + ", paper_id=" + paper_id + ", course_id=" + course_id + ", end_time=" + end_time
				+ ", test_time=" + test_time + ", question_ids=" + question_ids + ", teacher_id=" + teacher_id
				+ ", class_ids=" + class_ids + ", score=" + score + "]";
	}
    public Test() {
		
	}
    public Test( int teaid, String name, int course_id, Date end_time, int test_time, String question_ids, String class_ids, double score) {
		super();
		this.teacher_id = teaid;
		this.name = name;
		this.course_id = course_id;
		this.end_time = end_time;
		this.test_time = test_time;
		this.question_ids = question_ids;
		this.class_ids = class_ids;
		this.score = score;
	}

	public int getId() {
        return id;
    }

    public int getPaper_id() {
		return paper_id;
	}

	public void setPaper_id(int paper_id) {
		this.paper_id = paper_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public void setId(int id) {
        this.id = id;
    }



    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public int getTest_time() {
        return test_time;
    }

    public void setTest_time(int test_time) {
        this.test_time = test_time;
    }

    public String getQuestion_ids() {
        return question_ids;
    }

    public void setQuestion_ids(String question_ids) {
        this.question_ids = question_ids;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getClass_ids() {
        return class_ids;
    }

    public void setClass_ids(String class_ids) {
        this.class_ids = class_ids;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
