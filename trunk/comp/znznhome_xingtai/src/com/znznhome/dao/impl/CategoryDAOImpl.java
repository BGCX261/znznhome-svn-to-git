package com.znznhome.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.dao.CategoryDAO;
import com.znznhome.model.Category;
import com.znznhome.model.Member;

@Component("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private SessionFactory sessionFactory;

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 拿到所有的根类别
	 * 
	 * @return
	 */
	public List<Category> getTopCategories() {
		String sql = "select * from znzn_category where grade=1";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		List<Category> list = q.addEntity(Category.class).list();
		return list;
	}

	/**
	 * 拿到某一个目录的下一级子类别
	 * 
	 * @return
	 */
	public List<Category> getChilds(int id) {
		String sql = "select * from znzn_category where pid=" + id;
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		List<Category> list = q.addEntity(Category.class).list();
		return list;
	}

	/**
	 * 拿到某一个目录的所有子类别
	 * 
	 * @return
	 */
	public List<Category> getAllChilds(List<Category> list, int id) {
		String sql = "select * from znzn_category where pid=" + id;
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		List<Category> l = q.addEntity(Category.class).list();
		for (Iterator it = l.iterator(); it.hasNext();) {
			Category c = (Category) it.next();
			list.add(c);
			if (c.getIsleaf() == 0) {
				getAllChilds(list, c.getId());
			}
		}
		return list;
	}

	public List<Category> getAllChilds(List<Category> list, String name) {
		String sql = "select * from znzn_category where name='" + name + "'";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		Category category = (Category) q.addEntity(Category.class)
				.uniqueResult();
		int id = category.getId();
		return getAllChilds(list,id);
	}

	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Category category = (Category)session.load(Category.class, id);
		int isleaf = category.getIsleaf();
		int pid = category.getPid();
		if (isleaf == 0) return false;
		session.delete(category);
		//父节点如果变成叶子，则需更新isleaf；
		List<Category> list = new ArrayList<Category>();
		list = getAllChilds(list, pid);
		if (list.size() == 0 && pid != 0){
			Category pCategory = (Category)session.load(Category.class, pid);
			pCategory.setIsleaf(1);
			session.update(pCategory);
		}
		return true;
	}

	public Category loadByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		Category category = (Category) session.get(Category.class, id);
		return category;
	}

	public List<Category> loadBySQL(String sql) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		List<Category> list = q.addEntity(Category.class).list();
		return list;
	}

	public boolean save(Category category) {
		
		//如果ename重名，则不保存
		String ename = category.getEname();
		if(enameExists(ename)) {
			return false;
		}
		
		Session session = sessionFactory.getCurrentSession();
		int pid = category.getPid();
		int grade = 0;
		if (pid == 0) {
			grade = 1;
		} else {
			Category category_parent = (Category) session.get(Category.class,
					pid);
			// 将父节点设为非叶子节点
			category_parent.setIsleaf(0);
			// 子节点的grade为父节点级别+1
			grade = category_parent.getGrade() + 1;
			// 更新父节点
			session.update(category_parent);
		}
		category.setGrade(grade);
		session.save(category);
		return true;
	}

	public boolean update(Category category) {
		
		Session session = sessionFactory.getCurrentSession();
		int isleaf = category.getIsleaf();
		int pid = category.getPid();
		session.update(category);
		List<Category> list = new ArrayList<Category>();
		list = getAllChilds(list, pid);
		if (list.size() == 0){
			Category pCategory = (Category)session.load(Category.class, pid);
			pCategory.setIsleaf(1);
			session.update(pCategory);
		}
		return true;
	}

	public boolean updateNewPidCategory(int newPid) {
		Session session = sessionFactory.getCurrentSession();
		Category category = (Category)session.load(Category.class, newPid);
		category.setIsleaf(0);
		session.update(category);
		return true;
	}
	
	public boolean updateOldPidCategory(int oldPid) {
		Session session = sessionFactory.getCurrentSession();
		List<Category> clList = new ArrayList<Category>();
		clList = getAllChilds(clList, oldPid);
		if (clList.size() == 0) {
			Category category = (Category)session.load(Category.class, oldPid);
			category.setIsleaf(1);
			session.update(category);
		}
		return true;
	}

	public int getIdByEname(String ename) {
		String sql = "select * from znzn_category where ename=?";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		q.setString(0, ename);
		Category category = (Category) q.addEntity(Category.class)
				.uniqueResult();
		//如果查不到，返回一个错误ID，前台程序进行处理
		if(category == null) {
			return -100;
		}
		return category.getId();
	}

	public boolean enameExists(String ename) {
		if(ename == null || ename.trim().equals("")) return false;
		String sql = "select * from znzn_category where ename=?" ;
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setString(0, ename);
		List<Category> list = sqlQuery.addEntity(Category.class).list();
		if(list.size() > 0) return true;
		return false;
	}

	public String getEnameByID(int id) {
		String sql = "select * from znzn_category where id=?";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		q.setInteger(0, id);
		Category category = (Category) q.addEntity(Category.class)
				.uniqueResult();
		//如果查不到，返回一个错误ID，前台程序进行处理
		if(category == null) {
			return null;
		}
		return category.getEname();
	}

}
