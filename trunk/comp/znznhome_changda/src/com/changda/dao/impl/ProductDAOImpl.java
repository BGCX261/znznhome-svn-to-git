package com.changda.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.changda.dao.ProductDAO;
import com.changda.model.Product;
import com.changda.util.HibernateUtil;

public class ProductDAOImpl implements ProductDAO{

	public boolean delete(int id) {
		String sql = "delete from product where id = " + id + ";";
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		q.executeUpdate();
		session.getTransaction().commit();
		return true;
	}

	public Product loadByID(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Product product = (Product)session.get(Product.class, id);
		session.getTransaction().commit();
		return product;
	}

	public List<Product> loadBySQL(String sql) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		List<Product> list = q.addEntity(Product.class).list();
		session.getTransaction().commit();
		return list;
	}

	public boolean save(Product product) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		return true;
	}

	public boolean update(Product product) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.update(product);
		session.getTransaction().commit();
		return true;
	}

}
