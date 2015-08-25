package com.znznhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.dao.JobDAO;
import com.znznhome.model.Job;

@Component("jobDAO")
public class JobDAOImpl implements JobDAO{
	private SessionFactory sessionFactory;

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Job job =(Job)session.load(Job.class, id);
		session.delete(job);
		return true;
	}

	public Job loadByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		Job job = (Job)session.get(Job.class, id);
		return job;
	}

	public List<Job> loadBySQL(String sql) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		List<Job> list = q.addEntity(Job.class).list();
		return list;
	}

	public boolean save(Job job) {
		Session session = sessionFactory.getCurrentSession();
		session.save(job);
		return true;
	}

	public boolean update(Job job) {
		Session session = sessionFactory.getCurrentSession();
		session.update(job);
		return true;
	}

}
