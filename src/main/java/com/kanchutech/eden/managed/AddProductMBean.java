package com.kanchutech.eden.managed;

import javax.annotation.PostConstruct;

import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.model.UploadedImage;

public class AddProductMBean {
	private Product product;
	private UploadedImage uploadedImage;
	
	@PostConstruct
	public void init(){
		this.product = new Product();
	}
	
	/*public AddProductMBean(Product product){
		this.product = product;
	}
*/
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public UploadedImage getUploadedImage() {
		return uploadedImage;
	}

	public void setUploadedImage(UploadedImage uploadedImage) {
		this.uploadedImage = uploadedImage;
	}	
}
