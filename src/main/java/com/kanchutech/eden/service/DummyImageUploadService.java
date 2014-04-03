package com.kanchutech.eden.service;

import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.model.UploadedImage;

public class DummyImageUploadService implements IImageUploadService {

	@Override
	public String uploadPhoto(Product product, UploadedImage image) {
		return "http://placehold.it/400x300";
	}

}
