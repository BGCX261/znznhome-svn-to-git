package com.znznhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.dao.ProductDAO;
import com.znznhome.model.Product;


@Component("productDAO")
public class ProductDAOImpl implements ProductDAO{
	private SessionFactory sessionFactory;

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product product =(Product)session.load(Product.class, id);
		session.delete(product);
		return true;
	}

	public Product loadByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product)session.get(Product.class, id);
		return product;
	}

	public List<Product> loadBySQL(String sql) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		List<Product> list = q.addEntity(Product.class).list();
		return list;
	}

	public boolean save(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
		return true;
	}

	public boolean update(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
		return true;
	}

}
