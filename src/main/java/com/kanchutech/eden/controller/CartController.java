package com.kanchutech.eden.controller;

import com.kanchutech.eden.managed.UserMBean;
import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.service.ICartService;
import com.kanchutech.eden.service.IEmailService;

public class CartController {
	private ICartService cartService;
	private UserMBean userMBean;
	private Product selectedForDelete;
	private IEmailService emailService;
	
	public String showCart(){
		userMBean.setCartProductList(cartService.fetchCartItems(userMBean.getUser()));
		return "cart";
	}

	public String deleteProduct(){
		cartService.deleteProduct(userMBean.getUser(), selectedForDelete);
		return showCart();
	}
	
	public String checkOutCart(){
		cartService.placeOrder(userMBean);
		emailService.send(userMBean.getUser(), userMBean.getCartProductList());
		return showCart();
	}

	public ICartService getCartService() {
		return cartService;
	}

	public void setCartService(ICartService cartService) {
		this.cartService = cartService;
	}

	public UserMBean getUserMBean() {
		return userMBean;
	}

	public void setUserMBean(UserMBean userMBean) {
		this.userMBean = userMBean;
	}

	public Product getSelectedForDelete() {
		return selectedForDelete;
	}

	public void setSelectedForDelete(Product selectedForDelete) {
		this.selectedForDelete = selectedForDelete;
	}
	
	public IEmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(IEmailService emailService) {
		this.emailService = emailService;
	}
}
