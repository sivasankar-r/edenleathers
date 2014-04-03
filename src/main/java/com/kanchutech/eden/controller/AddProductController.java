package com.kanchutech.eden.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.faces.event.AjaxBehaviorEvent;

import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

import com.kanchutech.eden.managed.AddProductMBean;
import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.model.UploadedImage;
import com.kanchutech.eden.service.IAddProductService;
import com.kanchutech.eden.service.IImageUploadService;

public class AddProductController {
	private IAddProductService addProductService;
	private IImageUploadService imageUploadService;
	private AddProductMBean addProductMBean;
	private ProductListController productListController;
		
	public void fileUploadListener(FileUploadEvent event) throws Exception {
		UploadedFile item = event.getUploadedFile();
        UploadedImage file = new UploadedImage();
        file.setLength(item.getData().length);
        file.setName(item.getName());
        file.setData(item.getData());
        addProductMBean.setUploadedImage(file);
    }
	
	public void paint(OutputStream stream, Object object) throws IOException {
		if(addProductMBean.getUploadedImage()!=null){
			stream.write(addProductMBean.getUploadedImage().getData());
			stream.close();
		}else{
			stream.write(0);
			stream.close();
		}
    }
	
	public void clearUploadData(AjaxBehaviorEvent event) {
        addProductMBean.setUploadedImage(null);
    }
	
	public String saveProduct(){
		Product product = addProductMBean.getProduct();
		product.setCreatedAt(new Date());
		product.setUpdatedAt(new Date());
		product.setIcon(imageUploadService.uploadPhoto(product, addProductMBean.getUploadedImage()));
		addProductService.saveProduct(product);
		return productListController.fetchAllProducts();
	}
	
	
	/*
	 * ******************** Accessors Here After *****************
	 */

	public AddProductMBean getAddProductMBean() {
		return addProductMBean;
	}

	public void setAddProductMBean(AddProductMBean addProductMBean) {
		this.addProductMBean = addProductMBean;
	}

	public IAddProductService getAddProductService() {
		return addProductService;
	}

	public void setAddProductService(IAddProductService addProductService) {
		this.addProductService = addProductService;
	}

	public ProductListController getProductListController() {
		return productListController;
	}

	public void setProductListController(ProductListController productListController) {
		this.productListController = productListController;
	}

	public IImageUploadService getImageUploadService() {
		return imageUploadService;
	}

	public void setImageUploadService(IImageUploadService imageUploadService) {
		this.imageUploadService = imageUploadService;
	}
}
