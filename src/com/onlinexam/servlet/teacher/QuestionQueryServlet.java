package com.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.service.admin.CourseService;
import com.onlinexam.service.teacher.QuestionService;

@WebServlet(value="/questionQueryServlet")
public class QuestionQueryServlet extends HttpServlet {
	private QuestionService questionService = new QuestionService();  
	private CourseService courseService = new CourseService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("selectk");
		String value = req.getParameter("searchName");
		
		List courseList = courseService.findAllCourses();
		
		List<Map<String, Object>> questionList = questionService.findAll(key, value);
		req.setAttribute("queList", questionList);
		req.setAttribute("courseList", courseList);
		req.getRequestDispatcher("teacher/questionmanage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	

}
