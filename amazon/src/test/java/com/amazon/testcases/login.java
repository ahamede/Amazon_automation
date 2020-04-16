package com.amazon.testcases;

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
import com.amazon.pages.loginpage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class login  extends ExtentReportManager{
	 
	WebDriver driver;
	public static ExtentTest logger;

	
	@BeforeTest
	@Parameters({ "browser", "url" })
	public void setup(String browser, String url){
		driver=BrowserFactory.startBrowser(browser, url);	
		logger = report.startTest("Login to Amazon");
		logger.log(LogStatus.INFO, "Browser : " + browser);
		logger.log(LogStatus.INFO, "URL : " + url);
	}

	@Test
	@Parameters({ "email", "password" })
	public void loginamazon(String email, String password){
		loginpage l=PageFactory.initElements(driver, loginpage.class);
		l.loginbyemail(email, password);
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
