package com.onlinexam.servlet.teacher;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.po.Student;
import com.onlinexam.po.Teacher;
import com.onlinexam.service.teacher.PaperService;

@WebServlet(value="/acceptedOrderServlet")
public class AcceptedOrderServlet extends HttpServlet{
	PaperService paperService = new PaperService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		

		req.setCharacterEncoding("UTF-8");
		Teacher student = (Teacher)req.getSession().getAttribute("user");
		int studentId = student.getId();
		String courseName = req.getParameter("courseName");
		if(courseName == null) courseName = "";
		List paperList = paperService.getPaperByTeacherId(studentId);
		req.setAttribute("paperList", paperList);
		req.getRequestDispatcher("teacher/postedorder.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
	
}
