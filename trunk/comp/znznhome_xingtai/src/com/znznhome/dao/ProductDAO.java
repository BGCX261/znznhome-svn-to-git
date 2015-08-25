package com.znznhome.dao;

import java.util.List;

import com.znznhome.model.Product;

public interface ProductDAO {
	
	boolean save(Product product) ;
	boolean update(Product product);
	boolean delete(int id);
	List<Product> loadBySQL(String sql);
	Product loadByID(int id);
}
