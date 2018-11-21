package com.onlinexam.po;

public class StuClass {
    private int id;
    private String name;
    private String classify;
    public StuClass() {}

    public StuClass(int id, String name, String classify) {
		super();
		this.id=id;
		this.name = name;
		this.classify = classify;
	}

	public StuClass(String name, String classify) {
		super();
		this.name = name;
		this.classify = classify;
	}

	@Override
	public String toString() {
		return "StuClass [id=" + id + ", name=" + name + ", classify=" + classify + "]";
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

}
