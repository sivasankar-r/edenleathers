package com.kanchutech.eden.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.kanchutech.eden.model.Product;

public class AddProductDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}
	
	public int saveProduct(Product product){
		int productId = 0;
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(getJdbcTemplate());
		jdbcInsert.withTableName("products");
		jdbcInsert.setGeneratedKeyName("id");
		Number key = jdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(product));
		if (key != null){
			productId = key.intValue();
		}
		return productId;
	}
}
