package com.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.po.StuClass;
import com.onlinexam.po.Teacher;
import com.onlinexam.service.admin.ClassService;
import com.onlinexam.service.admin.TeacherService;
import com.onlinexam.util.Department;

@SuppressWarnings("serial")
@WebServlet(value = "/teacherAddServlet")
public class TeacherAddServlet extends HttpServlet{

	private TeacherService teacherService = new TeacherService();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("tname");
		String dept = req.getParameter("classify");		
		
		Teacher teacher = new Teacher();
		teacher.setName(name);
		teacher.setClassify(dept);
		teacherService.addTeacher(teacher);
		
		req.getRequestDispatcher("/teacherQueryServlet").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
