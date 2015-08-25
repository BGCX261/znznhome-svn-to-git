package com.changda.dao;

import java.util.List;

import com.changda.model.News;

public interface NewsDAO {
	
	boolean save(News news) ;
	boolean update(News news);
	boolean delete(int id);
	List<News> loadBySQL(String sql);
	News loadByID(int id);
}
