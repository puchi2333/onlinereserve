package com.onlinexam.servlet.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.po.Question;
import com.onlinexam.po.Student;
import com.onlinexam.po.Teacher;
import com.onlinexam.service.teacher.PaperService;
import com.onlinexam.service.teacher.QuestionService;
import com.onlinexam.service.teacher.TestService;

@WebServlet("/testInfoServlet")
public class TestInfoServlet extends HttpServlet {
	private PaperService paperService = new PaperService();
	private TestService testService = new TestService();
	private QuestionService questionService = new QuestionService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String PaperId = req.getParameter("paperId");
		System.out.println(PaperId);
		Object user = req.getSession().getAttribute("user");
		int userId = 0;
		try {
			Teacher teacher = (Teacher)user;
			userId = teacher.getId();
			} catch(Exception e){
				Student teacher = (Student)user;
				userId = teacher.getId();
			}
		Map<String, Object>testMap = testService.findStudentPapersById(userId, Integer.valueOf(PaperId));
		List<Question> questionList = questionService.findQuestionByIds((String)testMap.get("question_ids"));
		Map paperMap = paperService.getPaperById(Integer.valueOf(PaperId));
		//Map paperMap = (Map<String, Object>)tmpPaperMap.get(0);
		List<Map<String, Object>> mapList = new ArrayList<>();
		String wrongIds = (String)paperMap.get("wrong_que_id");
		String wrongIdsArray[] = wrongIds.split(",");
		String wrongAnsArray[] = ((String)paperMap.get("wrong_ans")).split(",");
		for (Question question : questionList) {
			Map<String, Object>tempMap = new HashMap<>();
			tempMap.put("chA", question.getChoice_A());
			tempMap.put("chB", question.getChoice_B());
			tempMap.put("chC", question.getChoice_C());
			tempMap.put("chD", question.getChoice_D());
			tempMap.put("ans", question.getAns());
			tempMap.put("title", question.getQue_title());
			tempMap.put("id", question.getId());
			boolean flag = false;
			if(!wrongIds.equals("")) 
				for (int i = 0; i < wrongIdsArray.length; i++) {
					if(question.getId() == Integer.valueOf(wrongIdsArray[i])) {
						tempMap.put("myans", wrongAnsArray[i]);
						tempMap.put("color", "red");
						flag = true;
						break;
						}
					else {
						
					}
				}
			if (!flag) {
				tempMap.put("myans", question.getAns());
				tempMap.put("color", "");
			}
			mapList.add(tempMap);
		}
		req.setAttribute("quesList", mapList);
		req.setAttribute("test", testMap);
		req.getRequestDispatcher("student/viewtestinfo.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
}
