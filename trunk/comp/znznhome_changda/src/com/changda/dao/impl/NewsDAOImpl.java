package com.changda.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.changda.dao.NewsDAO;
import com.changda.model.News;
import com.changda.util.HibernateUtil;

public class NewsDAOImpl implements NewsDAO{

	public boolean delete(int id) {
		String sql = "delete from news where id = " + id + ";";
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		q.executeUpdate();
		session.getTransaction().commit();
		return true;
	}

	public News loadByID(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		News news = (News)session.get(News.class, id);
		session.getTransaction().commit();
		return news;
	}

	public List<News> loadBySQL(String sql) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		List<News> list = q.addEntity(News.class).list();
		session.getTransaction().commit();
		return list;
	}

	public boolean save(News news) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(news);
		session.getTransaction().commit();
		return true;
	}

	public boolean update(News news) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.update(news);
		session.getTransaction().commit();
		return true;
	}

}
