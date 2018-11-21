package com.onlinexam.servlet.teacher;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinexam.po.Course;
import com.onlinexam.po.Teacher;
import com.onlinexam.po.Test;
import com.onlinexam.service.admin.ClassService;
import com.onlinexam.service.admin.CourseService;
import com.onlinexam.service.teacher.QuestionService;
import com.onlinexam.util.ToolUtil;

@WebServlet(value="/testAddServlet")
public class TestAddServlet extends HttpServlet {
	CourseService courseService = new CourseService();
	ClassService classService = new ClassService();
	
	QuestionService questionService = new QuestionService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Teacher teacher = (Teacher) req.getSession().getAttribute("user");
		int teaId = -1;
		
		try {
			teaId = teacher.getId();
		} catch (Exception e) {
			System.out.println("无法获取从session获取ID，尝试从cookies获取");
			Cookie cookies[] = req.getCookies();
			if(cookies != null) {
				for(int i = 0; i < cookies.length; i ++) {
					if ("teacherId".equals(cookies[i].getName())){
						teaId =Integer.valueOf(cookies[i].getValue());
					}
				}
				if (teaId == -1) {
					resp.sendRedirect("usernotfound.jsp");
				}
			}
		}
		List courseList = courseService.findCoursesByTeacherId(teaId);
		List classList = classService.findStuClassesByTeacherId(teaId);
		
		req.setAttribute("courseList", courseList);
		req.setAttribute("classesList", classList);
		req.getRequestDispatcher("teacher/testadd.jsp").forward(req, resp);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String courseId = req.getParameter("courseid");
		String testName = req.getParameter("testname");
		String endDate = req.getParameter("enddate");
		String sinScorse = req.getParameter("sinscores");
		String sinNum = req.getParameter("sinnum");
		String numTmp = sinNum;
		String testTime = req.getParameter("testtime");
		String classCheck[] = req.getParameterValues("classCheck");
		
//		修改题号
		List<Map<String, Object>> tmpList = new ArrayList<>();
		String deleteIds = "";
		try {
			deleteIds = req.getParameter("changeIds");
			deleteIds = deleteIds.substring(0, deleteIds.length() - 1);
			tmpList = (List<Map<String, Object>>)req.getSession().getAttribute("quelist");
			String ids[] = deleteIds.split(",");
			numTmp = String.valueOf(ids.length);
			for (int i = 0; i < ids.length; i++) {
				String id = ids[i];
				
				for (int ii = 0; ii < tmpList.size();ii++) {
					int tmpid = (int)tmpList.get(ii).get("id");
					if (tmpid == Integer.valueOf(id)) {
						tmpList.remove(ii);
						ii = 0;
					}
				}
				
			}
			
			String existedIds  = questionService.testQuestionIds(tmpList);
			if(!"".equals(existedIds)) {
				deleteIds += "," + existedIds;
			}
			
		} catch (Exception e) {
			deleteIds = "";
			 tmpList = new ArrayList<Map<String,Object>>();
		}
		
		
//		修改题号
		
		String classIds = ToolUtil.arraytoString(classCheck);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.util.Date date = new java.util.Date();
		try {
			date = simpleDateFormat.parse(endDate);
		} catch (ParseException e) {
			
			date = (java.util.Date)req.getSession().getAttribute("time");
			System.out.println("日期解析错误");
		}
		
		List queList = questionService.collectQuestions(Integer.valueOf(courseId), Integer.valueOf(numTmp), deleteIds);
		if (null != deleteIds && !"".equals(deleteIds)) {
			tmpList.addAll(queList);
			queList = tmpList;
		}
		
		
		String queIds = questionService.testQuestionIds(queList);
		
		String classNames = classService.findClassNamesByIds(classIds);
		Course course = courseService.findCourseById(Integer.valueOf(courseId));
		Teacher teacher = (Teacher)req.getSession().getAttribute("user");
		if(teacher == null) {
			resp.sendRedirect("usernotfound.jsp");
		} else {
			int teaId = teacher.getId();
			Test test = new Test(teaId, testName, Integer.valueOf(courseId),date, Integer.valueOf(testTime), queIds, classIds, Double.valueOf(sinScorse));
			
			
			req.getSession().setAttribute("test", test);
			req.getSession().setAttribute("quelist", queList);
			req.getSession().setAttribute("time", date);
			
			req.setAttribute("quesList", queList);
			req.setAttribute("classNames", classNames);
			req.setAttribute("test", test);
			
			req.setAttribute("c", course);
			req.setAttribute("num", sinNum);
			req.setAttribute("classch", classCheck);
			req.getRequestDispatcher("teacher/test.jsp").forward(req, resp);
		}
		
	}

}
