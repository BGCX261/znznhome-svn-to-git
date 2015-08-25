package com.znznhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.znznhome.dao.ChatMessageKeywordsDAO;
import com.znznhome.dao.impl.ChatMessageKeywordsDAOImpl;
import com.znznhome.model.ChatMessageKeywords;

@Component("chatMessageKeywordsManager")
public class ChatMessageKeywordsManager {
	
	private ChatMessageKeywordsDAO chatMessageKeywordsDAO;
	
	public ChatMessageKeywordsDAO getChatMessageKeywordsDAO() {
		return chatMessageKeywordsDAO;
	}
	
	@Resource(name="chatMessageKeywordsDAO")
	public void setChatMessageKeywordsDAO(ChatMessageKeywordsDAO chatMessageKeywordsDAO) {
		this.chatMessageKeywordsDAO = chatMessageKeywordsDAO;
	}

	public boolean save(ChatMessageKeywords chatMessageKeywords) {
		return chatMessageKeywordsDAO.save(chatMessageKeywords);
	}

	public List<ChatMessageKeywords> loadBySQL(String sql) {
		return chatMessageKeywordsDAO.loadBySQL(sql);
	}

	public boolean delete(int id) {
		return chatMessageKeywordsDAO.delete(id);
	}
	
	public ChatMessageKeywords loadByID(int id) {
		return chatMessageKeywordsDAO.loadByID(id);
	}
	
	public boolean update(ChatMessageKeywords chatMessageKeywords) {
		return chatMessageKeywordsDAO.update(chatMessageKeywords);
	}

}
