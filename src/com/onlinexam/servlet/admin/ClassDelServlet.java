package com.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.service.admin.ClassService;


@WebServlet("/stuClassDelServlet")
public class ClassDelServlet extends HttpServlet{
	private ClassService classService = new ClassService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.valueOf(req.getParameter("id"));
		classService.delClassById(id);
		req.getRequestDispatcher("/stuClassQueryServlet").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
