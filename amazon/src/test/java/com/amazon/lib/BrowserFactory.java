package com.amazon.lib;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BrowserFactory {

	static WebDriver driver;
	public static ExtentTest logger;


	public static WebDriver startBrowser(String browser, String url) {
		if (browser.equalsIgnoreCase("FireFox")) {
			FirefoxProfile p = new FirefoxProfile();
		
			p.setAcceptUntrustedCertificates(true);
			p.setAssumeUntrustedCertificateIssuer(false);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("Chrome")) {



			String DRIVER_PATH =System.getProperty("user.dir")+"\\resources\\chromedriver.exe"; 

			System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
				
			DesiredCapabilities capabilities = new DesiredCapabilities();

			capabilities.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));

			capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);

			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);

			

			//capabilities.setCapability(ChromeOptions.CAPABILITY, options);


			driver = new ChromeDriver();
			 
			

			driver.manage().deleteAllCookies();

			driver.manage().window().maximize();
			
			try {
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			} catch (Exception e) {
				System.out.println("Going to catch block");
			}


		} else if (browser.equalsIgnoreCase("IE")) {

			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
			capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, true);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			String DRIVER_PATH =System.getProperty("user.dir")+"\\src\\test\\resources\\IEDriverServer.exe"; 
			System.setProperty("webdriver.ie.driver", DRIVER_PATH);
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

		}

	
		else {

			Reporter.log("Incorrect 'Web Browser' name provided");

		}
		driver.navigate().to(url);    

return driver;
	}
`





	}


