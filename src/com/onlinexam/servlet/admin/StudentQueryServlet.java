package com.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.service.admin.ClassService;
import com.onlinexam.service.admin.StudentService;
import com.onlinexam.util.Department;

@SuppressWarnings("serial")

@WebServlet(value="/studentQueryServlet")
public class StudentQueryServlet extends HttpServlet{
	StudentService ss = new StudentService();
	ClassService cs = new ClassService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List stuList = ss.findAll();
		List classList = cs.findAll();
		String name = req.getParameter("name");
		
		if(name != null && !"".equals(name)) {
			stuList = ss.findStudentsByName(name);
		}
		
		req.setAttribute("stuList", stuList);
		req.setAttribute("classList", classList);
		
		req.getRequestDispatcher("manager/studentmanage.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
