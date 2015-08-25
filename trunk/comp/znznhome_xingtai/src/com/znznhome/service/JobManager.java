package com.znznhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.znznhome.dao.JobDAO;
import com.znznhome.model.Job;

@Component("jobManager")
public class JobManager {
	
	private JobDAO jobDAO;
	@Resource(name="jobDAO")
	public void setJobDAO(JobDAO jobDAO) {
		this.jobDAO = jobDAO;
	}
	
	public boolean save(Job job) {
		return jobDAO.save(job);
	}

	public List<Job> loadBySQL(String sql) {
		return jobDAO.loadBySQL(sql);
	}

	public boolean delete(int id) {
		return jobDAO.delete(id);
	}
	
	public Job loadByID(int id) {
		return jobDAO.loadByID(id);
	}
	
	public boolean update(Job job) {
		return jobDAO.update(job);
	}

}
