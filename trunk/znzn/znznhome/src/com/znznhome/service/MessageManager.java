package com.znznhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.znznhome.dao.MessageDAO;
import com.znznhome.dao.impl.MessageDAOImpl;
import com.znznhome.model.Message;

@Component("messageManager")
public class MessageManager {
	
	private MessageDAO messageDAO;
	
	public MessageDAO getMessageDAO() {
		return messageDAO;
	}
	
	@Resource(name="messageDAO")
	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}
	
	public boolean save(Message message) {
		return messageDAO.save(message);
	}

	public List<Message> loadBySQL(String sql) {
		return messageDAO.loadBySQL(sql);
	}

	public boolean delete(int id) {
		return messageDAO.delete(id);
	}
	
	public Message loadByID(int id) {
		return messageDAO.loadByID(id);
	}
	
	public boolean update(Message message) {
		return messageDAO.update(message);
	}

}
