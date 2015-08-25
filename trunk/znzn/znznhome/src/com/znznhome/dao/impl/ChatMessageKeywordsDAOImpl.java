package com.znznhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.dao.ChatMessageKeywordsDAO;
import com.znznhome.model.ChatMessage;
import com.znznhome.model.ChatMessageKeywords;

@Component("chatMessageKeywordsDAO")
public class ChatMessageKeywordsDAOImpl implements ChatMessageKeywordsDAO{

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
		ChatMessageKeywords chatMessageKeywords =(ChatMessageKeywords)session.load(ChatMessageKeywords.class, id);
		session.delete(chatMessageKeywords);
		return true;
	}

	public ChatMessageKeywords loadByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		ChatMessageKeywords chatMessageKeywords = (ChatMessageKeywords)session.get(ChatMessageKeywords.class, id);
		
		return chatMessageKeywords;
	}

	public List<ChatMessageKeywords> loadBySQL(String sql) {
		Session session = sessionFactory.getCurrentSession();
		
		SQLQuery q = session.createSQLQuery(sql);
		List<ChatMessageKeywords> list = q.addEntity(ChatMessageKeywords.class).list();
		
		return list;
	}

	public boolean save(ChatMessageKeywords chatMessageKeywords) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(chatMessageKeywords);
		
		return true;
	}

	public boolean update(ChatMessageKeywords chatMessageKeywords) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(chatMessageKeywords);
		
		return true;
	}

}
