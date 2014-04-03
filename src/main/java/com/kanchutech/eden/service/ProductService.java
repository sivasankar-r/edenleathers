package com.kanchutech.eden.service;

import java.util.List;

import com.kanchutech.eden.dao.ProductDao;
import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.model.Review;
import com.kanchutech.eden.util.MathUtil;

public class ProductService implements IProductService{
	private ProductDao productDao;
	
	@Override
	public List<Product> fetchAllProducts(){
		return productDao.fetchAllProducts();
	}

	@Override
	public boolean updateProductRatingCache(Product product, Review review) {
		boolean successFlag = false;
		if(product!=null && review!=null){
			double newRatingCache = MathUtil.addItemToAvg(product.getRatingCache(), product.getRatingCount(), review.getRating());
			int newRatingCount = (product.getRatingCount() + 1);
			successFlag = productDao.updateProductRatingCache(product.getId(), newRatingCache, newRatingCount) == 1;	
		}
		return successFlag;	
	}
	
	@Override
	public boolean updateProductRatingCache(Product product, Review currReview, Review existingReview) {
		boolean successFlag = false;
		if(product!=null && currReview!=null && existingReview!=null){
			double ratingCache = MathUtil.removeItemFromAvg(product.getRatingCache(), product.getRatingCount(), existingReview.getRating());
			double newRatingCache = MathUtil.addItemToAvg(ratingCache, product.getRatingCount()-1, currReview.getRating());
			successFlag = productDao.updateProductRatingCache(product.getId(), newRatingCache, product.getRatingCount()) == 1;	
		}
		return successFlag;	
	}
	
	@Override
	public Product fetchProduct(int productId) {
		return productDao.fetchProduct(productId);
	}
	
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	} 

}
