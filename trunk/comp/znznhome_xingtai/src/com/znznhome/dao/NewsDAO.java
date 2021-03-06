package com.znznhome.dao;

import java.util.List;

import com.znznhome.model.News;

public interface NewsDAO {
	
	boolean save(News news) ;
	boolean update(News news);
	boolean delete(int id);
	List<News> loadBySQL(String sql);
	News loadByID(int id);
	News loadTopic();
	News loadByCategoryEname(String ename);
}
