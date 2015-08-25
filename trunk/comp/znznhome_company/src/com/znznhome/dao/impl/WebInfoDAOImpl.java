package com.znznhome.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.dao.WebInfoDAO;
import com.znznhome.model.WebInfo;


@Component("webInfoDAO")
public class WebInfoDAOImpl implements WebInfoDAO{
	private SessionFactory sessionFactory;

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean save(WebInfo webInfo) {
		Session session = sessionFactory.getCurrentSession();
		session.save(webInfo);
		return true;
	}

	public boolean update(WebInfo webInfo) {
		Session session = sessionFactory.getCurrentSession();
		session.update(webInfo);
		return true;
	}

	public WebInfo load() {
		Session session = sessionFactory.getCurrentSession();
		WebInfo webInfo = (WebInfo)session.get(WebInfo.class, 1);
		return webInfo;
	}

}
