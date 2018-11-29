package com.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.onlinexam.po.Paper;
import com.onlinexam.util.DBUtil;

public class PapersDao implements IPapersDao {

	DBUtil dbUtil = new DBUtil();
	@Override
	public int save(Paper paper) {
		String sql = "INSERT INTO papers(course_id,test_time,score,wrong_que_id,wrong_ans,student_id,test_id,sub_time)"
				+ "Values(?,?,?,?,?,?,?,?)";
		
		try {
			dbUtil.execute(sql, new Object[] {paper.getCourse_id(),paper.getTest_time(),paper.getScore(),paper.getWrong_que_ids(),paper.getWrong_anses(),paper.getStudent_id(),paper.getTest_id(),paper.getSub_time()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public List getPaperByTeacherId(int studentId) {
		//"select p.* c.name as courseName,t.name as testName from papers p , course c,test t where p.student_id=? and p.course_id = c.id and p.test_id = t.id 
		String sql = "select p.* ,c.name as courseName,t.name as testName from papers p , course c,test t where p.student_id=? and p.course_id = c.id and p.test_id = t.id" ;
		try {
			return dbUtil.getQueryList(sql, new Object[] {studentId});
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}
	public List getPaperById(int a,int paperId) {
		String sql = "select * from papers where  id=?";
		try {
			return dbUtil.getQueryList(sql, new Object[] { paperId});
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	@Override
	public List getPaperByStudentId(int studentId, String courseName) {
		String sql = "select p.*, c.name as courseName,t.name as testName from papers p,course c,test t  where student_id=? and p.course_id = c.id and p.test_id = t.id";
		if (courseName != null && !"".equals(courseName)) {
			sql += " and c.name like '%" + courseName + "%'";
		}
		
		try {
			return dbUtil.getQueryList(sql, new Object[] {studentId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public List getPaperCompare(int teaId) {
		String sql = "SELECT " + 
				"c.`name` as className,c.classify as deptName,cs.`name` as courseName ,t.`name` as testName , p.test_id as testId" + 
				",t.end_time as endDate, AVG(p.score) as avgScore " + 
				" " + 
				"FROM class c,course cs, test t, papers p, student s " + 
				"WHERE " + 
				"p.student_id = s.id AND " + 
				"s.class_id = c.id AND " + 
				"p.course_id = cs.id AND " + 
				"p.test_id = t.id AND " + 
				"p.test_id in (SELECT t.id from test as t where t.teacher_id = ?) " + 
				" " + 
				"GROUP BY c.name,t.name " + 
				"ORDER BY testName ";
		
		try {
			return dbUtil.getQueryList(sql, new Object[] {teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<>();
			
		}
	}

	@Override
	public Map<String, Object> getPaperById(int paperId) {
		String sql = "Select * from papers where id = ?";
		try {
			return dbUtil.getObject(sql, new Object[] {paperId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new HashMap<>();
		}
	}

	@Override
	public List getDataCharts(int testId) {
		String sql = "select * from papers where test_id=?";
		try {
			return dbUtil.getQueryList(sql, new Object[] {testId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public List getPaperByTeacherId(int studentId, int testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPaperByStudentId(int studentId, int testId) {
		
		return null;
	}

}
