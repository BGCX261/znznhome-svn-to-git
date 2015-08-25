package com.znznhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.dao.UrlDAO;
import com.znznhome.model.Url;

@Component("urlDAO")
public class UrlDAOImpl implements UrlDAO{

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Url url =(Url)session.load(Url.class, id);
		session.delete(url);
		return true;
	}

	public Url loadByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		Url url = (Url)session.get(Url.class, id);
		return url;
	}

	public List<Url> loadBySQL(String sql) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		List<Url> list = q.addEntity(Url.class).list();
		return list;
	}

	public boolean save(Url url) {
		Session session = sessionFactory.getCurrentSession();
		session.save(url);
		return true;
	}

	public boolean update(Url url) {
		Session session = sessionFactory.getCurrentSession();
		session.update(url);
		return true;
	}

}
