package com.changda.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.changda.dao.CategoryDAO;
import com.changda.model.Category;
import com.changda.util.HibernateUtil;

public class CategoryDAOImpl implements CategoryDAO{
	
	/**
	 * 拿到所有的根类别
	 * @return
	 */
	public List<Category> getTopCategories() {
		String sql = "select * from category where grade=1";
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		List<Category> list = q.addEntity(Category.class).list();
		session.getTransaction().commit();
		return list;
	}
	
	/**
	 * 拿到某一个目录的下一级子类别
	 * @return
	 */
	public List<Category> getChilds(int id) {
		String sql = "select * from category where pid=" + id;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		List<Category> list = q.addEntity(Category.class).list();
		session.getTransaction().commit();
		return list;
	}
	
	/**
	 * 拿到某一个目录的所有子类别
	 * @return
	 */
	public List<Category> getAllChilds(List<Category> list, int id) {
		String sql = "select * from category where pid=" + id;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		//Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		List<Category> l = q.addEntity(Category.class).list();
		for(Iterator it = l.iterator(); it.hasNext();) {
			Category c = (Category)it.next();
			list.add(c);
			if(c.getIsleaf() == 0) {
				getAllChilds(list, c.getId());
			}
		}
		session.getTransaction().commit();
		return list;
	}


	public List<Category> getAllChilds(List<Category> list, String name) {
		String sql = "select * from category where name='" + name + "'" ;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		Category category =(Category)q.addEntity(Category.class).uniqueResult();
		int id = category.getId();
		
		return getAllChilds(list, id);
	}

	public boolean delete(int id) {
		String sql = "delete from category where id = " + id + ";";
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		//看看是不是叶子节点，如果不是，不让删除
		Category category = (Category)session.get(Category.class, id);
		int isleaf = category.getIsleaf();
		if (isleaf == 0) return false;
		SQLQuery q = session.createSQLQuery(sql);
		q.executeUpdate();
		session.getTransaction().commit();
		return true;
	}

	public Category loadByID(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Category category = (Category)session.get(Category.class, id);
		session.getTransaction().commit();
		return category;
	}

	public List<Category> loadBySQL(String sql) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		List<Category> list = q.addEntity(Category.class).list();
		session.getTransaction().commit();
		return list;
	}

	public boolean save(Category category) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		int pid = category.getPid();
		int grade = 0;
		if(pid == 0) {
			grade = 1;
		} else {
			Category category_parent = (Category)session.get(Category.class, pid);
			//将父节点设为非叶子节点
			category_parent.setIsleaf(0); 
			//子节点的grade为父节点级别+1
			grade = category_parent.getGrade() + 1;
			//更新父节点
			session.update(category_parent);
		}
		category.setGrade(grade);
		session.save(category);
		session.getTransaction().commit();
		return true;
	}

	public boolean update(Category category) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.update(category);
		session.getTransaction().commit();
		return true;
	}

}
