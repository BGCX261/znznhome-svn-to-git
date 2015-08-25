package com.znznhome.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.znznhome.enums.IndexBean;
import com.znznhome.model.Url;
import com.znznhome.util.DBLoadUtil;

public class IndexDAOImplTest {

	@Test
	public void testCreateIndex() throws Exception {
		DBLoadUtil.loadConnection();
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IndexDAOImpl dao = (IndexDAOImpl)ctx.getBean("indexDAO");
		IndexBean type = IndexBean.URL;
		Class c = Url.class;
		String sql = "select * from znzn_url";
		dao.createIndex(sql, c, type);
		//fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchStringIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchQueryIntInt() {
		fail("Not yet implemented");
	}

}
