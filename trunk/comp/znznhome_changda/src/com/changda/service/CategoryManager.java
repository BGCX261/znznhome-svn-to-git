package com.changda.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.changda.dao.CategoryDAO;
import com.changda.dao.impl.CategoryDAOImpl;
import com.changda.model.Category;
import com.changda.util.HibernateUtil;

public class CategoryManager {
	
	private static CategoryManager categoryManager = null;
	private CategoryDAO categoryDAO = new CategoryDAOImpl();
	private CategoryManager(){
	}
	
	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}
	
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	public static synchronized  CategoryManager getInstance() {
		if(categoryManager == null) categoryManager = new CategoryManager();
		return categoryManager;
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
	public List<Category> getAllChilds(List<Category> list, int id) {
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

}
