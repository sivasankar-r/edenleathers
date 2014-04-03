package com.kanchutech.eden.controller;

import java.util.Date;

import javax.faces.event.AjaxBehaviorEvent;

import com.kanchutech.eden.managed.SelectedProductMBean;
import com.kanchutech.eden.managed.UserMBean;
import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.model.Review;
import com.kanchutech.eden.service.IProductService;
import com.kanchutech.eden.service.IReviewService;


public class ViewProductController {
	private IReviewService reviewService;
	private IProductService productService;
	private SelectedProductMBean selectedProductMBean;
	private UserMBean userMBean;
	
	public void saveReview(AjaxBehaviorEvent event){
		Review review = selectedProductMBean.getNewReview();
		Product product = selectedProductMBean.getProduct();
		
		review.setProductId(product.getId());;
		review.setUserId(userMBean.getUser().getEmail());
		review.setUserName(userMBean.getUser().getName());
		review.setCreatedAt(new Date());
		review.setUpdatedAt(new Date());
		
		reviewService.addOrUpdateReview(product, review);

		selectedProductMBean.setProduct(productService.fetchProduct(product.getId()));
		selectedProductMBean.getProduct().setReviews(reviewService.loadReviews(product));
		selectedProductMBean.setNewReview(new Review());
	}

	/*
	 * ******************** Accessors Here After *****************
	 */

	public IReviewService getReviewService() {
		return reviewService;
	}

	public void setReviewService(IReviewService reviewService) {
		this.reviewService = reviewService;
	}

	public SelectedProductMBean getSelectedProductMBean() {
		return selectedProductMBean;
	}

	public void setSelectedProductMBean(SelectedProductMBean selectedProductMBean) {
		this.selectedProductMBean = selectedProductMBean;
	}

	public UserMBean getUserMBean() {
		return userMBean;
	}

	public void setUserMBean(UserMBean userMBean) {
		this.userMBean = userMBean;
	}
	
	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

}