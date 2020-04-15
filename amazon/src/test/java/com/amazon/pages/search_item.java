package com.amazon.pages;

import java.awt.AWTException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amazon.lib.Helper;
import com.amazon.lib.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class search_item {
	public WebDriver driver;
	public static ExtentTest logger;
	public static ExtentReports report;

	public search_item(WebDriver driver){
		this.driver=driver;		
	}
   
	By enter_search=By.xpath("//input[@id='twotabsearchtextbox']");
	By click_item=By.xpath("(//img[@data-image-index='0'])[1]");
	By wish_list=By.xpath("//input[@id='add-to-wishlist-button-submit']");
	By list_check=By.xpath("//div[@id='WLHUC_result']");
	public WebDriver  searching_item(ExtentTest logger) throws InterruptedException, AWTException{
		Helper.getElementByXpath(driver, enter_search, 5).click();
		Helper.getElementByXpath(driver, enter_search, 5).sendKeys("Bracelet");
		Helper.getElementByXpath(driver, enter_search, 5).sendKeys(Keys.ENTER);
		Helper.getElementByXpath(driver, click_item, 10).click();
		Thread.sleep(3000);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
		Helper.getElementByXpath(driver, wish_list, 20).click();
		Thread.sleep(4000);
		WebElement wish_list_check=Helper.getElementByXpath(driver, list_check, 5);
		if(wish_list_check.isDisplayed()){
			System.out.println("Item is wish listed");
			logger.log(LogStatus.PASS, "Item is wishlisted");
		}
		else{
			System.out.println("Item is not wishlisted");
			logger.log(LogStatus.FAIL, "Items Not wishlisted");
			Utility.getScreenshot(driver);
		}		
return driver;
	}
	
	

}
