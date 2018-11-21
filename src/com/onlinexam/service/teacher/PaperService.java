package com.onlinexam.service.teacher;

import java.util.List;
import java.util.Map;

import com.onlinexam.dao.teacher.PapersDao;
import com.onlinexam.po.Paper;

public class PaperService implements IPaperService{

	PapersDao papersDao = new PapersDao();
	@Override
	public int save(Paper paper) {
		papersDao.save(paper);
		return 0;
	}

	@Override
	public List getPaperByStudentId(int studentId, int testId) {
		return papersDao.getPaperByStudentId(studentId, testId);
	}

	@Override
	public List getPaperByStudentId(int studentId, String courseName) {
		return papersDao.getPaperByStudentId(studentId, courseName);
	}
	public List getPaperByTeacherId(int studentId) {
		return papersDao.getPaperByTeacherId(studentId);
	}

	@Override
	public List getPaperCompare(int teaId) {
		return papersDao.getPaperCompare(teaId);
	}

	@Override
	public Map<String, Object> getPaperById(int paperId) {
		return papersDao.getPaperById(paperId);
	}

}
