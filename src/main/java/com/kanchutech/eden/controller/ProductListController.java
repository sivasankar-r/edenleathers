package com.kanchutech.eden.controller;

import com.kanchutech.eden.managed.ProductListMBean;
import com.kanchutech.eden.managed.SelectedProductMBean;
import com.kanchutech.eden.service.IProductService;
import com.kanchutech.eden.service.IReviewService;

public class ProductListController {
	private IProductService productService;
	private ProductListMBean productListMBean;
	private SelectedProductMBean selectedProductMBean;
	private IReviewService reviewService;
	
	public String fetchAllProducts(){
		productListMBean.setProducts(productService.fetchAllProducts());
		return "productList";
	}
	
	public String loadProduct(){
		selectedProductMBean.getProduct().setReviews(reviewService.loadReviews(selectedProductMBean.getProduct()));
		return "viewProduct";
	}
	
	/*
	 * Accessor methods here after
	 */

	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public ProductListMBean getProductListMBean() {
		return productListMBean;
	}

	public void setProductListMBean(ProductListMBean productListMBean) {
		this.productListMBean = productListMBean;
	}

	public SelectedProductMBean getSelectedProductMBean() {
		return selectedProductMBean;
	}

	public void setSelectedProductMBean(SelectedProductMBean selectedProductMBean) {
		this.selectedProductMBean = selectedProductMBean;
	}

	public IReviewService getReviewService() {
		return reviewService;
	}

	public void setReviewService(IReviewService reviewService) {
		this.reviewService = reviewService;
	}
}
