package com.changda.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.changda.dao.JobDAO;
import com.changda.model.Job;
import com.changda.util.HibernateUtil;

public class JobDAOImpl implements JobDAO{

	public boolean delete(int id) {
		String sql = "delete from job where id = " + id + ";";
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		q.executeUpdate();
		session.getTransaction().commit();
		return true;
	}

	public Job loadByID(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Job job = (Job)session.get(Job.class, id);
		session.getTransaction().commit();
		return job;
	}

	public List<Job> loadBySQL(String sql) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		List<Job> list = q.addEntity(Job.class).list();
		session.getTransaction().commit();
		return list;
	}

	public boolean save(Job job) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(job);
		session.getTransaction().commit();
		return true;
	}

	public boolean update(Job job) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.update(job);
		session.getTransaction().commit();
		return true;
	}

}
