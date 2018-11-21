package com.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.po.StuClass;
import com.onlinexam.service.admin.ClassService;
import com.onlinexam.service.admin.IClassService;
import com.onlinexam.util.Department;

/**
 * Servlet implementation class ClassModifyServlet
 */
@WebServlet("/stuClassModifyServlet")
public class ClassModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IClassService classService = new ClassService();
	
    public ClassModifyServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Map<String, Object> stuMap = classService.findStuClassById(Integer.valueOf(id));
		request.setAttribute("stuClass", stuMap);
		request.setAttribute("deptList", Department.values());
		request.getRequestDispatcher("manager/stuclassmodify.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.valueOf(request.getParameter("classId"));
		String name = request.getParameter("stuname");
		String deptName = request.getParameter("classify");
		
		StuClass sc = new StuClass(id, name, deptName);
		System.out.println(sc);
		classService.updateStuClass(sc);
		request.getRequestDispatcher("/stuClassQueryServlet").forward(request, response);;
	}

}
