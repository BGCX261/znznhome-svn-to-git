package com.znznhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.znznhome.dao.ChatMessageDAO;
import com.znznhome.dao.impl.ChatMessageDAOImpl;
import com.znznhome.model.ChatMessage;

@Component("chatMessageManager")
public class ChatMessageManager {
	
	private ChatMessageDAO chatMessageDAO;

	public ChatMessageDAO getChatMessageDAO() {
		return chatMessageDAO;
	}
	
	@Resource(name="chatMessageDAO")
	public void setChatMessageDAO(ChatMessageDAO chatMessageDAO) {
		this.chatMessageDAO = chatMessageDAO;
	}
	
	public boolean save(ChatMessage chatMessage) {
		return chatMessageDAO.save(chatMessage);
	}

	public List<ChatMessage> loadBySQL(String sql) {
		return chatMessageDAO.loadBySQL(sql);
	}

	public boolean delete(int id) {
		return chatMessageDAO.delete(id);
	}
	
	public ChatMessage loadByID(int id) {
		return chatMessageDAO.loadByID(id);
	}
	
	public boolean update(ChatMessage chatMessage) {
		return chatMessageDAO.update(chatMessage);
	}

}
