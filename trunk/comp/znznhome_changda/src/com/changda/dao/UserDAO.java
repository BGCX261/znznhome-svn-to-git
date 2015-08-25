package com.changda.dao;

import java.util.List;

import com.changda.model.User;

public interface UserDAO {
	
	boolean save(User user) ;
	boolean update(User user);
	boolean delete(int id);
	int countBySQL(String count_sql);
	List<User> loadBySQL(String sql);
	User loadByID(int id);
	boolean userExists(String name);
	User checkUser(String name, String password);
}
