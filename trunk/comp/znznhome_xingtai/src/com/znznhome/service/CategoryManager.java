package com.znznhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.znznhome.dao.CategoryDAO;
import com.znznhome.model.Category;

@Component("categoryManager")
public class CategoryManager {
	
	private CategoryDAO categoryDAO;
	@Resource(name="categoryDAO")
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	public int getIdByEname(String ename) {
		return this.categoryDAO.getIdByEname(ename) ;
	}
	
	/**
	 * 拿到所有的根类别
	 * @return
	 */
	public List<Category> getTopCategories() {
		return categoryDAO.getTopCategories();
	}
	
	/**
	 * 拿到某一个目录的下一级子类别
	 * @return
	 */
	public List<Category> getChilds(int id) {
		return categoryDAO.getChilds(id);
	}
	
	/**
	 * 拿到某一个目录的所有子类别
	 * @return
	 */
	public List<Category> getAllChilds(List<Category> list,int id) {
		return categoryDAO.getAllChilds(list, id);
	}
	
	/**
	 * 拿到某一个目录的所有子类别
	 * @return
	 */
	public List<Category> getAllChilds(List<Category> list, String name) {
		return categoryDAO.getAllChilds(list, name);
	}
	
	public boolean save(Category category) {
		return categoryDAO.save(category);
	}

	public List<Category> loadBySQL(String sql) {
		return categoryDAO.loadBySQL(sql);
	}

	public boolean delete(int id) {
		return categoryDAO.delete(id);
	}
	
	public Category loadByID(int id) {
		return categoryDAO.loadByID(id);
	}
	
	public boolean update(Category category) {
		return categoryDAO.update(category);
	}

	public boolean updateNewPidCategory(int newPid) {
		return categoryDAO.updateNewPidCategory(newPid);
		
	}

	public boolean updateOldPidCategory(int oldPid) {
		return categoryDAO.updateOldPidCategory(oldPid);
	}

	public boolean enameExists(String ename) {
		return categoryDAO.enameExists(ename);
	}

	public String getEnameByID(int id) {
		return categoryDAO.getEnameByID(id);
	}
}
