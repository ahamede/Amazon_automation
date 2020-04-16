package com.amazon.lib;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DBOperations {
	
	static java.sql.Connection con = null;
	static java.sql.Statement stmt;
	static ExtentTest logger;
	
	
	public static java.sql.Statement createdbconnection(String dbClass,String dbUrl, String user, String password) throws ClassNotFoundException, SQLException{
		Class.forName(dbClass);
		con=DriverManager.getConnection(dbUrl, user, password);
	   
		System.out.println("Database Loaded");
	    stmt=con.createStatement();
	    return stmt;
	}
	
	public static void executeQuery(String query) throws SQLException{
		java.sql.ResultSet res=stmt.executeQuery(query);
		while (res.next())
		{
		System.out.print(res.getString(1));
	
		System.out.print("  " + res.getString(2));
		System.out.print("  " + res.getString(3));
		System.out.println("    " + res.getString(4));
		}
	}

	public static void closeConnection() throws Exception {
		// Close DB connection
		if (con != null) {
		con.close();
		}
		}
}
