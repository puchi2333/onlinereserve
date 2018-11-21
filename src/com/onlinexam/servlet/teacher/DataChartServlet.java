package com.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.dao.teacher.PapersDao;
import com.onlinexam.po.Teacher;
import com.onlinexam.service.teacher.TestService;
import com.onlinexam.util.DBUtil;

@WebServlet(value="/dataChartServlet")
public class DataChartServlet extends HttpServlet {
	private PapersDao papersDao = new PapersDao();
	private DBUtil dbUtil = new DBUtil(); 
	private TestService testService = new TestService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Teacher teacher = (Teacher)req.getSession().getAttribute("user");
		
		String id = req.getParameter("id");
		List<Map<String, Object>> paperList = papersDao.getDataCharts(Integer.valueOf(id));
		Map<String, Object> test = testService.findTestById(Integer.valueOf(id), teacher.getId());
		
		String quesIds = (String)test.get("question_ids");
		Map<String, Integer> wrongIds = new HashMap<>();
		
		
		StringBuffer jsonData = new StringBuffer();
		StringBuffer jsonData2 = new StringBuffer();
		jsonData.append("[");
		jsonData2.append("[");
		int limit = 0;
		for (Map<String, Object> object : paperList) {
			if(limit ++ > 30) break;
			String wrongIdsArray[] = ((String)object.get("wrong_que_id")).split(",");
			for (String wrongId : wrongIdsArray) {
				if(wrongIds.containsKey(wrongId)) {
					wrongIds.put(wrongId, wrongIds.get(wrongId) + 1);
				} else {
					wrongIds.put(wrongId, 0);
				}
			}
			String score = String.valueOf(object.get("score"));
			String stuId = String.valueOf(object.get("student_id"));
			jsonData.append("[" + stuId +","+ score + "],");
		}
		jsonData.substring(0, jsonData.length() - 1);
		jsonData.append("]");
		
		int li = 0;
		for (String key : wrongIds.keySet()) {
			if( li ++ > 20) break;
			jsonData2.append("["  +  key + "," + String.valueOf(wrongIds.get(key) + "],"));
		}
		
		jsonData2.substring(0, jsonData2.length() - 1);
		jsonData2.append("]");
		
		req.setAttribute("data", jsonData.toString());
		req.setAttribute("data1", jsonData2.toString());
		req.getRequestDispatcher("teacher/chart.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
