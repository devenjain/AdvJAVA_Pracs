package com;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

class GetDBConnection {

	private String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
	private String USER = "postgres";
	private String PASS = "postgres";
	private String driverClass = "org.postgresql.Driver";

	public Connection getPGConnection() {

		Connection conn = null;
		// loading driver....
		// forname jvm force compile time --> new

		try {
			Class.forName(driverClass);
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
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}

class DAO {

	Connection conn = null;

	DAO(Connection conn) {
		this.conn = conn;
	}

	int createTable() {

		try {
			Statement stmt = conn.createStatement();

			String sql = "create table Student(" + "id integer primary key, " + "name varchar(30), "
					+ "email varchar(50) unique" + ")";

			int result = stmt.executeUpdate(sql);

			System.out.println("Table Created...");

			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	int insertUsingStatement() {

		try {
			Statement stmt = conn.createStatement();

			String sql = "insert into Student(id,name,email) values(101,'Deven','deven@gmail.com')";
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	int insertUsingPrepared(int id, String name, String email) {

		try {

			String sql = "insert into Student(id,name,email) values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, email);

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	boolean insertUsingCallable(int id, String name, String email) {

		String sql = "insert into Student(id,name,email) values(?,?,?)";

		CallableStatement cs;
		try {
			cs = conn.prepareCall(sql);
			cs.setInt(1, id);
			cs.setString(2, name);
			cs.setString(3, email);

			return cs.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}

public class Practical_4 {

	public static void studentData() {
		System.out.println();
		System.out.println("===================================================");
		System.out.println("                   Student Data                         ");
		System.out.println("===================================================");
		System.out.println("Name       : Chopra Deven M");
		System.out.println("Class      : 6CE-A1");
		System.out.println("Enrollment : 190130107018");
		System.out.println("Subject    : Advance Java");
		System.out.println("Practical  : 2");
		System.out.println("===================================================");
		System.out.println();
	}

	public static void main(String[] args) {

		Practical_4.studentData();

		GetDBConnection connection = new GetDBConnection();

		Connection conn = connection.getPGConnection();

		if (conn != null) {

			DAO dao = new DAO(conn);

			if (dao.createTable() > 0)
				System.out.println("Table Created...");
			if (dao.insertUsingStatement() > 0)
				System.out.println("Record Inserted Using Statement");
			if (dao.insertUsingPrepared(301, "Chopra", "Chopra@gmail.com") > 0)
				System.out.println("Record Inserted Using Prepared Statement");
			if (dao.insertUsingCallable(201, "Akshay", "Kumar@gmail.com"))
				System.out.println("Record Inserted Using CalledStatement");

		}

	}
}
