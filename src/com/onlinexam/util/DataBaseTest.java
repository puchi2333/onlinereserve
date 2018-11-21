package com.onlinexam.util;

import com.onlinexam.po.Course;
import com.onlinexam.po.Test;


public class DataBaseTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from test where course_id=? and teacher_id=?";
		
		DBUtil db = new DBUtil();
//		Map<String, Object> sourceMap =  db.getObject(sql);
//		Map<String, Object> sourceMap2 = db.getObject(sql, new Object[] {"1","2"});
		
		Test course = (Test)db.getObject(Test.class, sql, new Object[] {"1","2"});
		
//		
		System.out.println(course);

 
		
	}

}
