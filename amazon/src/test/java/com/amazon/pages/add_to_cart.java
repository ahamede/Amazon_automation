package com.amazon.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amazon.lib.Helper;
import com.amazon.lib.Utility;
import com.amazon.lib.switchframes;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class add_to_cart {
	public WebDriver driver;
	public static ExtentTest logger;
	public static ExtentReports report;

	public add_to_cart(WebDriver driver){
		this.driver=driver;		
	}
   
	By enter_search=By.xpath("//input[@type='text']");
	By click_item=By.xpath("(//img[@data-image-index='0'])[1]");
	By add_cart=By.xpath("//input[@name='submit.add-to-cart']");
	By cart_check=By.xpath("//h1[contains(.,'Added to Cart')]");
	public WebDriver  adding_cart(ExtentTest logger) throws InterruptedException, AWTException{
		Helper.getElementByXpath(driver, enter_search, 5).click();
		Helper.getElementByXpath(driver, enter_search, 5).sendKeys("shoes");
		Helper.getElementByXpath(driver, enter_search, 5).sendKeys(Keys.ENTER);
		Helper.getElementByXpath(driver, click_item, 10).click();
		Thread.sleep(3000);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
		Helper.getElementByXpath(driver, add_cart, 20).click();
		WebElement cart_add_check=driver.findElement(cart_check);
		if(cart_add_check.isDisplayed()){
			System.out.println("Item added to Cart");
			logger.log(LogStatus.PASS, "Items Added to Cart");
		}
		else{
			System.out.println("Item not added to Cart");
			logger.log(LogStatus.FAIL, "Items Not Added to Cart");
			Utility.getScreenshot(driver);
		}		
return driver;
	}
	
	By cart_check2=By.xpath("(//a[contains(.,'Cart')])[2]");
	By delete1=By.xpath("//input[@value='Delete']");
	public WebDriver delete(){
		Helper.getElementByXpath(driver, cart_check2, 5).click();
		Helper.getElementByXpath(driver, delete1, 5).click();
return driver;
	}
}
