package com.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.onlinexam.dao.admin.ClassDao;
import com.onlinexam.dao.admin.IClassDao;
import com.onlinexam.po.StuClass;

public class ClassService implements IClassService{
	IClassDao cDao = new ClassDao();

	public void delClassById(int id) {
		cDao.delClassById(id);
	}
	
	@Override
	public List<?> findAll() {
		
		
		return cDao.findAllStuClassInfo();
	}

	@Override
	public void addstuClass(StuClass sc) {
		try {
			cDao.addStuClassById(sc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateStuClass(StuClass sc) {
		cDao.updateStuClassById(sc);
		
	}

	@Override
	public Map<String, Object> findStuClassById(int id) {
		return cDao.findStuClassById(id);
		
	}

	@Override
	public String findClassNamesByIds(String ids) {
		// TODO Auto-generated method stub
		return cDao.findClassNamesByIds(ids);
	}

	@Override
	public List<StuClass> findStuClassesByTeacherId(int teaId) {
		return cDao.findStuClassesByTeacherId(teaId);
	}

}
