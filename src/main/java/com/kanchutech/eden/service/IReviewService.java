package com.kanchutech.eden.service;

import java.util.List;

import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.model.Review;

public interface IReviewService {
	List<Review> loadReviews(Product product);
	boolean addOrUpdateReview(Product product, Review newReview);
}
