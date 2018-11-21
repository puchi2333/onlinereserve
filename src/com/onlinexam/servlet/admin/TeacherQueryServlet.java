package com.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.service.admin.TeacherService;
import com.onlinexam.util.Department;

@WebServlet(value="/teacherQueryServlet")
public class TeacherQueryServlet extends HttpServlet{
	private TeacherService teacherService = new TeacherService(); 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String search_tea = req.getParameter("name");
		if(null == search_tea) search_tea = "";
		List teaList = teacherService.findTeachers(search_tea);
		System.out.println(search_tea);
		req.setAttribute("teaList", teaList);
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/teachermanage.jsp").forward(req, resp);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}
