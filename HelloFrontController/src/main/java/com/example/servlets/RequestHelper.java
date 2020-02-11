package com.example.servlets;

import javax.servlet.http.HttpServletRequest;

import com.example.controller.HomeController;
import com.example.controller.MasterServlet;

public class RequestHelper {
	
	public static String process(HttpServletRequest req) {
	
		
		switch(req.getRequestURI()) {
		case "/HelloFrontController/login.change":
			System.out.println("in login.change");
			return MasterServlet.login(req);
		case "/HelloFrontController/home.change":
			System.out.println("in home.change");
		return HomeController.home(req);
		default:
			System.out.println("in default case");
			return "Resources/html/badlogin.html";
		}
	}

}
