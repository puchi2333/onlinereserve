package com.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.po.Teacher;
import com.onlinexam.service.teacher.PaperService;

@WebServlet(value="/papersCompareServlet")
public class PapersCompareServlet extends HttpServlet {
	
	PaperService paperService = new PaperService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Teacher teacher = (Teacher)req.getSession().getAttribute("user");
		List pList = paperService.getPaperCompare(teacher.getId());

		for(Object tempH : pList) {
			HashMap tempc = (HashMap)tempH;
			tempc.remove("deptName");
		}
		System.out.println(pList);
		req.setAttribute("paperList", pList);
		
		req.setAttribute("user", teacher);
		req.getRequestDispatcher("teacher/classpapers.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
