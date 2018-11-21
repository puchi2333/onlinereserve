package com.onlinexam.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.po.Manager;
import com.onlinexam.po.Student;
import com.onlinexam.po.Teacher;
import com.onlinexam.service.login.LoginService;

@WebServlet(value = "/loginServlet")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginService loginService = new LoginService();

	@Override
	protected
	 void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("usernotfound.jsp");
	}

	@Override
	protected
	 void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		System.out.println(username);
		System.out.println(role);
		System.out.println(password);
		if("teacher".equals(role)) {
			Teacher teacher = new Teacher();
			teacher.setLogin_id(username);
			teacher.setPwd(password);
			teacher = loginService.canLogin(teacher);
			
			if(null != teacher) {
				req.getSession().setAttribute("user", teacher);
				Cookie cookie = new Cookie("teacherId", String.valueOf(teacher.getId()));
				resp.addCookie(cookie);
				req.getRequestDispatcher("teacher/tindex.jsp").forward(req, resp);
			} else {
				System.out.println("无法获取教师对象");
				returnLoginError(req, resp);
			}
		} else if("admin".equals(role)){
			if ("admin".equals(username) && "123".equals(password)) {
				req.getSession().setAttribute("user", new Manager());
				 RequestDispatcher dispatcher = req.getRequestDispatcher("manager/mindex.jsp");    // 使用req对象获取RequestDispatcher对象
			     dispatcher.forward(req, resp);
			}else returnLoginError(req, resp);
			
	    } else if ("student".equals(role)) {
			Student student = new Student();
			student.setStudent_id(username);
			student.setPwd(password);
			student = loginService.canLogin(student);
			
			if (null != student) {
				req.getSession().setAttribute("user", student);
				Cookie cookie = new Cookie("studentId", String.valueOf(student.getId()));
				resp.addCookie(cookie);
				RequestDispatcher dispatcher = req.getRequestDispatcher("student/index.jsp");    // 使用req对象获取RequestDispatcher对象
			     dispatcher.forward(req, resp);
			} else returnLoginError(req, resp);
			
		} else {returnLoginError(req, resp);}
	}
	public void returnLoginError(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		String js = "-1";
		out.write(js);
		out.flush();
		out.close();
	}
	
	

}
