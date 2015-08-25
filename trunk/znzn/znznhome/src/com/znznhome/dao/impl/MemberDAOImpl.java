package com.znznhome.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.dao.MemberDAO;
import com.znznhome.model.Member;

@Component("memberDAO")
public class MemberDAOImpl implements MemberDAO{

	private SessionFactory sessionFactory;
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Member checkMember(String name, String password) {
		String sql = "select * from znzn_member where name=? and password=? and purview < 100;";
		Member m = new Member();
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery= session.createSQLQuery(sql);
		sqlQuery.setString(0, name);
		sqlQuery.setString(1, password);
		List<Member> list = sqlQuery.addEntity(Member.class).list();
		if (list.size() > 0){
			m = (Member) list.get(0);
			return m;
		}
		return null;
	}

	public int countBySQL(String count_sql) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(count_sql);
		int ret = ((BigInteger)q.list().get(0)).intValue();
		return ret;
	}

	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Member member =(Member)session.load(Member.class, id);
		session.delete(member);
		return true;
	}

	public Member loadByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		Member member = (Member)session.get(Member.class, id);
		return member;
	}

	public List<Member> loadBySQL(String sql) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		List<Member> list = q.addEntity(Member.class).list();
		return list;
	}

	public boolean save(Member member) {
		Session session = sessionFactory.getCurrentSession();
		session.save(member);
		return true;
	}

	public boolean update(Member member) {
		Session session = sessionFactory.getCurrentSession();
		session.update(member);
		return true;
	}

	public boolean memberExists(String name) {
		String sql = "select * from znzn_member where name=?;" ;
		boolean b = false;
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setString(0, name);
		List<Member> list = sqlQuery.addEntity(Member.class).list();
		if(list.size() > 0)
		b = true;
		return b;
	}

}
