package com.znznhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.dao.MessageDAO;
import com.znznhome.model.Message;

@Component("messageDAO")
public class MessageDAOImpl implements MessageDAO{

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
		Message message =(Message)session.load(Message.class, id);
		session.delete(message);
		return true;
	}

	public Message loadByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Message message = (Message)session.get(Message.class, id);
		
		return message;
	}

	public List<Message> loadBySQL(String sql) {
		Session session = sessionFactory.getCurrentSession();
		
		SQLQuery q = session.createSQLQuery(sql);
		List<Message> list = q.addEntity(Message.class).list();
		
		return list;
	}

	public boolean save(Message message) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(message);
		
		return true;
	}

	public boolean update(Message message) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(message);
		
		return true;
	}

}
