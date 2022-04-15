package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class GetDBConnection5 {

	private String DB_URL = "jdbc:mysql://localhost:3306/college";
	private String USER = "root";
	private String PASS = "root";
	private String driverClass = "com.mysql.jdbc.Driver";

	public Connection getPGConnection() {

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

class DAO5 {

	Connection conn = null;
	PreparedStatement pstmt;
	ResultSet rs;

	DAO5(Connection conn) {
		this.conn = conn;
	}

	public int insertProduct(int id, String name, int mnf, int exp, int price) {

		try {

			String sql = "insert into Product(prod_id,prod_name,pro_mnf_year,pro_exp_year,prod_price) values(?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, mnf);
			pstmt.setInt(4, exp);
			pstmt.setInt(5, price);

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public void displayRecords() {

		try {

			String select = "select * from Product";

			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();

			System.out.println(
					"=======================================================================================================");
			System.out.println();
			System.out.format("%8s | %-12s | %10s | %10s | %10s", "Prod_ID", "Prod_Name", "Pro_MNF_Year",
					"Pro_Exp_Year", "Price");
			System.out.println();
			System.out.println(
					"   --------------------------------------------------------------------------------------------------");
			System.out.println();

			while (rs.next()) {

				System.out.format("%8s | %-12s | %10s | %10s | %10s", rs.getInt("prod_id"), rs.getString("prod_name"),
						rs.getInt("pro_mnf_year"), rs.getInt("pro_exp_year"), rs.getInt("prod_price"));
				System.out.println();
			}
			System.out.println(
					"   --------------------------------------------------------------------------------------------------");
			System.out.println();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int deletRecord(int year) {

		int result = 0;

		if (conn != null) {

			String delete = "delete from Product where pro_exp_year= ?";

			try {

				pstmt = conn.prepareStatement(delete);
				pstmt.setInt(1, year);

				result = pstmt.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public void displaySpecific(int first, int second, int third) {

		try {

			String select = "select * from PRODUCT where prod_id = ? or prod_id = ? or prod_id = ?";

			pstmt = conn.prepareStatement(select);

			pstmt.setInt(1, first);
			pstmt.setInt(2, second);
			pstmt.setInt(3, third);

			rs = pstmt.executeQuery();

			System.out.println(
					"=======================================================================================================");
			System.out.println();
			System.out.format("%8s | %-12s | %10s | %10s | %10s", "Prod_id","Prod_Name", "Pro_MNF_Year", "Pro_Exp_Year",
					"Price");
			System.out.println();
			System.out.println(
					"   --------------------------------------------------------------------------------------------------");
			System.out.println();

			while (rs.next()) {

				System.out.format("%8s | %-12s | %10s | %10s | %10s", rs.getInt("prod_id"), rs.getString("prod_name"),
						rs.getInt("pro_mnf_year"), rs.getInt("pro_exp_year"), rs.getInt("prod_price"));
				System.out.println();
			}
			System.out.println(
					"   --------------------------------------------------------------------------------------------------");
			System.out.println();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int updateRecord(int exp_year, int mnf_year) {

		int result = 0;

		if (conn != null) {

			String Update = "update Product set pro_exp_year = ? where pro_mnf_year= ?;";

			try {

				pstmt = conn.prepareStatement(Update);
				pstmt.setInt(1, exp_year);
				pstmt.setInt(2, mnf_year);

				result = pstmt.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return result;
	}

	public void batchManagement(int delYear, int exp_year, int mnf_year) {

		String update = "update Product set pro_exp_year = '" + exp_year + "' where pro_mnf_year= '" + mnf_year + "'";
		String delete = "delete from Product where pro_exp_year= '" + delYear + "'";

		try {
			Statement stmt = conn.createStatement();

			stmt.addBatch(update);
			stmt.addBatch(delete);

			stmt.executeBatch();// executing the batch

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

public class Practical_5 {

	public static void studentData() {
		System.out.println();
		System.out.println("===================================================");
		System.out.println("                   Student Data                         ");
		System.out.println("===================================================");
		System.out.println("Name       : Chopra Deven M");
		System.out.println("Class      : 6CE-A1");
		System.out.println("Enrollment : 190130107018");
		System.out.println("Subject    : Advance Java");
		System.out.println("Practical  : 5");
		System.out.println("===================================================");
		System.out.println();
	}

	public static void main(String[] args) {

		Practical_5.studentData();

		GetDBConnection5 dbConn = new GetDBConnection5();

		Connection connection = dbConn.getPGConnection();

		DAO5 dao = new DAO5(connection);

		int choice = 0;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println();
			System.out.println("1 --- Insert Product");
			System.out.println("2 --- Display all Employees Details");
			System.out.println("3 --- Delete data whose Pro_Exp_year=2012");
			System.out.println("4 --- Display Product details whose Prod_id is 101, 102 ,103");
			System.out.println("5 --- Update information Pro_Exp_year=2014 whose Pro_MNF_year=2012.");
			System.out.println("6 --- Perform actions 3 & 5 using Batch Management");
			System.out.println("7 --- Exite");
			choice = sc.nextInt();

			switch (choice) {

			case 1:

				System.out.print("Enter Product ID  : ");
				int pid = sc.nextInt();
				System.out.print("Enter Product Name : ");
				String pname = sc.next();
				System.out.print("Enter MNF year       : ");
				int pmnf = sc.nextInt();
				System.out.print("Enter EXP year  : ");
				int pexp = sc.nextInt();
				System.out.print("Enter Product Price : ");
				int pprice = sc.nextInt();

				if (dao.insertProduct(pid, pname, pmnf, pexp, pprice) > 0)
					System.out.println("Record Inserted!");

				break;

			case 2:

				dao.displayRecords();

				break;

			case 3:
				if (dao.deletRecord(2012) > 0)
					System.out.println("Record Deleted!!");
				break;

			case 4:
				dao.displaySpecific(101, 102, 103);
				break;

			case 5:
				if (dao.updateRecord(2014, 2012) > 0)
					System.out.println("Record Updated!");
				break;

			case 6:
				dao.batchManagement(2012, 2014, 2012);
				break;
			} // end of switch

		} while (choice != 7); // end do while loop

	} // end of main
}
