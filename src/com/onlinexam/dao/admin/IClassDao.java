package com.onlinexam.dao.admin;

import java.util.List;
import java.util.Map;

import com.onlinexam.po.StuClass;

public interface IClassDao {

	public List findAllStuClassInfo();

	public Map<String, Object> findStuClassById(int classId) ;

	public void addStuClassById(StuClass sc) ;

	public void updateStuClassById(StuClass sc) ;
	
	public String findClassNamesByIds(String ids);
	
	public void delClassById(int id);

	/**
	 * 根据当前的教师id查询属于这个教师的班级
	 * @param teaId
	 * @return
	 */
	public List<StuClass> findStuClassesByTeacherId(int teaId);
	

}
