package com.kanchutech.eden.managed;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.model.User;

public class UserMBean {
	private User user;
	private List<Product> cartProductList;
	
	@PostConstruct
	public void init(){
		this.user = new User();
		cartProductList = new ArrayList<Product>();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getCartProductList() {
		return cartProductList;
	}

	public void setCartProductList(List<Product> cartProductList) {
		this.cartProductList = cartProductList;
	}
	
}
