package com.znznhome.dao;

import java.util.List;

import com.znznhome.model.Job;

public interface JobDAO {
	
	boolean save(Job job) ;
	boolean update(Job job);
	boolean delete(int id);
	List<Job> loadBySQL(String sql);
	Job loadByID(int id);
}
