package com.amazon.testcases;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.lib.BrowserFactory;
import com.amazon.lib.ExtentReportManager;
import com.amazon.lib.Utility;
import com.amazon.pages.search_item;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Search_Item extends ExtentReportManager{

	static WebDriver driver;
	public static ExtentTest logger;
	
     String s=this.getClass().getSimpleName();
	@BeforeTest
	@Parameters({ "browser", "url" })
	public void setup(String browser, String url) {
		driver=BrowserFactory.startBrowser(browser, url);

		logger = report.startTest(s);
		logger.log(LogStatus.INFO, "Browser : " + browser);
		logger.log(LogStatus.INFO, "URL : " + url);
	}

	@Test
	public void search_for_item() throws InterruptedException, AWTException {
		search_item a = PageFactory.initElements(driver, search_item.class);
		a.searching_item(logger);
	
		
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
