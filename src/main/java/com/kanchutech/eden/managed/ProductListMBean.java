package com.kanchutech.eden.managed;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.kanchutech.eden.model.Product;

public class ProductListMBean {
	private List<Product> products;
	
	@PostConstruct
	public void init(){
		products = new ArrayList<Product>();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
