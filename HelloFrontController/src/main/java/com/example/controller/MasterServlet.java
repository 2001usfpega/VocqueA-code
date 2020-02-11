package com.example.controller;

import javax.servlet.http.HttpServletRequest;

public class MasterServlet {
	
	public static String login(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			return "resources/html/login.html";
		}
		
		String username= req.getParameter("username");
		String password= req.getParameter("password");
		
		/*
		 * for YOUR project, you won't hardcode "cheese" and "louise" you'll go to the DB
		 * and find the ACTUAL password that should be used, base on the username they typed
		 * in.
		 */
		if(!(username.equals("cheese") && password.equals("louise"))) {
			return "wrongcreds.change";
		}else {
			/*
			 * in YOUR project, you'll be storing an entire User object in the session
			 * which will ALSO contain whether it is an manager or employee
			 */
			req.getSession().setAttribute("loggedusername", username);
			req.getSession().setAttribute("loggedpassword", password);
			return "home.change";
		}
	}
}
