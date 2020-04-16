package com.amazon.testcases;

import java.sql.SQLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.lib.DBOperations;
import com.amazon.lib.ExtentReportManager;
import com.amazon.lib.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class fetch_data_DB extends ExtentReportManager{
	
	public static ExtentTest logger;

	static java.sql.Statement stmt;
	 String s=this.getClass().getSimpleName();
	
	@BeforeTest
	@Parameters({ "dbClass", "dbUrl", "user", "password" })
	public void setup(String dbClass, String dbUrl, String user, String password) throws ClassNotFoundException, SQLException{
		stmt=DBOperations.createdbconnection(dbClass, dbUrl, user, password);
		
		logger = report.startTest(s);
		Utility.logInfo(logger, "Database Loaded");
	}
	
	@Test
	@Parameters({ "query" })
	public void executDB(String query) throws SQLException{
		DBOperations.executeQuery(query);
	}
	
}
