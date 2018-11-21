package com.onlinexam.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.po.Teacher;
import com.onlinexam.service.admin.TeacherService;


@SuppressWarnings("serial")
@WebServlet(value="/teacherModifyServlet")
public class TeacherModifyServlet extends HttpServlet {
	TeacherService teacherService = new TeacherService();
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.valueOf(request.getParameter("teaid"));
		String name = request.getParameter("stuname");
		String deptName = request.getParameter("classify");
		
		Teacher teacher = new Teacher();
		teacher.setId(Integer.valueOf(id));
		teacher.setName(name);
		teacher.setClassify(deptName);
		teacherService.updateTeacher(teacher, 0);
		request.getRequestDispatcher("/teacherQueryServlet").forward(request, response);
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}
	

}
