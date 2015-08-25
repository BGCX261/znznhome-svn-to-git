package com.znznhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.znznhome.dao.MyFavoriteDAO;
import com.znznhome.model.MyFavorite;

@Component("myFavoriteManager")
public class MyFavoriteManager {
	
	private MyFavoriteDAO myFavoriteDAO;
	
	public MyFavoriteDAO getMyFavoriteDAO() {
		return myFavoriteDAO;
	}
	
	@Resource(name="myFavoriteDAO")
	public void setMyFavoriteDAO(MyFavoriteDAO myFavoriteDAO) {
		this.myFavoriteDAO = myFavoriteDAO;
	}
	
	public boolean save(MyFavorite myFavorite) {
		return myFavoriteDAO.save(myFavorite);
	}

	public List<MyFavorite> loadBySQL(String sql) {
		return myFavoriteDAO.loadBySQL(sql);
	}

	public boolean delete(int id) {
		return myFavoriteDAO.delete(id);
	}
	
	public MyFavorite loadByID(int id) {
		return myFavoriteDAO.loadByID(id);
	}
	
	public boolean update(MyFavorite myFavorite) {
		return myFavoriteDAO.update(myFavorite);
	}

}
