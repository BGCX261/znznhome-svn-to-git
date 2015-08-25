package com.znznhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.znznhome.dao.MessageDefaultDAO;
import com.znznhome.model.MessageDefault;

@Component("messageDefaultManager")
public class MessageDefaultManager {
	
	private MessageDefaultDAO messageDefaultDAO;
	
	public MessageDefaultDAO getMessageDefaultDAO() {
		return messageDefaultDAO;
	}

	@Resource(name="messageDefaultDAO")
	public void setMessageDefaultDAO(MessageDefaultDAO messageDefaultDAO) {
		this.messageDefaultDAO = messageDefaultDAO;
	}

	public boolean save(MessageDefault messageCategoryDefault) {
		return messageDefaultDAO.save(messageCategoryDefault);
	}

	public List<MessageDefault> loadBySQL(String sql) {
		return messageDefaultDAO.loadBySQL(sql);
	}

	public boolean delete(int id) {
		return messageDefaultDAO.delete(id);
	}
	
	public MessageDefault loadByID(int id) {
		return messageDefaultDAO.loadByID(id);
	}
	
	public boolean update(MessageDefault messageCategoryDefault) {
		return messageDefaultDAO.update(messageCategoryDefault);
	}

}
