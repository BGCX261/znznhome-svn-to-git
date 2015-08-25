package com.znznhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.dao.CoolJokeDAO;
import com.znznhome.model.ChatMessageKeywords;
import com.znznhome.model.CoolJoke;
import com.znznhome.util.HibernateUtil;

@Component("coolJokeDAO")
public class CoolJokeDAOImpl implements CoolJokeDAO{

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
		CoolJoke coolJoke =(CoolJoke)session.load(CoolJoke.class, id);
		session.delete(coolJoke);
		return true;
	}

	public CoolJoke loadByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		CoolJoke coolJoke = (CoolJoke)session.get(CoolJoke.class, id);
		
		return coolJoke;
	}

	public List<CoolJoke> loadBySQL(String sql) {
		Session session = sessionFactory.getCurrentSession();
		
		SQLQuery q = session.createSQLQuery(sql);
		List<CoolJoke> list = q.addEntity(CoolJoke.class).list();
		
		return list;
	}

	public boolean save(CoolJoke coolJoke) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(coolJoke);
		
		return true;
	}

	public boolean update(CoolJoke coolJoke) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(coolJoke);
		
		return true;
	}

}
