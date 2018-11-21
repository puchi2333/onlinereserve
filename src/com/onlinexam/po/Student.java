package com.onlinexam.po;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class Student {
    private  int id;
    private  String student_id;
    private int sex;
    private String birthday;
    private String classify;
    private String pwd;
    private String name;
    private String school;
    private int class_id;

    public void setId(int id) {
        this.id = id;
    }

    public Student() {
		super();
	}

	public Student(String student_id, String pwd, String name) {
		super();
		this.student_id = student_id;
		this.pwd = pwd;
		this.name = name;
	}

	public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public int getSex() {
        return sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getClassify() {
        return classify;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
}
