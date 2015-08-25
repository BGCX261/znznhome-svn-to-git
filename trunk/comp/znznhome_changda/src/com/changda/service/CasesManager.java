package com.changda.service;

import java.util.List;

import com.changda.dao.CasesDAO;
import com.changda.dao.impl.CasesDAOImpl;
import com.changda.model.Cases;



public class CasesManager {
	
	private static CasesManager casesManager = null;
	private CasesDAO casesDAO = new CasesDAOImpl();
	private CasesManager(){
	}
	
	public CasesDAO getCasesDAO() {
		return casesDAO;
	}
	
	public void setCasesDAO(CasesDAO casesDAO) {
		this.casesDAO = casesDAO;
	}
	
	public static synchronized  CasesManager getInstance() {
		if(casesManager == null) casesManager = new CasesManager();
		return casesManager;
	}
	
	public boolean save(Cases cases) {
		return casesDAO.save(cases);
	}

	public List<Cases> loadBySQL(String sql) {
		return casesDAO.loadBySQL(sql);
	}

	public boolean delete(int id) {
		return casesDAO.delete(id);
	}
	
	public Cases loadByID(int id) {
		return casesDAO.loadByID(id);
	}
	
	public boolean update(Cases cases) {
		return casesDAO.update(cases);
	}

}
