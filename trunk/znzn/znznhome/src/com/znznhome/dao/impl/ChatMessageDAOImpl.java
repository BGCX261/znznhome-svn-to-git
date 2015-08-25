package com.znznhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.dao.ChatMessageDAO;
import com.znznhome.model.Category;
import com.znznhome.model.ChatMessage;

@Component("chatMessageDAO")
public class ChatMessageDAOImpl implements ChatMessageDAO{

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
		ChatMessage chatMessage =(ChatMessage)session.load(ChatMessage.class, id);
		session.delete(chatMessage);
		return true;
	}

	public ChatMessage loadByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		ChatMessage chatMessage = (ChatMessage)session.get(ChatMessage.class, id);
		
		return chatMessage;
	}

	public List<ChatMessage> loadBySQL(String sql) {
		Session session = sessionFactory.getCurrentSession();
		
		SQLQuery q = session.createSQLQuery(sql);
		List<ChatMessage> list = q.addEntity(ChatMessage.class).list();
		
		return list;
	}

	public boolean save(ChatMessage chatMessage) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(chatMessage);
		
		return true;
	}

	public boolean update(ChatMessage chatMessage) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(chatMessage);
		
		return true;
	}

}
