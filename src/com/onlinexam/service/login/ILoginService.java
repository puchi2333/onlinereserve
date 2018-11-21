package com.onlinexam.service.login;

import com.onlinexam.po.Student;
import com.onlinexam.po.Teacher;

public interface ILoginService {

	public Teacher canLogin(Teacher t);
	public Student canLogin(Student t);
}
