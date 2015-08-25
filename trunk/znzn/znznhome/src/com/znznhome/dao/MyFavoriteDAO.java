package com.znznhome.dao;

import java.util.List;

import com.znznhome.model.MyFavorite;

public interface MyFavoriteDAO {
	
	boolean save(MyFavorite myFavorite) ;
	boolean update(MyFavorite myFavorite);
	boolean delete(int id);
	List<MyFavorite> loadBySQL(String sql);
	MyFavorite loadByID(int id);
}
