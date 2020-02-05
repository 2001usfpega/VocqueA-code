package com.example.indirectservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * There are THREE ways that a servlet can respond to an incoming request:
 * 
 * -Direct Response (using the PrintWriter Object)
 *  This happens when the servlet directly responds itself
 *  
 *  -Forward (1req, 1resp. Use RequestDispatcher's .forward() method to function)
 *   Comes from the HttpServletRequest object.
 *   The servlets asks another servlet/resource (internal to our application) for assistance.
 *   
 *   -Redirect (2req, 2resp. Use Response object's .sendRedirect() to function)
 *   Comes from the HttpServletResponse
 *   
 *   The servlets informs the client that it must go somewhere else to have the request
 *   handled.
 */
public class IndirectServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException
		{
			System.out.println("In Indirect GET!!");
			
			res.sendRedirect("http://localhost:9001/HelloServlets/dirserv");
			//res.sendRedirect("https://www.google.com");
		}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException
		{
			System.out.println("In indirect Post!!");
			
		/*
		 * RequestDispatcher redis = req.getRequestDispatcher( "/dirserv");
		 */
		/*
		 * RequestDispatcher redis = req.getRequestDispatcher( "/dirserv");
		 */
			RequestDispatcher redis = req.getRequestDispatcher( "/secondpage.html");
			redis.forward(req,  res);
					
		}
}
