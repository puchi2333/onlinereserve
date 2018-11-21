package com.onlinexam.dao.admin;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.onlinexam.po.StuClass;
import com.onlinexam.util.DBUtil;

public class ClassDao implements IClassDao{
	
	private DBUtil dbUtil = new DBUtil(); 
	

	
	@SuppressWarnings("rawtypes")
	@Override
	public List findAllStuClassInfo() {
		
		String sql = "select * from class";
		List classList = new ArrayList();		
		try {
			classList = dbUtil.getQueryList(StuClass.class, sql ,new Object[] {});
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
		return classList;
	}

	@Override
	public Map<String, Object> findStuClassById(int classId) {
		String sql = "select * from class where id=?";
		Map<String, Object> stuMap = new HashMap<String, Object>();
		
		try {
			stuMap = dbUtil.getObject(sql, new Object[] {classId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			stuMap = new HashMap<String, Object>();
			
		}
		return stuMap;
	}

	@Override
	public void addStuClassById(StuClass sc) {
		String sql = "insert into class(name,classify) values(?,?)";
		String aString = null;
		try {
			aString = URLEncoder.encode (sc.getClassify(), "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			dbUtil.execute(sql, new Object[] {sc.getName(),URLDecoder.decode(aString,"UTF-8")});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateStuClassById(StuClass sc) {
		String sql = "update class set name=?,classify=? where id=?";
		try {
			dbUtil.execute(sql, new Object[] {sc.getName(),sc.getClassify(),sc.getId()});
		} catch (Exception e) {
			System.out.println(33333333);
			e.printStackTrace();
		}
		
	}

	@Override
	public String findClassNamesByIds(String ids) {
		String sql = "select name from class where id in ( " + ids + " )";
		System.out.println(sql);
		List<Map<String, Object>> nameList = new ArrayList<>(); 
		try {
			nameList = dbUtil.getQueryList(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < nameList.size(); i++) {
			sBuffer.append(nameList.get(i).get("name") + " ");
		}
		return sBuffer.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StuClass> findStuClassesByTeacherId(int teaId) {
		String sql = "SELECT * from class where id in (SELECT class_id from teacher_course WHERE teacher_id=?)";
		
		try {
			return (List)dbUtil.getQueryList(StuClass.class, sql, new Object[] {teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public void delClassById(int id) {
		String sql = "delete from class where id=?";
		try {
			dbUtil.execute(sql, new Object[] {id});
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
	public static void main(String []s) {
		ClassDao sDao = new ClassDao();
		sDao.findClassNamesByIds("1,3,5");
		
		
	}
}
