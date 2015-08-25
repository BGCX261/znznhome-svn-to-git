package com.znznhome.dao;

import com.znznhome.model.WebInfo;

public interface WebInfoDAO {
	
	boolean save(WebInfo webInfo) ;
	boolean update(WebInfo webInfo);
	WebInfo load();
}
