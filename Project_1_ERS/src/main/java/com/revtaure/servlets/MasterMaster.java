package com.revtaure.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ERS_Dao_Impl;
import com.revature.model.EmployeeModel;

/**
 * Servlet implementation class LoginController
 */
public class MasterMaster extends HttpServlet {

	public ERS_Dao_Impl ersDao = new ERS_Dao_Impl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public String login(HttpServletRequest req) {

		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");

		System.out.println(userName + passWord);
		EmployeeModel em = ersDao.login(userName, passWord);

		if (em == null) {
			System.out.println("nope");
			return "resources/html/badlogin.html";
		} else if (em.isAdmin == 0) {
			req.getSession().setAttribute("loggeduser", em);
			return "/resources/html/EmployeeHome.html";
		} else if (em.isAdmin == 1) {
			System.out.println("admin");
			req.getSession().setAttribute("loggeduser", em);
			return "/resources/html/AdminHome.html";
		}
		return " ";
	}

	public MasterMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String name = request.getParameter("username");
		String pass = request.getParameter("password");

		if (ersDao.login(name, pass) != null) {

			RequestDispatcher rd = request.getRequestDispatcher("Index.html");
			rd.forward(request, response);
		} else {
			pw.print("This username/password is incorrect");
			RequestDispatcher rd = request.getRequestDispatcher("BadLogin.html");
			rd.include(request, response);

		}

	}
}
