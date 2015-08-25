package com.changda.service;

import java.util.List;

import com.changda.dao.JobDAO;
import com.changda.dao.impl.JobDAOImpl;
import com.changda.model.Job;



public class JobManager {
	
	private static JobManager jobManager = null;
	private JobDAO jobDAO = new JobDAOImpl();
	private JobManager(){
	}
	
	public JobDAO getJobDAO() {
		return jobDAO;
	}
	
	public void setJobDAO(JobDAO jobDAO) {
		this.jobDAO = jobDAO;
	}
	
	public static synchronized  JobManager getInstance() {
		if(jobManager == null) jobManager = new JobManager();
		return jobManager;
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
