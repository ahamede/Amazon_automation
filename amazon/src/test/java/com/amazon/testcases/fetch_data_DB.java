package com.amazon.testcases;

import java.sql.SQLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.lib.DBOperations;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class fetch_data_DB {
	
	public static ExtentTest logger;
	public static ExtentReports report;
	static java.sql.Statement stmt;
	 String s=this.getClass().getSimpleName();
	
	@BeforeTest
	@Parameters({ "dbClass", "dbUrl", "user", "password" })
	public void setup(String dbClass, String dbUrl, String user, String password) throws ClassNotFoundException, SQLException{
		stmt=DBOperations.createdbconnection(dbClass, dbUrl, user, password);
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
		logger = report.startTest(s);
	}
	
	@Test
	@Parameters({ "query" })
	public void executDB(String query) throws SQLException{
		DBOperations.executeQuery(query);
	}
	
}
