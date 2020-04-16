package com.amazon.lib;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportManager {
	
	
		public static ExtentReports report;
			
			@BeforeTest
			public void setUpReport() throws Throwable {

				String htmlFile = "C:\\Automation_Report\\Final_Report";
				 report = new ExtentReports(htmlFile+".html",false);
				
				 
			}
			
			@AfterTest
			public void tearDown() {
		    	
		    	report.flush();
		    	
		    	
				
			}
			 

}
