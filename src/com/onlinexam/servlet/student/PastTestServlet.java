package com.onlinexam.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.po.Student;
import com.onlinexam.service.teacher.PaperService;

@WebServlet(value="/pastTestServlet")
public class PastTestServlet extends HttpServlet {

	PaperService paperService = new PaperService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Student student = (Student)req.getSession().getAttribute("user");
		int studentId = student.getId();
		List paperList = paperService.getPaperByTeacherId(studentId);
		req.setAttribute("paperList", paperList);
		req.getRequestDispatcher("student/history.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
