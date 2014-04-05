package com.kanchutech.eden.service;

import java.util.List;

import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.model.User;

public interface IEmailService {
	public boolean send(User user, Product product);
	public boolean send(User user, List<Product> productList);
}
