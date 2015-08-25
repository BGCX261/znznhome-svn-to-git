package com.znznhome.dao;

import java.util.List;

import com.znznhome.model.Config;

public interface ConfigDAO {
	
	boolean save(Config config) ;
	boolean update(Config config);
	boolean delete(int id);
	List<Config> loadBySQL(String sql);
	Config loadByID(int id);
}
