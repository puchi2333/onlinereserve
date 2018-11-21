package com.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.po.Student;
import com.onlinexam.service.admin.StudentService;

@WebServlet(value="/studentAddServlet")
public class StudentAddServlet extends HttpServlet{
	StudentService studentService = new StudentService();  

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("stuName");
		String schoolName = request.getParameter("schoolName");
		int classId = Integer.valueOf(request.getParameter("classId"));
		String born = (request.getParameter("born"));
		int sex = Integer.valueOf(request.getParameter("sex"));
		
		Student student = new Student();
		
		student.setBirthday(born);
		student.setClass_id(classId);
		student.setName(name);
		student.setSchool(schoolName);
		student.setSex(sex);
		
		studentService.addStudent(student);
		
		response.sendRedirect("studentQueryServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		
	}

}
