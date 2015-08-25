package com.znznhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.znznhome.dao.NoticeHelpDAO;
import com.znznhome.dao.impl.NoticeHelpDAOImpl;
import com.znznhome.model.NoticeHelp;

@Component("noticeHelpManager")
public class NoticeHelpManager {
	
	private NoticeHelpDAO noticeHelpDAO;
	
	public NoticeHelpDAO getNoticeHelpDAO() {
		return noticeHelpDAO;
	}
	
	@Resource(name="noticeHelpDAO")
	public void setNoticeHelpDAO(NoticeHelpDAO noticeHelpDAO) {
		this.noticeHelpDAO = noticeHelpDAO;
	}
	
	public boolean save(NoticeHelp noticeHelp) {
		return noticeHelpDAO.save(noticeHelp);
	}

	public List<NoticeHelp> loadBySQL(String sql) {
		return noticeHelpDAO.loadBySQL(sql);
	}

	public boolean delete(int id) {
		return noticeHelpDAO.delete(id);
	}
	
	public NoticeHelp loadByID(int id) {
		return noticeHelpDAO.loadByID(id);
	}
	
	public boolean update(NoticeHelp noticeHelp) {
		return noticeHelpDAO.update(noticeHelp);
	}

}
