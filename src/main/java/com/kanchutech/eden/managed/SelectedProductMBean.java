package com.kanchutech.eden.managed;

import javax.annotation.PostConstruct;

import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.model.Review;

public class SelectedProductMBean {
	private Product product;
	private Review newReview;
	
	@PostConstruct
	public void init(){
		newReview = new Review();
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Review getNewReview() {
		return newReview;
	}

	public void setNewReview(Review newReview) {
		this.newReview = newReview;
	}
}
