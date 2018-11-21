package com.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.onlinexam.po.Student;
import com.onlinexam.util.DBUtil;

public class StudentDao implements IStudentDao {
	DBUtil db = new DBUtil();
	@Override
	public void addStudent(Student s) {
		String sql = "insert into student(sex,name,school,class_id,birthday) Values(?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] {s.getSex(),s.getName(),s.getSchool(),s.getClass_id(),s.getBirthday()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(Student s) {
		if ("".equals(s.getName())) {
			String sql = "delete from student where id=?";
			try {
				db.execute(sql,new Object[] {s.getId()});
				return ;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		String sql = "update student set name=?, school=?,birthday=?,class_id=?,sex=? where id = ?";
		try {
			db.execute(sql, new Object[] {s.getName(), s.getSchool(), s.getBirthday(),s.getClass_id(),s.getSex(), s.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> findAll() {
		String sql = "select s.id,s.name,s.school,c.classify,s.sex,s.birthday,s.class_id,c.name as class_name from student s,class c where s.class_id=c.id and s.id < 1000";
		try {
			return (List<Map<String, Object>>)db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> findStudentsByName(String name) {
		String sql = "select s.id,s.name,s.school,c.classify,s.sex,s.birthday,s.class_id,c.name as "
				+ "class_name from student s,class c where s.class_id=c.id and s.name like '%" + name + "%' and s.id < 1000";
		try {
			return (List)db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

}
