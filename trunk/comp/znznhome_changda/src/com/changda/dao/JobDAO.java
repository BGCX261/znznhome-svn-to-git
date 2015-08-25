package com.changda.dao;

import java.util.List;

import com.changda.model.Job;

public interface JobDAO {
	
	boolean save(Job job) ;
	boolean update(Job job);
	boolean delete(int id);
	List<Job> loadBySQL(String sql);
	Job loadByID(int id);
}
