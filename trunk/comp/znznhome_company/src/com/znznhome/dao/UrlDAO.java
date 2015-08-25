package com.znznhome.dao;

import java.util.List;

import com.znznhome.model.Url;

public interface UrlDAO {
	
	boolean save(Url url) ;
	boolean update(Url url);
	boolean delete(int id);
	List<Url> loadBySQL(String sql);
	Url loadByID(int id);
}
