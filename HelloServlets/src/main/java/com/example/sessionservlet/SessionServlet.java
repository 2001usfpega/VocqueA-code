package com.example.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.model.SuperVillain;

public class SessionServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{
		//General JAVA CODE
		System.out.println("IN SESSION GET!!!");
		SuperVillain dannyboy =
				new SuperVillain("Danny Boy", "Technopath", 250_000);
		
		//SESSION CODE
		//this method will get the current session OR create one if there is no
		//current session. getSession(false) will ONLY retrieve a session or return null
		// if there isn't one.
		HttpSession session = req.getSession();
		session.setAttribute("currentVillain", dannyboy);
		
		//GENERAL SERVLET CODE
		PrintWriter out = res.getWriter();
		out.println("Danny boy is on the loose!!");
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{
			System.out.println("In Session POST!!!!");
			
			String name = req.getParameter("myname");
			String superpower = req.getParameter("mysuperpower");
			int bounty = Integer.parseInt(req.getParameter("mybounty"));
				
			SuperVillain tempVill =
					new SuperVillain(name, superpower, bounty);
			
			HttpSession session = req.getSession();
			session.setAttribute("currentVillain", tempVill);
			
			PrintWriter out = res.getWriter();
			out.println("The CUSTOM villain " + name + " is on the loose.......");
		
		}
	

}
