package com.kanchutech.eden.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kanchutech.eden.model.Product;

public class ProductDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}
	
	public List<Product> fetchAllProducts(){
		List<Product> allProducts = new ArrayList<Product>();
		String query = "SELECT * FROM products";
		allProducts = getJdbcTemplate().query(query, new BeanPropertyRowMapper<Product>(Product.class));
		return allProducts;
	}
	
	public Product fetchProduct(int productId){
		String query = "SELECT * FROM products p WHERE p.id = " + productId;
		return getJdbcTemplate().queryForObject(query, new BeanPropertyRowMapper<Product>(Product.class));
	}
	
	public List<Product> fetchProductByCategory(int categoryId){
		return null;
	}

	public int updateProductRatingCache(int productId, double newRatingCache, int newRatingCount) {
		return getJdbcTemplate().update("update products SET rating_cache = ?, rating_count = ? WHERE id = ?",
							new Object[] { newRatingCache, newRatingCount, productId });

	}
}
