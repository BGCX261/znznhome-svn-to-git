package com.znznhome.dao;

import java.util.List;

import com.znznhome.model.Message;

public interface MessageDAO {
	
	boolean save(Message message) ;
	boolean update(Message message);
	boolean delete(int id);
	List<Message> loadBySQL(String sql);
	Message loadByID(int id);
}
