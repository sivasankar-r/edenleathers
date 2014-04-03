package com.kanchutech.eden.service;

import java.util.List;

import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.model.Review;

public interface IProductService {
	public List<Product> fetchAllProducts();
	public boolean updateProductRatingCache(Product product, Review currReview);
	public Product fetchProduct(int productId);
	boolean updateProductRatingCache(Product product, Review currReview, Review existingReview);
}
