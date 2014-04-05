package com.kanchutech.eden.model;

import java.util.Date;

public class Order {
	private int id;
	private String userId;
	private String shippingAddress;
	private Date shippingDate;
	private String shippingStatus;
	private Date createdAt;
	private String shippingContactNumber;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Date getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}
	public String getShippingStatus() {
		return shippingStatus;
	}
	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getShippingContactNumber() {
		return shippingContactNumber;
	}
	public void setShippingContactNumber(String shippingContactNumber) {
		this.shippingContactNumber = shippingContactNumber;
	}
}
