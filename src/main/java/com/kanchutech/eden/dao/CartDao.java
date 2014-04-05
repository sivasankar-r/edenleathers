package com.kanchutech.eden.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.kanchutech.eden.managed.UserMBean;
import com.kanchutech.eden.model.Order;
import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.model.User;

public class CartDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}

	public List<Product> fetchProducts(User user) {
		List<Product> products = new ArrayList<Product>();
		if(user!=null && !"".equals(user.getEmail())){
			String query = "select p.* from products p inner join cart c on p.id = c.product_id where c.user_id = '" + user.getEmail() +"'";
			products = getJdbcTemplate().query(query, new BeanPropertyRowMapper<Product>(Product.class));
		}
		return products;
	}

	public void addProduct(User user, Product product) {
		if(!"".equals(user.getEmail()) && product!=null){
			String query = "insert into cart values('" + user.getEmail() + "', "+product.getId()+")";
			getJdbcTemplate().execute(query);
		}
	}

	public void delete(User user, Product product) {
		if(!"".equals(user.getEmail()) && product!=null){
			String query = "delete from cart where user_id = '" + user.getEmail() + "' and product_id = "+product.getId();
			getJdbcTemplate().execute(query);
		}
	}

	// FIXME refactor the code to be more object oriented
	public void placeOrder(UserMBean userMBean) {
		if(userMBean!=null && userMBean.getUser()!=null && !"".equals(userMBean.getUser().getEmail())){
			if(userMBean.getCartProductList()!=null && !userMBean.getCartProductList().isEmpty()){
				Order order = new Order();
				order.setCreatedAt(new Date());
				order.setShippingAddress("");
				order.setShippingDate(null);
				order.setShippingStatus("Order Created");
				order.setUserId(userMBean.getUser().getEmail());
				order.setShippingContactNumber("");
				int orderId = createOrder(order);
				int quantity = 1;
				for(Product product: userMBean.getCartProductList()){
					createOrderDetails(orderId, product.getId(), quantity);
					delete(userMBean.getUser(), product);
				}
			}
		}
	}
	
	public void createOrderDetails(int orderId, int productId, int quantity) {
		String query = "insert into orderdetails (order_id, product_id, quantity) values (" + orderId + "," + productId + "," + quantity+")";
		getJdbcTemplate().execute(query);
	}

	public int createOrder(Order order){
		int orderId = 0;
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(getJdbcTemplate());
		jdbcInsert.withTableName("orders");
		jdbcInsert.setGeneratedKeyName("id");
		Number key = jdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(order));
		if (key != null){
			orderId = key.intValue();
		}
		return orderId;
	}
}
