package com.znznhome.dao;

import java.util.List;

import com.znznhome.model.MessageDefault;

public interface MessageDefaultDAO {
	
	boolean save(MessageDefault messageCategoryDefault) ;
	boolean update(MessageDefault messageCategoryDefault);
	boolean delete(int id);
	List<MessageDefault> loadBySQL(String sql);
	MessageDefault loadByID(int id);
}
