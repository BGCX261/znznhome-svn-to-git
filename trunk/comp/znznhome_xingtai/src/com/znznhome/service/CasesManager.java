package com.znznhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.znznhome.dao.CasesDAO;
import com.znznhome.model.Cases;

@Component("casesManager")
public class CasesManager {
	
	private CasesDAO casesDAO;
	@Resource(name="casesDAO")
	public void setCasesDAO(CasesDAO casesDAO) {
		this.casesDAO = casesDAO;
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
