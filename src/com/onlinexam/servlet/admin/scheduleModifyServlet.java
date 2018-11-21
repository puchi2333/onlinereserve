package com.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.po.TeacherCourse;
import com.onlinexam.service.admin.CourseService;


@WebServlet(value="/scheduleModifyServlet")
public class scheduleModifyServlet extends HttpServlet {
	CourseService courseService = new CourseService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		courseService.deleteTeacherCourse(id);
		req.getRequestDispatcher("/scheduleQueryServlet").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int hiddenId = Integer.valueOf(req.getParameter("hiddenId"));
		int courseId = Integer.valueOf(req.getParameter("courseId"));
		int classId = Integer.valueOf(req.getParameter("classId"));
		
		
		TeacherCourse tc = new TeacherCourse();
		tc.setId(hiddenId);
		tc.setClass_id(classId);
		tc.setCourse_id(courseId);
		
		courseService.modifyTeacherCourse(tc);
		
		req.getRequestDispatcher("/scheduleQueryServlet").forward(req, resp);
		
	}
	
}
