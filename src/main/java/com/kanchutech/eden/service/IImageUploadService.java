package com.kanchutech.eden.service;

import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.model.UploadedImage;


public interface IImageUploadService {
	String uploadPhoto(Product product, UploadedImage image);
}
