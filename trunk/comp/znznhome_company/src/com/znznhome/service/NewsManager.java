package com.znznhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.znznhome.dao.NewsDAO;
import com.znznhome.model.News;


@Component("newsManager")
public class NewsManager {
	
	private NewsDAO newsDAO;
	@Resource(name="newsDAO")
	public void setNewsDAO(NewsDAO newsDAO) {
		this.newsDAO = newsDAO;
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
