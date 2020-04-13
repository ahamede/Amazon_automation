package com.amazon.lib;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BrowserFactory {

	static WebDriver driver;


	public static WebDriver startBrowser(String browser, String url) {
		if (browser.equalsIgnoreCase("FireFox")) {
			String DRIVER_PATH = System.getProperty("user.dir") + "\\\resources\\geckodriver.exe";

			System.setProperty("webdriver.gecko.driver", DRIVER_PATH);

			driver = new FirefoxDriver();

			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("Chrome")) {

			String DRIVER_PATH = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";

			System.setProperty("webdriver.chrome.driver", DRIVER_PATH);

			DesiredCapabilities capabilities = new DesiredCapabilities();

			capabilities.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));

			capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);

			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);

			// capabilities.setCapability(ChromeOptions.CAPABILITY, options);

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
			String DRIVER_PATH = System.getProperty("user.dir") + "\\resources\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", DRIVER_PATH);
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

		}

		else if (browser.equalsIgnoreCase("Safari")) {

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
			capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			// Set the driver path
			// String DRIVER_PATH =
			// Utility.class.getClassLoader().getResource("SafariDriver.safariextz").getFile();
			// System.setProperty("webdriver.safari.driver",DRIVER_PATH);

			// Open browser with capability
			driver = new SafariDriver(capabilities);

			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Program Files (x86)\\Microsoft Web Driver\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		}

		else {

			Reporter.log("Incorrect 'Web Browser' name provided");

		}

		driver.navigate().to(url);
		return driver;

	}

	/*
	 * public static void closeBrowser(WebDriver driver) { try {
	 * Utility.passReportandScreenshot("Last screenshot", driver);
	 * Utility.finalizeHTMLReport(); // Utility.testComplete(driver); } catch
	 * (Exception e1) {
	 * 
	 * } driver.close(); try { Thread.sleep(5000); driver.quit(); } catch
	 * (Exception e) { } }
	 */

	public static void killBrowserProcess(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			try {
				WindowsUtils.killByName("chromedriver(2.28).exe");
				System.out.println("Chrome Driver process killed forcefully");
			} catch (Exception e) {
			}
		}

		if (browser.equalsIgnoreCase("firefox")) {
			try {
				WindowsUtils.killByName("firefox.exe");
				System.out.println("Firefox Driver process killed forcefully");
			} catch (Throwable e) {
			}
		}

		if (browser.equalsIgnoreCase("ie")) {
			try {
				WindowsUtils.killByName("IEDriverServer_x32_2.53.1.exe");
				// WindowsUtils.killPID(processID);
				System.out.println("IE Driver process killed forcefully");
			} catch (Exception e) {

			}
		}
	}

}
