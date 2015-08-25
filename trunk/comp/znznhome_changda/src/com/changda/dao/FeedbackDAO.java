package com.changda.dao;

import java.util.List;

import com.changda.model.Feedback;

public interface FeedbackDAO {
	
	boolean save(Feedback feedback) ;
	boolean update(Feedback feedback);
	boolean delete(int id);
	List<Feedback> loadBySQL(String sql);
	Feedback loadByID(int id);
}
