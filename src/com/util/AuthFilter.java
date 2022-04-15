package com.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String password = request.getParameter("password");

		if (password.equals("admin")) {
			chain.doFilter(request, response);// sends request to next resource
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("Login8.jsp");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either user name or password is wrong!!</font>");
			rd.include(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
