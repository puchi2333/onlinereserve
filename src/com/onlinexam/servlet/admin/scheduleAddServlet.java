package com.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.po.TeacherCourse;
import com.onlinexam.service.admin.CourseService;

@WebServlet(value="/scheduleAddServlet")
public class scheduleAddServlet extends HttpServlet{
	private CourseService courseService = new CourseService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int teacherId = Integer.valueOf(req.getParameter("teacherId"));
		int classId = Integer.valueOf(req.getParameter("classId"));
		int courseId = Integer.valueOf(req.getParameter("courseId"));
		
		TeacherCourse tc = new TeacherCourse();
		tc.setTeacher_id(teacherId);
		tc.setClass_id(classId);
		tc.setCourse_id(courseId);
		
		courseService.addSchedule(tc);
		
		resp.sendRedirect("scheduleQueryServlet");
	}

}
