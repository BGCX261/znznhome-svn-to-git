package com.changda.dao;

import java.util.List;

import com.changda.model.Cases;

public interface CasesDAO {
	
	boolean save(Cases cases) ;
	boolean update(Cases cases);
	boolean delete(int id);
	List<Cases> loadBySQL(String sql);
	Cases loadByID(int id);
}
