package com.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.onlinexam.po.Teacher;
import com.onlinexam.util.DBUtil;

public class TeacherDao implements ITeacherDao{
	private DBUtil dbUtil = new DBUtil();

	@Override
	public List<Teacher> findAllTeacherByInfo(String name) {
		String sql = "select * from teacher";
		if (!"".equals(name) ) {
			sql += " where name like" + " \"%" + name + "%\"";
		}
		System.out.println(sql);
		List teaList = new ArrayList();
		try {
			teaList = dbUtil.getQueryList(sql);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return teaList;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		String sql = "insert into teacher(name,classify) values(?,?)";
		try {
			dbUtil.execute(sql,new Object[] {teacher.getName(),teacher.getClassify()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldId) {
		if (null == teacher) {
			String sql = "delete from teacher where id=?";
			try {
				dbUtil.execute(sql,new Object[] {oldId});
			} catch (Exception e) {
				e.printStackTrace();
				return ;
			}
			return ;
		}
		String sql = "update teacher set name=?, classify=? where id =?";
		try {
			dbUtil.execute(sql, new Object[] {teacher.getName(), teacher.getClassify(), teacher.getId()});
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
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
