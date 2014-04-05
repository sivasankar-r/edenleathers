package com.kanchutech.eden.service;

import java.util.List;

import com.kanchutech.eden.dao.CartDao;
import com.kanchutech.eden.managed.UserMBean;
import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.model.User;

public class CartService implements ICartService{

	private CartDao cartDao;
	
	@Override
	public List<Product> fetchCartItems(User user) {
		return cartDao.fetchProducts(user);
	}
	
	@Override
	public void addProduct(User user, Product product) {
		cartDao.addProduct(user, product);
	}
	
	@Override
	public void placeOrder(UserMBean userMBean) {
		cartDao.placeOrder(userMBean);
	};
	
	public CartDao getCartDao() {
		return cartDao;
	}
	
	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	public void deleteProduct(User user, Product product) {
		cartDao.delete(user, product);
	}

}
