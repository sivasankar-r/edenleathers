package com.kanchutech.eden.service;

import com.kanchutech.eden.dao.AddProductDao;
import com.kanchutech.eden.model.Product;

public class AddProductService implements IAddProductService{
	private AddProductDao addProductDao;
	
	public AddProductDao getAddProductDao() {
		return addProductDao;
	}

	public void setAddProductDao(AddProductDao addProductDao) {
		this.addProductDao = addProductDao;
	}

	public int saveProduct(Product product){
		return addProductDao.saveProduct(product);
	}
}
