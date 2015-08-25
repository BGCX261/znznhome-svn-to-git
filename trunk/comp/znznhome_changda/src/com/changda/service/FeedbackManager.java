package com.changda.service;

import java.util.List;

import com.changda.dao.FeedbackDAO;
import com.changda.dao.impl.FeedbackDAOImpl;
import com.changda.model.Feedback;



public class FeedbackManager {
	
	private static FeedbackManager feedbackManager = null;
	private FeedbackDAO feedbackDAO = new FeedbackDAOImpl();
	private FeedbackManager(){
	}
	
	public FeedbackDAO getFeedbackDAO() {
		return feedbackDAO;
	}
	
	public void setFeedbackDAO(FeedbackDAO feedbackDAO) {
		this.feedbackDAO = feedbackDAO;
	}
	
	public static synchronized  FeedbackManager getInstance() {
		if(feedbackManager == null) feedbackManager = new FeedbackManager();
		return feedbackManager;
	}
	
	public boolean save(Feedback feedback) {
		return feedbackDAO.save(feedback);
	}

	public List<Feedback> loadBySQL(String sql) {
		return feedbackDAO.loadBySQL(sql);
	}

	public boolean delete(int id) {
		return feedbackDAO.delete(id);
	}
	
	public Feedback loadByID(int id) {
		return feedbackDAO.loadByID(id);
	}
	
	public boolean update(Feedback feedback) {
		return feedbackDAO.update(feedback);
	}

}
