package com.onlinexam.servlet.teacher;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.SysexMessage;

import com.onlinexam.po.Teacher;
import com.onlinexam.service.admin.ClassService;
import com.onlinexam.service.teacher.TestService;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@WebServlet(value = "/testQueryServlet")
public class TestQueryServlet extends HttpServlet {
	private TestService testService = new TestService();
	private ClassService classService = new ClassService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Teacher teacher = (Teacher) req.getSession().getAttribute("user");
		int teaId = -1;
		try {
			teaId = teacher.getId();
		} catch (Exception e) {
			System.out.println("无法获取从session获取ID，尝试从cookies获取");
			Cookie cookies[] = req.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if ("teacherId".equals(cookies[i].getName())) {
						teaId = Integer.valueOf(cookies[i].getValue());
					}
				}
				if (teaId == -1) {
					System.out.println("无法从cookie获取Id");
					resp.sendRedirect("usernotfound.jsp");
				}
			}
		}
		if (teaId == -1) {
			resp.sendRedirect("usernotfound.jsp");
		} else {
			System.out.println(teaId);
			List<Map<String, Object>> testList = testService.findTestsByTeaId(teaId);
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			for (int i = 0; i < testList.size(); i++) {
				String classIds = (String)testList.get(i).get("class_ids");
				Date date = null;
				try {
					date = (Date)testList.get(i).get("end_time");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Date cDate = null;
				try {
					cDate = sdf.parse(sdf.format(new Date()));
					date = sdf.parse(sdf.format(date));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (java.text.ParseException e) {
					e.printStackTrace();
				}
				System.out.println(cDate);
				System.out.println(date);
				if (date.after(cDate)) {
					testList.get(i).put("status","正常点餐");
				} else {
					testList.get(i).put("status","已结束");
					//testList.remove(i);
				}
				String classNames = classService.findClassNamesByIds(classIds);
				testList.get(i).put("classNames", classNames);
			}
			
			req.setAttribute("testsList", testList);
			req.getRequestDispatcher("teacher/tmain.jsp").forward(req, resp);

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
