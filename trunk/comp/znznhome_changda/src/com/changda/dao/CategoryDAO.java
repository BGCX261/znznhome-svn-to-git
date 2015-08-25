package com.changda.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.changda.model.Category;
import com.changda.util.HibernateUtil;

public interface CategoryDAO {

	public List<Category> getTopCategories();
	public List<Category> getChilds(int id);
	public List<Category> getAllChilds(List<Category> list, int id);
	public List<Category> getAllChilds(List<Category> list, String name);
	boolean save(Category category) ;
	boolean update(Category category);
	boolean delete(int id);
	List<Category> loadBySQL(String sql);
	Category loadByID(int id);
}
