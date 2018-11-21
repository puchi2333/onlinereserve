package com.onlinexam.servlet.admin;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.po.Student;
import com.onlinexam.po.Teacher;
import com.onlinexam.service.admin.StudentService;

@WebServlet(value="/studentModifyServlet")
public class StudentModifyServlet extends HttpServlet{
	StudentService ss = new StudentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("stuName");
		String schoolName = request.getParameter("schoolName");
		int classId = Integer.valueOf(request.getParameter("classId"));
		String born = (request.getParameter("born"));
		int sex = Integer.valueOf(request.getParameter("sex"));
		
		Student s = new Student();
		s.setId(Integer.valueOf(id));
		s.setName(name);
		s.setClass_id(classId);
		s.setSchool(schoolName);
		s.setBirthday(born);
		s.setSex(sex);
		ss.updateStudent(s);
		request.getRequestDispatcher("/studentQueryServlet").forward(request, response);
	}

}
