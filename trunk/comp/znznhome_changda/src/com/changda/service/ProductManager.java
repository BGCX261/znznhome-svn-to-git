package com.changda.service;

import java.util.List;

import com.changda.dao.ProductDAO;
import com.changda.dao.impl.ProductDAOImpl;
import com.changda.model.Product;



public class ProductManager {
	
	private static ProductManager productManager = null;
	private ProductDAO productDAO = new ProductDAOImpl();
	private ProductManager(){
	}
	
	public ProductDAO getProductDAO() {
		return productDAO;
	}
	
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	public static synchronized  ProductManager getInstance() {
		if(productManager == null) productManager = new ProductManager();
		return productManager;
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
