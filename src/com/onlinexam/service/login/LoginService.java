package com.onlinexam.service.login;

import com.onlinexam.dao.login.LoginDao;
import com.onlinexam.po.Student;
import com.onlinexam.po.Teacher;

public class LoginService implements ILoginService {
	private LoginDao loginDao = new LoginDao();

	@Override
	public Teacher canLogin(Teacher t) {
		return loginDao.canLogin(t);
		
	}

	@Override
	public Student canLogin(Student s) {
		return loginDao.canLogin(s);
	}

}
