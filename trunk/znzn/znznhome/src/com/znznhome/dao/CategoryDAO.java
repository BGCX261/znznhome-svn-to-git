package com.znznhome.dao;

import java.util.List;

import com.znznhome.model.Category;

public interface CategoryDAO {

	public List<Category> getTopCategories();
	public List<Category> getChilds(int id);
	public List<Category> getAllChilds(List<Category> list,int id);
	public List<Category> getAllChilds(List<Category> list,String name);
	boolean save(Category category) ;
	boolean update(Category category);
	boolean delete(int id);
	List<Category> loadBySQL(String sql);
	Category loadByID(int id);
	public boolean updateNewPidCategory(int newPid);
	public boolean updateOldPidCategory(int oldPid);
	public int getIdByEname(String ename);
	public boolean enameExists(String ename);
	public String getEnameByID(int id);
	public List<Category> getAllByNameList(List<String> categoryNames);
}
