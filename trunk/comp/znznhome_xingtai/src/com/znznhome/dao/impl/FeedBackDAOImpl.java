package com.znznhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.dao.FeedBackDAO;
import com.znznhome.model.FeedBack;

@Component("feedBackDAO")
public class FeedBackDAOImpl implements FeedBackDAO{

	private SessionFactory sessionFactory;

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		FeedBack feedBack =(FeedBack)session.load(FeedBack.class, id);
		session.delete(feedBack);
		return true;
	}

	public FeedBack loadByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		FeedBack feedBack = (FeedBack)session.get(FeedBack.class, id);
		return feedBack;
	}

	public List<FeedBack> loadBySQL(String sql) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		List<FeedBack> list = q.addEntity(FeedBack.class).list();
		return list;
	}

	public boolean save(FeedBack feedBack) {
		Session session = sessionFactory.getCurrentSession();
		session.save(feedBack);
		return true;
	}

	public boolean update(FeedBack feedBack) {
		Session session = sessionFactory.getCurrentSession();
		session.update(feedBack);
		return true;
	}

}
