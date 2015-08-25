package com.znznhome.dao;

import java.util.List;

import com.znznhome.model.FeedBack;

public interface FeedBackDAO {
	
	boolean save(FeedBack feedBack) ;
	boolean update(FeedBack feedBack);
	boolean delete(int id);
	List<FeedBack> loadBySQL(String sql);
	FeedBack loadByID(int id);
}
