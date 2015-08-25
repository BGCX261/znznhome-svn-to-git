package com.znznhome.dao;

import java.util.List;

import com.znznhome.model.ChatMessage;

public interface ChatMessageDAO {
	
	boolean save(ChatMessage chatMessage) ;
	boolean update(ChatMessage chatMessage);
	boolean delete(int id);
	List<ChatMessage> loadBySQL(String sql);
	ChatMessage loadByID(int id);
}
