package com.onlinexam.service.teacher;

import java.util.List;
import java.util.Map;

import com.onlinexam.dao.teacher.TestDao;
import com.onlinexam.po.Test;

public class TestService implements ITestService {

	TestDao testDao = new TestDao();
	@Override
	public void createTest(Test t) {
		testDao.createTest(t);
	}

	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		return testDao.findTestsByTeaId(teaId);
	}

	@Override
	public Map<String, Object> findTestById(int id, int teaId) {
		return testDao.findTestById(id, teaId);
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		return testDao.findStudentTestsById(studentid, testid);
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id, String currData) {
		return testDao.getTestByStudent(id, currData);
	}

}
