package com.kanchutech.eden.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.kanchutech.eden.model.Product;
import com.kanchutech.eden.model.Review;

public class ReviewDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}

	public List<Review> fetchReviews(Product product) {
		List<Review> reviews = new ArrayList<Review>();
		if(product != null && product.getId() > 0){
			String query = "SELECT * FROM reviews WHERE product_id = " + product.getId() + " ORDER BY created_at DESC";
			reviews = getJdbcTemplate().query(query, new BeanPropertyRowMapper<Review>(Review.class));
		}
		return reviews;
	}

	/**
	 * Add review and return the generated review Id
	 * @param review
	 * @return
	 */
	public int add(Review review) {
		int reviewId = 0;
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(getJdbcTemplate());
		jdbcInsert.withTableName("reviews");
		jdbcInsert.setGeneratedKeyName("id");
		Number key = jdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(review));
		if (key != null){
			reviewId = key.intValue();
		}
		return reviewId;
	}

	private Review fetchReview(int productId, String userId) {
		return getJdbcTemplate().queryForObject("SELECT * FROM reviews WHERE product_id = ? AND user_id = ?", new Object[]{productId, userId}, new BeanPropertyRowMapper<Review>(Review.class));
	}

	public boolean alreadyCommented(Review review) {
		String query = "SELECT COUNT(*) FROM reviews WHERE product_id = ? AND user_id = ?"; 
		return getJdbcTemplate().queryForInt(query, new Object[]{review.getProductId(), review.getUserId()}) > 0;
	}

	/**
	 * Updates existing review by the user and returns the updated review id
	 * @param review
	 * @return
	 */
	
	public Review update(Review review){
		Review oldReview = fetchReview(review.getProductId(), review.getUserId());
		if(oldReview!=null){
			getJdbcTemplate().update("UPDATE reviews SET updated_at = ?, rating = ?, comment=? WHERE product_id=? AND user_id=?",
							new Object[] { new Date(), review.getRating(),
									review.getComment(),
									review.getProductId(),
									review.getUserId() });
		}
		return oldReview;
	}
}
