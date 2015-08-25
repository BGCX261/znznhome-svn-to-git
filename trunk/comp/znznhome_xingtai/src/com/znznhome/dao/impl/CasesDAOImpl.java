package com.znznhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.dao.CasesDAO;
import com.znznhome.model.Cases;

@Component("casesDAO")
public class CasesDAOImpl implements CasesDAO{
	private SessionFactory sessionFactory;

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Cases cases =(Cases)session.load(Cases.class, id);
		session.delete(cases);
		return true;
	}

	public Cases loadByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		Cases cases = (Cases)session.get(Cases.class, id);
		return cases;
	}

	public List<Cases> loadBySQL(String sql) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		List<Cases> list = q.addEntity(Cases.class).list();
		return list;
	}

	public boolean save(Cases cases) {
		Session session = sessionFactory.getCurrentSession();
		session.save(cases);
		return true;
	}

	public boolean update(Cases cases) {
		Session session = sessionFactory.getCurrentSession();
		session.update(cases);
		return true;
	}

}
