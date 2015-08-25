package com.znznhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.znznhome.dao.UrlDAO;
import com.znznhome.model.Url;

@Component("urlManager")
public class UrlManager {
	
	private UrlDAO urlDAO;
	@Resource(name="urlDAO")
	public void setUrlDAO(UrlDAO urlDAO) {
		this.urlDAO = urlDAO;
	}
	
	public boolean save(Url url) {
		return urlDAO.save(url);
	}

	public List<Url> loadBySQL(String sql) {
		return urlDAO.loadBySQL(sql);
	}

	public boolean delete(int id) {
		return urlDAO.delete(id);
	}
	
	public Url loadByID(int id) {
		return urlDAO.loadByID(id);
	}
	
	public boolean update(Url url) {
		return urlDAO.update(url);
	}

}
