package com.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.dao.admin.CourseDao;
import com.onlinexam.service.admin.CourseService;
import com.onlinexam.util.Department;

@WebServlet(value="/courseQueryServlet")
public class CourseQueryServlet extends HttpServlet{
	CourseService courseService = new CourseService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List courseList = courseService.findAllCourses();
//		System.out.println(classList.get(0).toString());s
		request.setAttribute("classlist", courseList);
		request.setAttribute("deptList", Department.values());
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		request.getRequestDispatcher("manager/coursemanage.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
