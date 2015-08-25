package com.znznhome.action;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.znznhome.dao.BaseHibernateDAO;
import com.znznhome.model.MyFavorite;
import com.znznhome.util.DBLoadUtil;

public class MyFavoriteActionTest {
	@Test
	public void testAdd() {
		DBLoadUtil.loadConnection();
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		BaseHibernateDAO baseHibernateDAO = (BaseHibernateDAO) ctx.getBean("baseHibernateDAO");
		
		MyFavorite myFavorite = new MyFavorite();
		myFavorite.setTitle("dddddd");
		myFavorite.setUrl("111");
		baseHibernateDAO.save(myFavorite);
	}
}
