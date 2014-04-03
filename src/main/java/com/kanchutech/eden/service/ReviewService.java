package com.kanchutech.eden.service;

import java.util.List;

import com.kanchutech.eden.dao.ReviewDao;
import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.model.Review;

public class ReviewService implements IReviewService {
	private IProductService productService;
	private ReviewDao reviewDao;

	@Override
	public List<Review> loadReviews(Product product) {
		return reviewDao.fetchReviews(product);
	}
	
	@Override
	public boolean addOrUpdateReview(Product product, Review review) {
		Review existingReview = null;
		boolean isNewReview = false;
		boolean successFlag = false;
		if(reviewDao.alreadyCommented(review)){
			existingReview = reviewDao.update(review);
		}else{
			reviewDao.add(review);
			isNewReview = true;
		}
		
		if(isNewReview){
			successFlag = productService.updateProductRatingCache(product, review);
		}else{
			successFlag = productService.updateProductRatingCache(product, review, existingReview);
		}
		return successFlag;
	}


	/*
	 *************** Accessors here after ****************
	 */
	
	public ReviewDao getReviewDao() {
		return reviewDao;
	}

	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	
	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
}
