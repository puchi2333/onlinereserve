package com.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.onlinexam.po.Test;
import com.onlinexam.util.DBUtil;

public class TestDao implements ITestDao {
	DBUtil dbUtil = new DBUtil();
	
	@Override
	public void createTest(Test t) {
		String sql = "INSERT into test(test.teacher_id,test.name,test.test_time,test.score,test.question_ids,test.end_time,test.course_id,test.class_ids)VALUES(?,?,?,?,?,?,?,?)";
		try {
			dbUtil.execute(sql, new Object[] {t.getTeacher_id(), t.getName(),t.getTest_time(),t.getScore(),t.getQuestion_ids(),
					t.getEnd_time(),t.getCourse_id(),t.getClass_ids()});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		String sql = "SELECT t.question_ids, c.`name` as courseName, t.id,t.name,t.end_time"
				+ " ,t.test_time,t.score,class_ids from test t,course c WHERE t.course_id=c.id and teacher_id=?";
		try {
			return dbUtil.getQueryList(sql, new Object[] {teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<>();
		}
		
	}

	@Override
	public Map<String, Object> findTestById(int id, int teaId) {
		String sql = "SELECT t.test_time,t.`name` as tName,c.`name` as cName, t.class_ids,t.end_time ,t.question_ids FROM test t, course c WHERE t.course_id = c.id AND t.teacher_id= ? AND t.id= ?";
		try {
			return dbUtil.getObject(sql, new Object[] {teaId,id});
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap<>();
		}
		
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		String sql = "SELECT t.*,GROUP_CONCAT(sc.name) as classNames,cs.`name` as courseName FROM  student s,test t,course cs,class sc WHERE t.id=?  AND FIND_IN_SET(sc.id,t.class_ids)  AND s.id = ? AND cs.id = t.course_id";
		try {
			return dbUtil.getObject(sql, new Object[] {testid, studentid});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new HashMap<>();
		}
	}
	@Override
	public Map<String, Object> findStudentPapersById(int studentid, int testid) {
		String sql = "SELECT t.*,GROUP_CONCAT(sc.name) as classNames,cs.`name` as courseName FROM papers p, student s,test t,course cs,class sc WHERE p.id=? and t.id=p.test_id AND FIND_IN_SET(sc.id,t.class_ids)  AND s.id = ? AND cs.id = t.course_id";
		try {
			return dbUtil.getObject(sql, new Object[] {testid, studentid});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new HashMap<>();
		}
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id, String currData) {
		String sql = "SELECT t.question_ids,t.course_id, t.id,cs.`name` as courseName,t.name as testName, "
				+ " t.test_time as testTime,t.end_time as endDate from course cs, test t,"
				+ " class c,student s WHERE s.id=? AND find_in_set(s.class_id,t.class_ids) AND s.class_id=c.id  AND t.course_id=cs.id AND t.end_time > ?";
		try {
			return dbUtil.getQueryList(sql, new Object[] {id,currData});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<>();
		}

		
	}



}
