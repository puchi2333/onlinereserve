package com.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;

import com.onlinexam.po.Course;
import com.onlinexam.po.TeacherCourse;
import com.onlinexam.util.DBUtil;
import com.onlinexam.vo.TeacherCourseView;

public class CourseDao implements ICourseDao {
	
	DBUtil dbUtil = new DBUtil();

	@Override
	public List<TeacherCourseView> findAllTeaCourInfo() {
		List tcvList = new ArrayList<>();
		String sql = "SELECT tc.id tcId, tc.teacher_id,\n" + 
				"t.name teaName,\n" + 
				"tc.course_id,c.name cName,\n" + 
				"tc.class_id ,sc.name scName \n" + 
				"FROM teacher_course as tc, teacher t,course c,class sc where tc.teacher_id=t.id and tc.course_id = c.id and\n" + 
				"tc.class_id=sc.id";
		try {
			tcvList = dbUtil.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tcvList = new ArrayList<>();
		}
		return tcvList;
	}

	@Override
	public Course findCourseByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCourse(String name) {
		String sql = "insert into course(name) values(?)";
		try {
			dbUtil.execute(sql, new Object[] {name});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateCourse(Course course) {
		String sql = "update course set name=? where id=?";
		try {
			dbUtil.execute(sql, new Object[] {course.getName(), course.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Course findCourseById(int id) {
		String sql = "select * from course where id=?";
		try {
			 return (Course) dbUtil.getObject(Course.class, sql, new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Course();
		}
	}

	@Override
	public void addTeacherCourse(TeacherCourse tc) {
		String sql = "insert into teacher_course(teacher_id,course_id,class_id) values(?,?,?)";
		try {
			dbUtil.execute(sql, new Object[] {tc.getTeacher_id(),tc.getCourse_id(),tc.getClass_id()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public TeacherCourseView findTeaCourInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAllCourses() {
		String sql = "select * from course";
		List courseList = new ArrayList<>();
		try {
			courseList = dbUtil.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public List<Course> findAllCoursesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExitByAllIds(TeacherCourse tc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateTeacherCourse(TeacherCourse tc) {
		String sql = "update teacher_course set class_id=? ,course_id=? where id=?";
		try {
			dbUtil.execute(sql, new Object[] {tc.getClass_id(), tc.getCourse_id(), tc.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<TeacherCourseView> findTeaCourInfoByCourseKey(String courseKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTourse(int tcId) {
		String sql = "delete from teacher_course where id=?";
		try {
			dbUtil.execute(sql, new Object[] {tcId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		String sql = "SELECT * from course where id in (select course_id from teacher_course WHERE teacher_id=?)";
		try {
			return (List)dbUtil.getQueryList(Course.class, sql, new Object[] {teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
