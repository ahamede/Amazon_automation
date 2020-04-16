package com.amazon.lib;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ErrorCodes;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Utility {

    static WebDriver driver;
	public ErrorCodes errCol = new ErrorCodes();
	private static FileWriter fWriter = null;
	private static BufferedWriter writer = null;
	private static String timestamp;
	private static String reportPath;
	public static SoftAssert sAssert = new SoftAssert();
	public static String DRIVER_PATH;
	private static StringBuffer verificationErrors;
	public static String reportpath;
	public static String time; 
	

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

	public static void createReportFolder(String testName) {
		Calendar cal = Calendar.getInstance();
		timestamp = Integer.toString(cal.get(Calendar.DATE)) + Integer.toString(cal.get(Calendar.MONTH) + 1)
				+ Integer.toString(cal.get(Calendar.YEAR)) + Integer.toString(cal.get(Calendar.HOUR))
				+ Integer.toString(cal.get(Calendar.MINUTE)) + Integer.toString(cal.get(Calendar.SECOND));
		reportPath = System.getProperty("user.dir") + "\\target" + "\\Report_" + testName + "\\";
		File repFile = new File(reportPath);
		repFile.mkdirs();
	}

	public static String getCurrentDateTime() {

		Calendar cal = Calendar.getInstance();
		timestamp = Integer.toString(cal.get(Calendar.DATE)) + Integer.toString(cal.get(Calendar.MONTH) + 1)
				+ Integer.toString(cal.get(Calendar.YEAR)) + Integer.toString(cal.get(Calendar.HOUR))
				+ Integer.toString(cal.get(Calendar.MINUTE)) + Integer.toString(cal.get(Calendar.SECOND));

		return timestamp;
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

	public static void logInfo(ExtentTest logger, String msg) {

		logger.log(LogStatus.INFO, "====" + msg + "====");
		System.out.println("====" + msg + "====");
	}

	public static void logPass(ExtentTest logger, String msg) {

		logger.log(LogStatus.PASS, "====" + msg + "====");
		System.out.println("====" + msg + "====");
	}

	public static void logFail(ExtentTest logger, String msg) {
        
		logger.log(LogStatus.FAIL, "====" + msg + "====");
		System.out.println("====" + msg + "====");
	}

/*	public static String initializeHTMLReport(String testName) throws IOException {
		createReportFolder(testName);
		String fPath = reportPath + testName + ".html";
		File repFile = new File(fPath);
		repFile.createNewFile();
		fWriter = new FileWriter(fPath);
		writer = new BufferedWriter(fWriter);
		writer.write("<html><head><title>Selenium Report</title></head><body><table>");
		writer.flush();

		return fPath;
	}
	// *********************************************************************************
	public static void finalizeHTMLReport() throws IOException {
		writer.write("</table></body></html>");
		writer.flush();
		writer.close();
		fWriter.close();
	}
*/

		

}
