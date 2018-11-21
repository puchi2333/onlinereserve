package com.onlinexam.service.admin;

import java.util.List;

import com.onlinexam.dao.admin.CourseDao;
import com.onlinexam.po.Course;
import com.onlinexam.po.TeacherCourse;
import com.onlinexam.vo.TeacherCourseView;

public class CourseService implements ICourseService {
	CourseDao courseDao = new CourseDao();

	@Override
	public List<TeacherCourseView> findAll() {
		return courseDao.findAllTeaCourInfo();
		
		
	}

	@Override
	public TeacherCourseView findTeacherCourseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findCourseById(int id) {
		return courseDao.findCourseById(id);
	}

	@Override
	public List<Course> findAllCourses() {
		return courseDao.findAllCourses();
		
	}

	@Override
	public List<Course> findAllCourses(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyTeacherCourse(TeacherCourse tc) {
		courseDao.updateTeacherCourse(tc);

	}

	@Override
	public List<TeacherCourseView> findTeacherCourseByKey(String courseKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTeacherCourse(int tcId) {
		courseDao.deleteTourse(tcId);

	}

	@Override
	public void addCourse(String courseName) {
		courseDao.addCourse(courseName);

	}

	@Override
	public void updateCourse(Course course) {
		courseDao.updateCourse(course);

	}

	@Override
	public void addSchedule(TeacherCourse tc) {
		courseDao.addTeacherCourse(tc);

	}

	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		return courseDao.findCoursesByTeacherId(teaId);
	}

}
