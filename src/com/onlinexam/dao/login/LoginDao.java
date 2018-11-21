package com.onlinexam.dao.login;

import com.onlinexam.po.Student;
import com.onlinexam.po.Teacher;
import com.onlinexam.util.DBUtil;

public class LoginDao implements ILoginDao {
	private DBUtil dbUtil = new DBUtil();

	@Override
	public Teacher canLogin(Teacher t) {
		String sql = "select * from teacher where login_id = ? and pwd =?";
		try {
			return (Teacher)dbUtil.getObject(Teacher.class, sql, new Object[] {t.getLogin_id(), t.getPwd()});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Student canLogin(Student s) {
		String sql = "select id,name from student where student_id =? and pwd=?";
		try {
			return (Student)dbUtil.getObject(Student.class, sql, new Object[] {s.getStudent_id(),s.getPwd()});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
