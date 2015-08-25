package com.znznhome.dao;

import java.util.List;

import com.znznhome.model.ChatMessageKeywords;

public interface ChatMessageKeywordsDAO {
	
	boolean save(ChatMessageKeywords chatMessageKeywords) ;
	boolean update(ChatMessageKeywords chatMessageKeywords);
	boolean delete(int id);
	List<ChatMessageKeywords> loadBySQL(String sql);
	ChatMessageKeywords loadByID(int id);
}
