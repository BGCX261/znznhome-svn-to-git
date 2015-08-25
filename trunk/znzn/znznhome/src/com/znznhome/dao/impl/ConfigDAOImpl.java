package com.znznhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.dao.ConfigDAO;
import com.znznhome.model.Config;

@Component("configDAO")
public class ConfigDAOImpl implements ConfigDAO{

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
		Config config =(Config)session.load(Config.class, id);
		session.delete(config);
		return true;
	}

	public Config loadByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		Config config = (Config)session.get(Config.class, id);
		return config;
	}

	public List<Config> loadBySQL(String sql) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		List<Config> list = q.addEntity(Config.class).list();
		return list;
	}
	
	public boolean save(Config config) {
		Session session = sessionFactory.getCurrentSession();
		session.save(config);
		return true;
	}

	public boolean update(Config config) {
		Session session = sessionFactory.getCurrentSession();
		session.update(config);
		return true;
	}

}
