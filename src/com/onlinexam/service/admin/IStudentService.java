package com.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.onlinexam.po.Student;

public interface IStudentService { 
	public void addStudent(Student s);
	public void updateStudent(Student s);
	public Student findStudentById(int id);
	public List<Map<String,Object>> findAll();
	
	public List<Map<String,Object>> findStudentsByName(String name);
}
