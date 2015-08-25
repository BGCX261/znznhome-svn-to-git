package com.znznhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.dao.NoticeHelpDAO;
import com.znznhome.model.MyFavorite;
import com.znznhome.model.NoticeHelp;

@Component("noticeHelpDAO")
public class NoticeHelpDAOImpl implements NoticeHelpDAO{

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
		NoticeHelp noticeHelp =(NoticeHelp)session.load(NoticeHelp.class, id);
		session.delete(noticeHelp);
		return true;
	}

	public NoticeHelp loadByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		NoticeHelp noticeHelp = (NoticeHelp)session.get(NoticeHelp.class, id);
		
		return noticeHelp;
	}

	public List<NoticeHelp> loadBySQL(String sql) {
		Session session = sessionFactory.getCurrentSession();
		
		SQLQuery q = session.createSQLQuery(sql);
		List<NoticeHelp> list = q.addEntity(NoticeHelp.class).list();
		
		return list;
	}

	public boolean save(NoticeHelp noticeHelp) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(noticeHelp);
		
		return true;
	}

	public boolean update(NoticeHelp noticeHelp) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(noticeHelp);
		
		return true;
	}

}
