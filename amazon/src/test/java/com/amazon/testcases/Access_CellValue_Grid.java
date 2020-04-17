package com.amazon.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.lib.BrowserFactory;
import com.amazon.lib.ExtentReportManager;
import com.amazon.lib.Utility;
import com.amazon.lib.WaitLib;
import com.amazon.pages.AccessGridValues;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Access_CellValue_Grid extends ExtentReportManager{
	
	 WebDriver driver;
	public static ExtentTest logger;

     String s=this.getClass().getSimpleName();
	@BeforeTest
	@Parameters({ "browser", "url" })
	public void setup(String browser, String url) {
		BrowserFactory.killBrowserProcess(browser);
		driver = BrowserFactory.startBrowser(browser, url);
		WaitLib.sleep(2000);
		logger = report.startTest(this.getClass().getSimpleName());
		logger.log(LogStatus.INFO, "Browser : " + browser);
		logger.log(LogStatus.INFO, "URL : " + url);
	}
	
	@Test
	@Parameters({ "rown" })
	public void accessgridvalue(int rown){
		AccessGridValues agv=new AccessGridValues(driver);
		int col=agv.getnumberofColumns();
		Utility.logInfo(logger, "No. of Columns in table is "+col);
		int row=agv.getnumberofrows();
		Utility.logInfo(logger, "No. of Rows in table is "+row);
		agv.readgridvalues(rown);
		
	}
	
	@AfterMethod
	public void tearDownReport(ITestResult result) {

		System.out.println("Test in After Method");

		if (result.getStatus() == ITestResult.FAILURE) {

			Utility.getScreenshot(driver);

			logger.log(LogStatus.FAIL, logger.addScreenCapture(Utility.getScreenshot(driver)));

			Utility.logFail(logger, result.getThrowable().getMessage());
		}

		if (result.getStatus() == ITestResult.SUCCESS) {

		//Utility.CaptureScreenshot(driver);

			//logger.log(LogStatus.PASS, logger.addScreenCapture(jenkinsScreemshot + Utility.time + ".png"));

			Utility.logPass(logger, "Test Completed Successfully");
		}

		report.endTest(logger);
		driver.quit();

	}


}
