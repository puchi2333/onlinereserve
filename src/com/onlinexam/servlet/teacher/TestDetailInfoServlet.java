package com.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.po.Teacher;
import com.onlinexam.service.admin.ClassService;
import com.onlinexam.service.teacher.QuestionService;
import com.onlinexam.service.teacher.TestService;

@WebServlet(value="/testDetailInfoServlet")
public class TestDetailInfoServlet extends HttpServlet {
	
	private TestService testService = new TestService();
	private ClassService classService = new ClassService();
	private QuestionService  questionService = new QuestionService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		int teaId = -1;
		try {
			Teacher teacher = (Teacher) req.getSession().getAttribute("user");
			teaId = teacher.getId();
		} catch (Exception e) {
			teaId = -1;
			resp.sendRedirect("usernotfound.jsp");
			return ;
		} 
		Map<String, Object> map = testService.findTestById(Integer.valueOf(id), teaId);
		String ids = (String)map.get("class_ids");
		String classNames = classService.findClassNamesByIds(ids);
		String question_ids = (String)map.get("question_ids");
		
		List queList = questionService.findQuestionByIds(question_ids);
		
		map.put("classNames", classNames);
		
		req.setAttribute("test",map);
		req.setAttribute("quesList", queList);
		req.getRequestDispatcher("teacher/viewtest.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
}
