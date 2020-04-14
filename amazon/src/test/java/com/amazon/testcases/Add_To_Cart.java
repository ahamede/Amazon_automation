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
import com.amazon.lib.Utility;
import com.amazon.pages.add_to_cart;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Add_To_Cart {

	static WebDriver driver;
	public static ExtentTest logger;
	public static ExtentReports report;
     String s=this.getClass().getSimpleName();
	@BeforeTest
	@Parameters({ "browser", "url" })
	public void setup(String browser, String url) {
		driver=BrowserFactory.startBrowser(browser, url);

		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
		logger = report.startTest(s);
		logger.log(LogStatus.INFO, "Browser : " + browser);
		logger.log(LogStatus.INFO, "URL : " + url);
	}

	@Test
	public void add_items_cart() throws InterruptedException, AWTException {
		add_to_cart a = PageFactory.initElements(driver, add_to_cart.class);
		a.adding_cart(logger);
		a.delete();
		
	}

	@AfterMethod
	public void tearDownReport(ITestResult result) {

		System.out.println("Test in After Method");

		if (result.getStatus() == ITestResult.FAILURE) {
	
			Utility.logFail(logger, result.getThrowable().getMessage());
		}

		if (result.getStatus() == ITestResult.SUCCESS) {

			//logger.log(LogStatus.PASS, logger.addScreenCapture(Utility.CaptureScreenshot(driver)));

			Utility.logPass(logger, "Test Completed Successfully");
		}

		report.endTest(logger);
		report.flush();
		driver.quit();

	}


}
