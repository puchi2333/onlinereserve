package com.onlinexam.dao.teacher;

import java.util.List;
import java.util.Map;

import com.onlinexam.po.Paper;

public interface IPapersDao {
	
	public int save(Paper  paper);
	
	public List getPaperByStudentId(int studentId,int testId);
	
	public List getPaperByStudentId(int studentId,String courseName);
	public Map<String, Object> getPaperById(int paperId);
	
	public List getDataCharts(int testId);
	
	//所有的班级平级成绩。
	public List getPaperCompare(int teaId);

	List getPaperByTeacherId(int studentId, int testId);

	List getPaperByTeacherId(int studentId);
}
