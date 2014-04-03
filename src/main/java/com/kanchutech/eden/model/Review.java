package com.kanchutech.eden.model;

import java.util.Date;

public class Review {
	private int id;
	private int productId;
	private String userId;
	private String userName;
	private int rating;
	private String comment;
	private int approved;
	private int spam;
	private Date createdAt;
	private Date updatedAt;
	private Object[] ratingArray;
	private Object[] emptyRatingArray;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getApproved() {
		return approved;
	}

	public void setApproved(int approved) {
		this.approved = approved;
	}

	public int getSpam() {
		return spam;
	}

	public void setSpam(int spam) {
		this.spam = spam;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Object[] getRatingArray() {
		return new Object[rating];
	}

	public void setRatingArray(Object[] ratingArray) {
		this.ratingArray = ratingArray;
	}

	public Object[] getEmptyRatingArray() {
		return new Object[5-rating];
	}

	public void setEmptyRatingArray(Object[] emptyRatingArray) {
		this.emptyRatingArray = emptyRatingArray;
	}
}
