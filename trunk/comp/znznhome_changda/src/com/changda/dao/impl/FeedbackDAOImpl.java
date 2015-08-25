package com.changda.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.changda.dao.FeedbackDAO;
import com.changda.model.Feedback;
import com.changda.util.HibernateUtil;

public class FeedbackDAOImpl implements FeedbackDAO{

	public boolean delete(int id) {
		String sql = "delete from feedback where id = " + id + ";";
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		q.executeUpdate();
		session.getTransaction().commit();
		return true;
	}

	public Feedback loadByID(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Feedback feedback = (Feedback)session.get(Feedback.class, id);
		session.getTransaction().commit();
		return feedback;
	}

	public List<Feedback> loadBySQL(String sql) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		List<Feedback> list = q.addEntity(Feedback.class).list();
		session.getTransaction().commit();
		return list;
	}

	public boolean save(Feedback feedback) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(feedback);
		session.getTransaction().commit();
		return true;
	}

	public boolean update(Feedback feedback) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.update(feedback);
		session.getTransaction().commit();
		return true;
	}

}
