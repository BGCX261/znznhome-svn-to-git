package com.changda.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.changda.dao.MemberDAO;
import com.changda.model.Member;
import com.changda.util.HibernateUtil;


public class MemberDAOImpl implements MemberDAO{

	public Member checkMember(String name, String password) {
		String sql = "select * from member where name='" + name
				+ "' and password='" + password + "';";
		Member m = new Member();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		List<Member> list = q.addEntity(Member.class).list();
		if (list.size() > 0)
			m = (Member) list.get(0);
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
		String sql = "delete from member where id = " + id + ";";
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		q.executeUpdate();
		session.getTransaction().commit();
		return true;
	}

	public Member loadByID(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Member member = (Member)session.get(Member.class, id);
		session.getTransaction().commit();
		return member;
	}

	public List<Member> loadBySQL(String sql) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		List<Member> list = q.addEntity(Member.class).list();
		session.getTransaction().commit();
		return list;
	}

	public boolean save(Member member) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(member);
		session.getTransaction().commit();
		return true;
	}

	public boolean update(Member member) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.update(member);
		session.getTransaction().commit();
		return true;
	}

	public boolean memberExists(String name) {
		String sql = "select * from member where name='" + name +"';" ;
		boolean b = false;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		SQLQuery q = session.createSQLQuery(sql);
		List<Member> list = q.addEntity(Member.class).list();
		if(list.size() > 0)
		b = true;
		session.getTransaction().commit();
		return b;
	}

}
