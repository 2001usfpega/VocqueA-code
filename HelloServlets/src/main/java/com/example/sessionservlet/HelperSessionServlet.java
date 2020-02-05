package com.example.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.model.SuperVillain;

public class HelperSessionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{
		//GENERAL JAVA CODE
		System.out.println("In helpersession get!!");
		//SESSION CODE
		HttpSession session = req.getSession();
		SuperVillain villain=
				(SuperVillain) session.getAttribute("currentVillain");
		
		//GENERAL SERVLET CODE
		PrintWriter out = res.getWriter();
		out.println("In HelperSession Post!!!");
				
		if(villain != null) {
			out.println("We've captured the villain!");
		out.println("<h1>Villain Name: " + villain.getName() + "</h1><br>");
		out.println("<b>\tSuperpower: " + villain.getSuperpower() + "</b><br>");
		out.println("<i>\tBounty: $" + villain.getBounty() + "</i><br>");
		
		}else {
			out.println("Can't find any villains...");
		}
		
		out.println("</body></html>");
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{
			HttpSession session = req.getSession();
			
			session.invalidate();
			System.out.println("In helpersession fail!");
		
		}

}
