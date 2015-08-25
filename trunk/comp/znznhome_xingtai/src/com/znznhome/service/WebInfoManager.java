package com.znznhome.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.znznhome.dao.WebInfoDAO;
import com.znznhome.model.WebInfo;


@Component("webInfoManager")
public class WebInfoManager {
	
	private WebInfoDAO webInfoDAO;
	@Resource(name="webInfoDAO")
	public void setWebInfoDAO(WebInfoDAO webInfoDAO) {
		this.webInfoDAO = webInfoDAO;
	}
	
	
	public boolean save(WebInfo webInfo) {
		return webInfoDAO.save(webInfo);
	}

	public WebInfo load() {
		return webInfoDAO.load();
	}
	
	public boolean update(WebInfo webInfo) {
		return webInfoDAO.update(webInfo);
	}

}
