package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class ConnectionClass {

	private String DB_URL = "jdbc:mysql://localhost:3306/college";
	private String USER = "root";
	private String PASS = "root";
	private String driverClass = "com.mysql.jdbc.Driver";

	public Connection getConnection() {

		Connection conn = null;
		// loading driver....
		// forname jvm force compile time --> new
		try {
			Class.forName(driverClass); // loaded..
			// getting connection...

			conn = DriverManager.getConnection(DB_URL, USER, PASS); //

			if (conn != null) {

				System.out.println("Connected with database...");
				return conn;
			} else {
				System.out.println("not connected with database..");
				return null;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

public class Assignment_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int sid = Integer.parseInt(request.getParameter("sid"));
		String sfname = request.getParameter("sfname");
		String smname = request.getParameter("smname");
		String slname = request.getParameter("slname");
		String semail = request.getParameter("semail");
		String spassword = request.getParameter("spassword");
		String sphone = request.getParameter("sphone");
		String sgender = request.getParameter("sgender");
		String date = request.getParameter("sdob");
		java.sql.Date sdob = java.sql.Date.valueOf(date);
		
		ConnectionClass getConn = new ConnectionClass();
		
		Connection conn = getConn.getConnection();
		
		String sql = "insert into student2(sid,sfname,smname,slname,semail,spassword,sphone,sdob,sgender) values(?,?,?,?,?,?,?,?,?)";
		
		if(conn != null) {
			System.out.println("inside if");
			try {
				System.out.println("id  = " + sid);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, sid);
				pstmt.setString(2, sfname);
				pstmt.setString(3, smname);
				pstmt.setString(4, slname);
				pstmt.setString(5, semail);
				pstmt.setString(6, spassword);
				pstmt.setString(7, sphone);
				pstmt.setDate(8, sdob);
				pstmt.setString(9, sgender);
				
				System.out.println("query compiled");
				if(pstmt.executeUpdate() > 0) {
					System.out.println("Quety Executted!!!");
					response.sendRedirect("DisplayStudent.jsp");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		doGet(request, response);
	}

}
