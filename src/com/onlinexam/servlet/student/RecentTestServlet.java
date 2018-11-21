package com.onlinexam.servlet.student;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.po.Student;
import com.onlinexam.service.teacher.TestService;

@WebServlet(value="/recentTestServlet")
public class RecentTestServlet extends HttpServlet{
	TestService testService = new TestService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student = (Student)req.getSession().getAttribute("user");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String currData = sdf.format(new Date());
		
		
		List<Map<String, Object>> testList = testService.getTestByStudent(student.getId(), currData);
		
//		for (int i = 0; i < testList.size(); i++) {
//			//System.out.println(testList.get(i).get("question_ids"));
//			if ("".equals(testList.get(i).get("question_ids"))) {
//				testList.remove(i);
//			}
//		}
		
		req.setAttribute("testsList", testList);
		req.setAttribute("user", student);
		
		req.getRequestDispatcher("student/main.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	

}
