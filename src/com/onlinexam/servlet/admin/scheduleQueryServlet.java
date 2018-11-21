package com.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.service.admin.ClassService;
import com.onlinexam.service.admin.CourseService;
import com.onlinexam.service.admin.TeacherService;
import com.onlinexam.vo.TeacherCourseView;

@WebServlet(value="/scheduleQueryServlet")
public class scheduleQueryServlet extends HttpServlet {
	CourseService courseService = new CourseService(); 
	ClassService classService = new ClassService();
	TeacherService teacherService = new TeacherService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List tcList = courseService.findAll();
		List classList = classService.findAll();
		List courseList = courseService.findAllCourses();
		List teacherList = teacherService.findTeachers("");
		
		req.setAttribute("teacherList", teacherList);
		req.setAttribute("scheduleList", tcList);
		req.setAttribute("classList", classList);
		req.setAttribute("courseList", courseList);
		req.getRequestDispatcher("manager/schedulemanage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	

}
