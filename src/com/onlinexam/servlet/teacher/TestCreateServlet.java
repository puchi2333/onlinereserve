package com.onlinexam.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.dao.teacher.TestDao;
import com.onlinexam.po.Teacher;
import com.onlinexam.po.Test;
import com.onlinexam.service.teacher.TestService;

@WebServlet(value="/testCreateServlet")
public class TestCreateServlet  extends HttpServlet{
	
	TestService testService = new TestService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Teacher teacher = (Teacher)req.getSession().getAttribute("user");
		Test test = (Test)req.getSession().getAttribute("test");
		testService.createTest(test);
		req.getRequestDispatcher("/testQueryServlet").forward(req, resp);

	}
	
}
