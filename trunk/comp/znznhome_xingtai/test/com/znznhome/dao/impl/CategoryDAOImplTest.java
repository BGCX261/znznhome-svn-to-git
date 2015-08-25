package com.znznhome.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.znznhome.model.Category;
import com.znznhome.service.CategoryManager;


public class CategoryDAOImplTest {
	
	@Test
	public void getAllChilds() {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		CategoryDAOImpl dao = (CategoryDAOImpl)ctx.getBean("categoryDAO");
		List<Category> list = new ArrayList<Category>();
		list = dao.getAllChilds(list, 0);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
		ctx.destroy();
	}
	
}
