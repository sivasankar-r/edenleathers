package com.kanchutech.eden.managed;

import javax.annotation.PostConstruct;

import com.kanchutech.eden.model.User;

public class UserMBean {
	private User user;
	
	@PostConstruct
	public void init(){
		this.user = new User();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
