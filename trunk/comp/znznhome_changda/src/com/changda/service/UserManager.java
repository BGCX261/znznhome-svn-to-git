package com.changda.service;

import java.util.List;

import com.changda.dao.UserDAO;
import com.changda.dao.impl.UserDAOImpl;
import com.changda.model.User;

public class UserManager {
	private static UserManager userManager = null;
	private UserDAO userDAO = new UserDAOImpl();
	private UserManager(){
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public static synchronized  UserManager getInstance() {
		if(userManager == null) userManager = new UserManager();
		return userManager;
	}
	
	public boolean save(User user) {
		if(user.getName() == null || user.getPassword() == null){
			return false;
		}else if (user.getName().trim().equals("") || user.getPassword().trim().equals("")) {
			return false;
		}else if (UserManager.getInstance().userExists(user.getName()) == true) {
			return false;
		}
		return userDAO.save(user);
	}

	public int countBySQL(String count_sql) {
		return userDAO.countBySQL(count_sql);
	}

	public List<User> loadBySQL(String sql) {
		return userDAO.loadBySQL(sql);
	}

	public boolean delete(int id) {
		return userDAO.delete(id);
	}
	
	public User loadByID(int id) {
		return userDAO.loadByID(id);
	}
	
	public boolean update(User user) {
		return userDAO.update(user);
	}
	
	//检查用户名是否存在
	public boolean userExists(String name) {
		return userDAO.userExists(name);
	}

	//登录检测
	public User checkUser(String name, String password) {
		return userDAO.checkUser(name, password);
	}

}
