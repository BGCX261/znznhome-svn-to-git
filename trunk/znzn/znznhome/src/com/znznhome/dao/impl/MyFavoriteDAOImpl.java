package com.znznhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.dao.MyFavoriteDAO;
import com.znznhome.model.MyFavorite;

@Component("myFavoriteDAO")
public class MyFavoriteDAOImpl implements MyFavoriteDAO{

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
		MyFavorite myFavorite = (MyFavorite)session.load(MyFavorite.class, id);
		session.delete(myFavorite);
		return true;
		
	}

	public List<MyFavorite> getAllChilds(List<MyFavorite> list, int pid) {
		return null;
	}

	public MyFavorite loadByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		MyFavorite myFavorite = (MyFavorite)session.get(MyFavorite.class, id);
		
		return myFavorite;
	}

	public List<MyFavorite> loadBySQL(String sql) {
		Session session = sessionFactory.getCurrentSession();
		
		SQLQuery q = session.createSQLQuery(sql);
		List<MyFavorite> list = q.addEntity(MyFavorite.class).list();
		
		return list;
	}

	public boolean save(MyFavorite myFavorite) {
		return true;
	}

	public boolean update(MyFavorite myFavorite) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(myFavorite);
		
		return true;
	}

}
