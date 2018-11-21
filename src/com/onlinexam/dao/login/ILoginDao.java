package com.onlinexam.dao.login;

import com.onlinexam.po.Student;
import com.onlinexam.po.Teacher;

public interface ILoginDao {

	public Teacher canLogin(Teacher t);
	
	public Student canLogin(Student s);
}