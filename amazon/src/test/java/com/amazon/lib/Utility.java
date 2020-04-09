package com.amazon.lib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ErrorCodes;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;

public class Utility {

    static WebDriver driver;
	public ErrorCodes errCol = new ErrorCodes();
	public static SoftAssert sAssert = new SoftAssert();
	public static String DRIVER_PATH;
	public static String reportpath;
	public static String time;
	public static ExtentTest logger;
	

	public Utility() {
		try {
			if (System.getProperty("webdriver.path").isEmpty() || System.getProperty("webdriver.path").equals(null)) {
				DRIVER_PATH = Utility.class.getClassLoader().getResource("chromedriver(2.19).exe").getFile();
			} else {
				DRIVER_PATH = System.getProperty("webdriver.path");
			}
		} catch (Exception e) {
			DRIVER_PATH = Utility.class.getClassLoader().getResource("chromedriver(2.19).exe").getFile();
		}

		System.out.println("Driver picked from path: " + DRIVER_PATH);
		// this.sAssert = new SoftAssert();
	}

	

	

	// **********************************************************************************

	public static String getScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
		
		File destination=new File(path);
		
		try 
		{
			FileUtils.copyFile(src, destination);
		} catch (IOException e) 
		{
			System.out.println("Capture Failed "+e.getMessage());
		}
return path;
	}


		
		

}
