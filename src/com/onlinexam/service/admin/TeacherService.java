package com.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.onlinexam.dao.admin.TeacherDao;
import com.onlinexam.po.Teacher;

public class TeacherService implements iTeacherService{
	private TeacherDao tDao = new TeacherDao(); 
	@Override
	public List<Teacher> findTeachers(String name) {
		
		return tDao.findAllTeacherByInfo(name);
		
	}

	@Override
	public void addTeacher(Teacher teacher) {
		tDao.addTeacher(teacher);
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldid) {
		tDao.updateTeacher(teacher, oldid);
		
	}

	@Override
	public Map<String, Object> findTeacherInfo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId) {
		// TODO Auto-generated method stub
		return null;
	}

}
