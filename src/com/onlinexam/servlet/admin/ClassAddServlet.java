package com.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.po.StuClass;
import com.onlinexam.service.admin.ClassService;
import com.onlinexam.util.Department;

@SuppressWarnings("serial")
@WebServlet(value = "/stuClassAddServlet")
public class ClassAddServlet extends HttpServlet{

	private ClassService classService = new ClassService();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		req.setAttribute("deptList", Department.values());
		
		
		req.getRequestDispatcher("manager/classadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String className = req.getParameter("stuname");
		String dept = req.getParameter("classify");		
	
		
		
		StuClass c = new StuClass(className, dept);
		classService.addstuClass(c);	
		req.getRequestDispatcher("/stuClassQueryServlet").forward(req, resp);
	}
	
	
}
