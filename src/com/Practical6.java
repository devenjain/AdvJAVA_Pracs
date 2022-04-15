package com;
//importing the javax.servlet package
//importing java.io package for PrintWriter
import javax.servlet.*;
import java.io.*;

//now creating a servlet by implementing Servlet interface
public class Practical6 implements Servlet {

	ServletConfig config = null;

	// init method
	public void init(ServletConfig sc)
	{
		config = sc;
		System.out.println("in init");
	}

	// service method
	public void service(ServletRequest req, ServletResponse res)
		throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<h2>This is Service Method");
		System.out.println("in service");
	}

	// destroy method
	public void destroy()
	{
		System.out.println("in destroy");
	}
	public String getServletInfo()
	{
		return "LifeCycleServlet";
	}
	public ServletConfig getServletConfig()
	{
		return config; // getServletConfig
	}
}

