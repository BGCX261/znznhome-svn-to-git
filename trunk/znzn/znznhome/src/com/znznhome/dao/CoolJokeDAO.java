package com.znznhome.dao;

import java.util.List;

import com.znznhome.model.CoolJoke;

public interface CoolJokeDAO {
	
	boolean save(CoolJoke coolJoke) ;
	boolean update(CoolJoke coolJoke);
	boolean delete(int id);
	List<CoolJoke> loadBySQL(String sql);
	CoolJoke loadByID(int id);
}
