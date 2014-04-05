package com.kanchutech.eden.service;

import java.util.List;

import com.kanchutech.eden.managed.UserMBean;
import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.model.User;

public interface ICartService {
	public List<Product> fetchCartItems(User user);

	public void addProduct(User user, Product product);

	public void deleteProduct(User user, Product product);

	public void placeOrder(UserMBean userMBean);
}
