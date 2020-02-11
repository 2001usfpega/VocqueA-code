package com.revtaure.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ERS_Dao_Impl;

/**
 * Servlet implementation class SeeEmployeeTable
 */
public class SeeEmployeeTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public ERS_Dao_Impl ersDao = new ERS_Dao_Impl();
    public SeeEmployeeTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println(ersDao.url);
		response.getWriter().append(ersDao.allTheEmployees().toString()).append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		/*
		 * PrintWriter pw = response.getWriter(); response.setContentType("text/html");
		 * String ers_employee = request.getParameter("ers_employee");
		 */
		
	}

}
