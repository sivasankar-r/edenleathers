package com.kanchutech.eden.service;

import java.util.List;

import com.github.sendgrid.SendGrid;
import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.model.User;
import com.kanchutech.eden.util.PropertyUtil;

public class SendGridEmailService implements IEmailService {

	@Override
	public boolean send(User user, Product product) {
		String response = "";
		if (user!=null && !"".equals(user.getEmail()) && product!=null) {
			SendGrid sendgrid = new SendGrid(PropertyUtil.getProperty("SENDGRID_USER_NAME"), PropertyUtil.getProperty("SENDGRID_PASSWORD"));
			sendgrid.addTo(user.getEmail());
			sendgrid.addTo(PropertyUtil.getProperty("MAIL_EDEN_ADMIN"));
			sendgrid.addToName(user.getName());
			sendgrid.addToName(PropertyUtil.getProperty("EDEN_ADMIN_NAME"));
			sendgrid.setFrom(PropertyUtil.getProperty("MAIL_EDEN_ADMIN"));
			sendgrid.setFromName(PropertyUtil.getProperty("EDEN_ADMIN_NAME"));
			sendgrid.setReplyTo(PropertyUtil.getProperty("MAIL_EDEN_ADMIN"));
			String mailSubject = PropertyUtil.getProperty("MAIL_NOTIFY_SUBJECT") + product.getName();
			sendgrid.setSubject(mailSubject);
			String mailContent = PropertyUtil.getProperty("MAIL_CONTENT");
			mailContent = mailContent.replace("@@customer_name@@", user.getName());
			mailContent = mailContent.replace("@@product_name@@", product.getName());
			sendgrid.setHtml(mailContent);
			response = sendgrid.send();
			System.out.println(response);
		}
		return response.equals("{\"message\":\"success\"}");
	}

	@Override
	public boolean send(User user, List<Product> productList) {
		String response = "";
		if (user!=null && !"".equals(user.getEmail()) && productList!=null && !productList.isEmpty()) {
			SendGrid sendgrid = new SendGrid(PropertyUtil.getProperty("SENDGRID_USER_NAME"), PropertyUtil.getProperty("SENDGRID_PASSWORD"));
			sendgrid.addTo(user.getEmail());
			sendgrid.addTo(PropertyUtil.getProperty("MAIL_EDEN_ADMIN"));
			sendgrid.addToName(user.getName());
			sendgrid.addToName(PropertyUtil.getProperty("EDEN_ADMIN_NAME"));
			sendgrid.setFrom(PropertyUtil.getProperty("MAIL_EDEN_ADMIN"));
			sendgrid.setFromName(PropertyUtil.getProperty("EDEN_ADMIN_NAME"));
			sendgrid.setReplyTo(PropertyUtil.getProperty("MAIL_EDEN_ADMIN"));
			sendgrid.setSubject(PropertyUtil.getProperty("MAIL_ORDER_PLACED_SUBJECT"));
			String mailContent = PropertyUtil.getProperty("MAIL_CONTENT");
			StringBuilder products = new StringBuilder();
			for(Product product : productList){
				products.append(product.getName()+"<br/>");
			}
			mailContent = mailContent.replace("@@customer_name@@", user.getName());
			mailContent = mailContent.replace("@@products_list@@", products);
			sendgrid.setHtml(mailContent);
			response = sendgrid.send();
			System.out.println(response);
		}
		return response.equals("{\"message\":\"success\"}");
	}
}
