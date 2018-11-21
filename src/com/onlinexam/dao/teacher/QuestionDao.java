package com.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.onlinexam.po.Question;
import com.onlinexam.util.DBUtil;

public class QuestionDao implements IQuestionDao {
	private DBUtil dbUtil = new DBUtil();

	@Override
	public List<Map<String, Object>> findAllQuestionInfo(String key, String value) {
		String sql ="select q.id ,q.course_id,q.ans"
				+ ",q.que_title,q.choice_A,q.choice_B, q.choice_C, q.choice_D,"
				+ " q.que_type,c.`name` from"
				+ " questions q, course c where q.course_id = c.id ";
		if(!"".equals(key) && key != null && null != value) {
			if("name".equals(key)) {
				sql += "and name like " + "'%" + value + "%'";
			} else if ("queTitle".equals(key)) {
				sql += "and que_title like " + "'%" + value + "%'";
			}
		}
		
		try {
			 return dbUtil.getQueryList(sql, new Object[] {});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void addQuestion(Question q) {
		String sql = "insert into questions(course_id,que_type,que_title,choice_A,choice_B,choice_C,choice_D,ans)"
				+ "values(?,?,?,?,?,?,?,?)";
		try {
			dbUtil.execute(sql, new Object[] {q.getCourse_id(),q.getQue_type(),q.getQue_title(),q.getChoice_A(),q.getChoice_B(),
					q.getChoice_C(),q.getChoice_D(),q.getAns()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		return null;
	}

	@Override
	public List<Question> findQuestionByIds(String ids) {
		String sql = "SELECT * FROM questions WHERE id in ( " + ids + " )";
		try {
			return (List)dbUtil.getQueryList(Question.class,sql,new Object[] {});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public void updateQuestionInfo(Question q) {
		String sql = "update questions set course_id=?,que_title=?,choice_A=?,choice_B=?,choice_C=?,choice_D=?,ans=? where id=?";
		try {
			dbUtil.execute(sql, new Object[] {q.getCourse_id(),q.getQue_title(),q.getChoice_A(),q.getChoice_B(),
						q.getChoice_C(),q.getChoice_D(),q.getAns(),q.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId ,String exceptIds) {
		
		
		String sql = "SELECT * FROM questions WHERE course_id= ?";
		
		if (!"".equals(exceptIds)) {
			sql += " and id not in (" + exceptIds + ")";
		}
		System.out.println(sql);
		 try {
			return dbUtil.getQueryList(sql, new Object[] {courseId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<>();
		}
		
	}

	@Override
	public void deleteQuestion(int id) {
		String sql = "delete from questions where id=?";
		try {
			dbUtil.execute(sql, new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
