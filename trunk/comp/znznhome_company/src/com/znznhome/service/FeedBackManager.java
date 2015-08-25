package com.znznhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.znznhome.dao.FeedBackDAO;
import com.znznhome.model.FeedBack;

@Component("feedBackManager")
public class FeedBackManager {
	
	private FeedBackDAO feedBackDAO;
	@Resource(name="feedBackDAO")
	public void setFeedBackDAO(FeedBackDAO feedBackDAO) {
		this.feedBackDAO = feedBackDAO;
	}
	
	public boolean save(FeedBack feedBack) {
		return feedBackDAO.save(feedBack);
	}

	public List<FeedBack> loadBySQL(String sql) {
		return feedBackDAO.loadBySQL(sql);
	}

	public boolean delete(int id) {
		return feedBackDAO.delete(id);
	}
	
	public FeedBack loadByID(int id) {
		return feedBackDAO.loadByID(id);
	}
	
	public boolean update(FeedBack feedBack) {
		return feedBackDAO.update(feedBack);
	}

}
