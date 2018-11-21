package com.onlinexam.service.teacher;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.onlinexam.dao.teacher.QuestionDao;
import com.onlinexam.po.Question;

public class QuestionService implements IQuestionService {
	private QuestionDao questionDao = new QuestionDao();
	
	@Override
	public List<Map<String, Object>> findAll(String key, String value) {
		return questionDao.findAllQuestionInfo(key, value);
	}

	@Override
	public void addQuestion(Question q) {
		questionDao.addQuestion(q);

	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		 return questionDao.findQuestionById(id);
		
	}

	
	@Override
	public void updateQuestionInfo(Question q) {
		questionDao.updateQuestionInfo(q);

	}

	@Override
	public void deleteQuestion(int id) {
		questionDao.deleteQuestion(id);

	}

	@Override
	public List<Map<String, Object>> collectQuestions(int courseId, int num, String exceptIds) {
		List queList = questionDao.findQuestionsByCourseId(courseId, exceptIds);
		
		Collections.shuffle(queList);
		
		if (num >= queList.size()) {
			return queList;
		} else {
			return queList.subList(0, num);
		}
		
	}

	@Override
	public String testQuestionIds(List<Map<String, Object>> list) {
		if (null == list) {
			return "";
		} else {
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < list.size(); i++) {
				Map queMap = list.get(i);
				stringBuffer.append(queMap.get("id"));
				if (i != list.size() - 1) {
					stringBuffer.append(",");
				}
			}
			return stringBuffer.toString();
		}
	}

	@Override
	public List<Question> findQuestionByIds(String ids) {
		return questionDao.findQuestionByIds(ids);
	}

	@Override
	public List getDataChart(int testId) {
		return null;
	}

}
