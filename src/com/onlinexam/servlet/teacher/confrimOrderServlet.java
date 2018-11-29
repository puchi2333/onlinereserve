/**
 * 
 */
package com.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.service.teacher.PaperService;
import com.onlinexam.util.DBUtil;


/**
 * @author zheng
 *
 */
@WebServlet("/confirmOrderServlet")
public class confrimOrderServlet extends HttpServlet {
	DBUtil dbUtil = new DBUtil();
	PaperService ps = new PaperService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int paperId = Integer.valueOf( req.getParameter("testId"));
		Map<String,Object> hs = ps.getPaperById(paperId);
		String sql = "UPDATE papers SET visited=1 where id=?";
		
		try {
			dbUtil.execute(sql, new Object[] {paperId});
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect("acceptedOrderServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * 
	 */

}
