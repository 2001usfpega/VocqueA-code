package com.example.indirectservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class indirect2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException
		{
			res.sendRedirect("https://www.ask.com/");
		}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException
		{
		
					System.out.println("Hey, click something else");
		}

}
