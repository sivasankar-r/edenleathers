package com.kanchutech.eden.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Product {
	private int id;
	private boolean published;
	private double ratingCache;
	private int ratingCount;
	private String name;
	private double pricing;
	private double weight;
	private String sizes;
	private String colors;
	private String materials;
	private String style;
	private String shortDescription;
	private String longDescription;
	private String icon;
	private Date createdAt;
	private Date updatedAt;
	private String category;
	private String vendor;
	private String tags;
	private Date publishDate;
	private Object[] ratingCacheArray;
	private Object[] emptyRatingCacheArray;
	private List<Review> reviews;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public double getRatingCache() {
		return ratingCache;
	}

	public void setRatingCache(double ratingCache) {
		this.ratingCache = ratingCache;
	}

	public int getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPricing() {
		return pricing;
	}

	public void setPricing(double pricing) {
		this.pricing = pricing;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getSizes() {
		return sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
	}

	public String getColors() {
		return colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}

	public String getMaterials() {
		return materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Object[] getRatingCacheArray() {
		int rating = new BigDecimal(ratingCache).intValue();
		return new Object[rating];
	}

	public void setRatingCacheArray(Object[] ratingCacheArray) {
		this.ratingCacheArray = ratingCacheArray;
	}

	public Object[] getEmptyRatingCacheArray() {
		int rating = 5 - (new BigDecimal(ratingCache).intValue());
		return new Object[rating];
	}

	public void setEmptyRatingCacheArray(Object[] emptyRatingCacheArray) {
		this.emptyRatingCacheArray = emptyRatingCacheArray;
	}
	
	
}
