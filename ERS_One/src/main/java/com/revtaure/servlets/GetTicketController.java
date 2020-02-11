package com.revtaure.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ERS_Dao_Impl;
import com.revature.model.ExpenseModel;

/**
 * Servlet implementation class GetTicketController
 */
public class GetTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public static String submit(HttpServletRequest req) {
    	   
    	   HttpSession session = req.getSession();
    	   
    	   ExpenseModel expmod = (ExpenseModel)session.getAttribute("loggeduser");
    	   if(expmod == null) {
    		   return "resources/html/BadLogin.html";
    	   }
    	   int type = Integer.parseInt(req.getParameter("type"));
    	   int amount = Integer.parseInt(req.getParameter("Amount"));
    	   String expDesc = req.getParameter("Additional Notes");
    	   
    	   ERS_Dao_Impl edi = new ERS_Dao_Impl();
    	   ExpenseModel em = new ExpenseModel();
    	   
    	   //edi.insertExp(em.ticket_id, type, amount, em.date_sub, em.date_res, em.exp_stat, expDesc, em.exp_userID);
    	   
    	   
    	   return "/resources/html/ThankYou.html";
       }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTicketController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
   HttpSession session = request.getSession();
    	   
    	   ExpenseModel expmod = (ExpenseModel)session.getAttribute("loggeduser");
    	   if(expmod == null) {
    		   RequestDispatcher rd = request.getRequestDispatcher("resources/html/BadLogin.html");
    	   }
    	   int type = Integer.parseInt(request.getParameter("type"));
    	   int amount = Integer.parseInt(request.getParameter("Amount"));
    	   String expDesc = request.getParameter("Description");
    	   
    	   ERS_Dao_Impl edi = new ERS_Dao_Impl();
    	   ExpenseModel em = new ExpenseModel();
    	   
    	   edi.insertExp( type, amount, "Pending" , expDesc, 1015);
    	   
    	   
    	   request.getRequestDispatcher("/resources/html/ThankYou.html").forward(request, response);
	}

}
