package com.changda.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.changda.dao.UserDAO;
import com.changda.model.User;
import com.changda.util.HibernateUtil;


public class UserDAOImpl implements UserDAO{

	public User checkUser(String name, String password) {
		String sql = "select * from user where name='" + name
				+ "' and password='" + password + "';";
		User m = null;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		List<User> list = q.addEntity(User.class).list();
		if (list.size() > 0)
			m = (User) list.get(0);
		session.getTransaction().commit();

		return m;
	}

	public int countBySQL(String count_sql) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(count_sql);
		int ret = ((BigInteger)q.list().get(0)).intValue();
		session.getTransaction().commit();
		return ret;
	}

	public boolean delete(int id) {
		String sql = "delete from user where id = " + id + ";";
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		q.executeUpdate();
		session.getTransaction().commit();
		return true;
	}

	public User loadByID(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		User user = (User)session.get(User.class, id);
		session.getTransaction().commit();
		return user;
	}

	public List<User> loadBySQL(String sql) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		List<User> list = q.addEntity(User.class).list();
		session.getTransaction().commit();
		return list;
	}

	public boolean save(User user) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		return true;
	}

	public boolean update(User user) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		return true;
	}

	public boolean userExists(String name) {
		String sql = "select * from user where name='" + name +"';" ;
		boolean b = false;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		List<User> list = q.addEntity(User.class).list();
		if(list.size() > 0)
		b = true;
		session.getTransaction().commit();
		return b;
	}

}
