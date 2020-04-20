package com.amazon.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.amazon.lib.ExtentReportManager;
import com.amazon.lib.Read_Excel_Data;
import com.amazon.lib.Utility;
import com.amazon.lib.Write_Excel_Data;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReadWriteExcel extends ExtentReportManager {
	public static ExtentTest logger;
	@Test
	public void readexcel(){
		logger=report.startTest(this.getClass().getSimpleName());
		Read_Excel_Data rwe=new Read_Excel_Data();
	
		logger.log(LogStatus.INFO, rwe.readexceldata(1, 0));

	}
	
	@Test
	public void writeexcel(){
		Write_Excel_Data we=new Write_Excel_Data();
		we.writeexcel(4, 0, "1004");
		we.writeexcel(4, 1, "Surya");
		we.writeexcel(4, 2, "25");
		Read_Excel_Data rwe=new Read_Excel_Data();
		logger.log(LogStatus.INFO, rwe.readexceldata(4, 1));
		logger.log(LogStatus.INFO, rwe.readexceldata(4, 2));
		
	}
	
	@AfterMethod
	public void tearDownReport(ITestResult result) {

		System.out.println("Test in After Method");

		if (result.getStatus() == ITestResult.FAILURE) {

		


			Utility.logFail(logger, result.getThrowable().getMessage());
		}

		if (result.getStatus() == ITestResult.SUCCESS) {

		//Utility.CaptureScreenshot(driver);

			//logger.log(LogStatus.PASS, logger.addScreenCapture(jenkinsScreemshot + Utility.time + ".png"));

			Utility.logPass(logger, "Test Completed Successfully");
		}

		report.endTest(logger);
		
	}


}
