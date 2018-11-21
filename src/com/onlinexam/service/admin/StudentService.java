package com.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.onlinexam.dao.admin.StudentDao;
import com.onlinexam.po.Student;

public class StudentService implements IStudentService {
	StudentDao sd = new StudentDao();

	@Override
	public void addStudent(Student s) {
		sd.addStudent(s);
}

	@Override
	public void updateStudent(Student s) {
		sd.updateStudent(s);

	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> findAll() {
		return sd.findAll();
	}

	@Override
	public List<Map<String, Object>> findStudentsByName(String name) {
		return sd.findStudentsByName(name);
	}

}
