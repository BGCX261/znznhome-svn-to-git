package com.changda.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.changda.dao.CasesDAO;
import com.changda.model.Cases;
import com.changda.util.HibernateUtil;

public class CasesDAOImpl implements CasesDAO{

	public boolean delete(int id) {
		String sql = "delete from cases where id = " + id + ";";
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		q.executeUpdate();
		session.getTransaction().commit();
		return true;
	}

	public Cases loadByID(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Cases cases = (Cases)session.get(Cases.class, id);
		session.getTransaction().commit();
		return cases;
	}

	public List<Cases> loadBySQL(String sql) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		List<Cases> list = q.addEntity(Cases.class).list();
		session.getTransaction().commit();
		return list;
	}

	public boolean save(Cases cases) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(cases);
		session.getTransaction().commit();
		return true;
	}

	public boolean update(Cases cases) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.update(cases);
		session.getTransaction().commit();
		return true;
	}

}
