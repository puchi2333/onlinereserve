package com.onlinexam.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.po.Question;
import com.onlinexam.service.teacher.QuestionService;

@WebServlet(value="/questionModifyServlet")
public class QuestionModifyServlet extends HttpServlet {
	private QuestionService questionService = new QuestionService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(req.getParameter("id"));
		questionService.deleteQuestion(id);
		resp.sendRedirect("questionQueryServlet");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String ca = req.getParameter("choiceA");
		String cb = req.getParameter("choiceB");
		String cc = req.getParameter("choiceC");
		String cd = req.getParameter("choiceD");
		int id =Integer.valueOf(req.getParameter("id"));
		
		int courseId = Integer.valueOf(req.getParameter("courseId"));
		int questionType = 1;
		String quesName = req.getParameter("questionName");
		String anString = req.getParameter("ans");
		Question q = new Question(courseId, questionType, quesName, ca, ca, cc, cd, anString);
		q.setId(id);
		questionService.updateQuestionInfo(q);
		resp.sendRedirect("questionQueryServlet");
	}

}
