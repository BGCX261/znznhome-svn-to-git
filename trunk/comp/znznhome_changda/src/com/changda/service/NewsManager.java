package com.changda.service;

import java.util.List;

import com.changda.dao.NewsDAO;
import com.changda.dao.impl.NewsDAOImpl;
import com.changda.model.News;



public class NewsManager {
	
	private static NewsManager newsManager = null;
	private NewsDAO newsDAO = new NewsDAOImpl();
	private NewsManager(){
	}
	
	public NewsDAO getNewsDAO() {
		return newsDAO;
	}
	
	public void setNewsDAO(NewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}
	
	public static synchronized  NewsManager getInstance() {
		if(newsManager == null) newsManager = new NewsManager();
		return newsManager;
	}
	
	public boolean save(News news) {
		return newsDAO.save(news);
	}

	public List<News> loadBySQL(String sql) {
		return newsDAO.loadBySQL(sql);
	}

	public boolean delete(int id) {
		return newsDAO.delete(id);
	}
	
	public News loadByID(int id) {
		return newsDAO.loadByID(id);
	}
	
	public boolean update(News news) {
		return newsDAO.update(news);
	}

}
