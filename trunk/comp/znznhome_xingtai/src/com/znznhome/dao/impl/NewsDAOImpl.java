package com.znznhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.dao.NewsDAO;
import com.znznhome.model.Category;
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
	public News loadTopic() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select * from znzn_news where topscore = 1 order by createtime desc limit 0, 1";
		SQLQuery q = session.createSQLQuery(sql);
		List<News> list = q.addEntity(News.class).list();
		if (list.size() < 1){
			return null;
		}
		return list.get(0);
	}
	public News loadByCategoryEname(String ename) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select * from znzn_category where ename = '" + ename + "' limit 0, 1";
		SQLQuery q = session.createSQLQuery(sql);
		List<Category> list = q.addEntity(Category.class).list();
		if (list.size() < 1){
			return null;
		}
		Category category = list.get(0);
		int id = category.getId();
		String sql_news = "select * from znzn_news where categoryid = " + id + " order by createtime desc limit 0, 1";
		SQLQuery q_news = session.createSQLQuery(sql_news);
		List<News> list_news = q_news.addEntity(News.class).list();
		if (list_news.size() < 1){
			return null;
		}
		return list_news.get(0);
	}

}
