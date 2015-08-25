package com.znznhome.dao;

import java.util.List;

import com.znznhome.model.Url;

public interface UrlDAO {
	
	boolean save(Url url) ;
	boolean update(Url url);
	boolean delete(long id);
	boolean executQuery(String sql);
	List<Url> loadBySQL(String sql);
	Url loadByID(long id);
}
