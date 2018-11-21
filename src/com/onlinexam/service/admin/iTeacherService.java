package com.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.onlinexam.po.Teacher;

public interface iTeacherService {		

	/**
	 * 此方法用来查询符合条件的教师信息
	 * @param name 教师姓名
	 * @return 教师集合List，集合里都是Teacher对象
	 */
	public List<Teacher> findTeachers(String name);
	public void addTeacher(Teacher teacher);
	public void updateTeacher(Teacher teacher,int oldid);
	public Map<String,Object> findTeacherInfo(int id) ;
	
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId);
}
