package com.znznhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.dao.MessageDefaultDAO;
import com.znznhome.model.Message;
import com.znznhome.model.MessageDefault;

@Component("messageDefaultDAO")
public class MessageDefaultDAOImpl implements MessageDefaultDAO{

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
		MessageDefault messageCategoryDefault =(MessageDefault)session.load(MessageDefault.class, id);
		session.delete(messageCategoryDefault);
		return true;
	}

	public MessageDefault loadByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		MessageDefault messageCategoryDefault = (MessageDefault)session.get(MessageDefault.class, id);
		
		return messageCategoryDefault;
	}

	public List<MessageDefault> loadBySQL(String sql) {
		Session session = sessionFactory.getCurrentSession();
		
		SQLQuery q = session.createSQLQuery(sql);
		List<MessageDefault> list = q.addEntity(MessageDefault.class).list();
		
		return list;
	}

	public boolean save(MessageDefault messageCategoryDefault) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(messageCategoryDefault);
		
		return true;
	}

	public boolean update(MessageDefault messageCategoryDefault) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(messageCategoryDefault);
		
		return true;
	}

}
