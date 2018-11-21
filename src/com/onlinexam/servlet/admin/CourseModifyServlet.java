package com.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.po.Course;
import com.onlinexam.po.StuClass;
import com.onlinexam.service.admin.CourseService;

@WebServlet(value="/courseModifyServlet")
public class CourseModifyServlet extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		
		new CourseService().updateCourse(new Course(name,id));
		request.getRequestDispatcher("/courseQueryServlet").forward(request, response);;
	}

}
