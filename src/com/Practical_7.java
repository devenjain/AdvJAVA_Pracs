package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Practical_7 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String userID = "Tanmay";
	private final String password = "Dayal";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");

		if (userID.equals(user) && password.equals(pwd)) {
			Cookie loginCookie = new Cookie("user", user);
			// setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30 * 60);
			response.addCookie(loginCookie);
			response.sendRedirect("LoginSuccess.jsp");
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either user name or password is wrong!!</font>");
			rd.include(request, response);
		}

		doGet(request, response);
	}

}
