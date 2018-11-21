package com.onlinexam.po;

public class Question {
    private int id;
    private int course_id;
    private int que_type;
    private String que_title;
    private String choice_A;
    private String choice_B;
    private String choice_C;
    private String choice_D;
    private String ans;
    private int is_delete;

    public int getId() {
        return id;
    }

      public Question() {
		// TODO Auto-generated constructor stub
	}
    public Question(int course_id, int que_type, String que_title, String choice_A, String choice_B, String choice_C,
			String choice_D, String ans) {
		super();
		this.course_id = course_id;
		this.que_type = que_type;
		this.que_title = que_title;
		this.choice_A = choice_A;
		this.choice_B = choice_B;
		this.choice_C = choice_C;
		this.choice_D = choice_D;
		this.ans = ans;
	}

	public void setId(int id) {
        this.id = id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getQue_type() {
        return que_type;
    }

    public void setQue_type(int que_type) {
        this.que_type = que_type;
    }

    public String getQue_title() {
        return que_title;
    }

    public void setQue_title(String que_title) {
        this.que_title = que_title;
    }

    public String getChoice_A() {
        return choice_A;
    }

    public void setChoice_A(String choice_A) {
        this.choice_A = choice_A;
    }

    public String getChoice_B() {
        return choice_B;
    }

    public void setChoice_B(String choice_B) {
        this.choice_B = choice_B;
    }

    public String getChoice_C() {
        return choice_C;
    }

    public void setChoice_C(String choice_C) {
        this.choice_C = choice_C;
    }

    public String getChoice_D() {
        return choice_D;
    }

    public void setChoice_D(String choice_D) {
        this.choice_D = choice_D;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }
}
