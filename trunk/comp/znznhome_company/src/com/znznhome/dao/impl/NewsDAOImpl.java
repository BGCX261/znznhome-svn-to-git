package com.znznhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.dao.NewsDAO;
import com.znznhome.model.News;


@Component("newsDAO")
public class NewsDAOImpl implements NewsDAO{
	private SessionFactory sessionFactory;

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		News news =(News)session.load(News.class, id);
		session.delete(news);
		return true;
	}

	public News loadByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		News news = (News)session.get(News.class, id);
		return news;
	}

	public List<News> loadBySQL(String sql) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		List<News> list = q.addEntity(News.class).list();
		return list;
	}

	public boolean save(News news) {
		Session session = sessionFactory.getCurrentSession();
		session.save(news);
		return true;
	}

	public boolean update(News news) {
		Session session = sessionFactory.getCurrentSession();
		session.update(news);
		return true;
	}

}
