package com.znznhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.znznhome.dao.CoolJokeDAO;
import com.znznhome.dao.impl.CoolJokeDAOImpl;
import com.znznhome.model.CoolJoke;

@Component("coolJokeManager")
public class CoolJokeManager {
	
	private CoolJokeDAO coolJokeDAO;

	public CoolJokeDAO getCoolJokeDAO() {
		return coolJokeDAO;
	}
	
	@Resource(name="coolJokeDAO")
	public void setCoolJokeDAO(CoolJokeDAO coolJokeDAO) {
		this.coolJokeDAO = coolJokeDAO;
	}
	
	public boolean save(CoolJoke coolJoke) {
		return coolJokeDAO.save(coolJoke);
	}

	public List<CoolJoke> loadBySQL(String sql) {
		return coolJokeDAO.loadBySQL(sql);
	}

	public boolean delete(int id) {
		return coolJokeDAO.delete(id);
	}
	
	public CoolJoke loadByID(int id) {
		return coolJokeDAO.loadByID(id);
	}
	
	public boolean update(CoolJoke coolJoke) {
		return coolJokeDAO.update(coolJoke);
	}

}
