package com.znznhome.dao;

import java.util.List;

import com.znznhome.model.NoticeHelp;

public interface NoticeHelpDAO {
	
	boolean save(NoticeHelp noticeHelp) ;
	boolean update(NoticeHelp noticeHelp);
	boolean delete(int id);
	List<NoticeHelp> loadBySQL(String sql);
	NoticeHelp loadByID(int id);
}
