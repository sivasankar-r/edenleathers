package com.kanchutech.eden.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.kanchutech.eden.managed.UserMBean;
import com.kanchutech.eden.model.User;
import com.google.gson.Gson;

public class GoogleSignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public GoogleSignInServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = getUser(request);
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getSession(false).getServletContext());
        UserMBean userMBean = ctx.getBean("userMBean", UserMBean.class);
        userMBean.setUser(user);
        if(user.getEmail().equals("siva.pcu@gmail.com") || user.getEmail().equals("rsivasankar01@gmail.com")){
        	user.setAdmin(true);
        }
	}

	private User getUser(HttpServletRequest request) throws IOException {
		User user = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String userJson = "";
        if(br != null){
            userJson = br.readLine();
        }
        user = new Gson().fromJson(userJson, User.class);
        return user;
	}

}
