package com.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.service.admin.ClassService;
import com.onlinexam.util.Department;

/**
 * Servlet implementation class ClassQueryServlet
 */
@WebServlet("/stuClassQueryServlet")
public class ClassQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClassService classService =  new ClassService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Noing
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List classList = classService.findAll();
//		System.out.println(classList.get(0).toString());s
		request.setAttribute("classList", classList);
		System.out.println(classList.size());
		request.setAttribute("deptList", Department.values());
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("manager/stuclassmanage_failed.jsp").forward(request, response);
		
	}

	/**
	 * @see Noting
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
