package com.znznhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.znznhome.dao.ConfigDAO;
import com.znznhome.model.Config;

@Component("configManager")
public class ConfigManager {
	
	private ConfigDAO configDAO;
	@Resource(name="configDAO")
	public void setConfigDAO(ConfigDAO configDAO) {
		this.configDAO = configDAO;
	}
	
	public boolean save(Config config) {
		return configDAO.save(config);
	}

	public List<Config> loadBySQL(String sql) {
		return configDAO.loadBySQL(sql);
	}

	public boolean delete(int id) {
		return configDAO.delete(id);
	}
	
	public Config loadByID(int id) {
		return configDAO.loadByID(id);
	}
	
	public boolean update(Config config) {
		return configDAO.update(config);
	}

}
