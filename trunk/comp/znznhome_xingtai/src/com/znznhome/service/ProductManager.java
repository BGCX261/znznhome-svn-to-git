package com.znznhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.znznhome.dao.ProductDAO;
import com.znznhome.model.Product;

@Component("productManager")
public class ProductManager {
	
	private ProductDAO productDAO;
	@Resource(name="productDAO")
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	
	public boolean save(Product product) {
		return productDAO.save(product);
	}

	public List<Product> loadBySQL(String sql) {
		return productDAO.loadBySQL(sql);
	}

	public boolean delete(int id) {
		return productDAO.delete(id);
	}
	
	public Product loadByID(int id) {
		return productDAO.loadByID(id);
	}
	
	public boolean update(Product product) {
		return productDAO.update(product);
	}

}
