package com.amazon.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.lib.BrowserFactory;
import com.amazon.pages.loginpage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class login {
	
	WebDriver driver;
	public static ExtentTest logger;
	public static ExtentReports report;
	
	@BeforeTest
	@Parameters({ "browser", "url" })
	public void setup(String browser, String url){
		driver=BrowserFactory.startBrowser(browser, url);	
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
		logger = report.startTest("Login to Amazon");
	}

	@Test
	@Parameters({ "email", "password" })
	public void loginamazon(String email, String password){
		loginpage l=PageFactory.initElements(driver, loginpage.class);
		l.loginbyemail(email, password);
	}
		
	@AfterTest
	public void tearDownReport() 
	{
driver.quit();
}
}
