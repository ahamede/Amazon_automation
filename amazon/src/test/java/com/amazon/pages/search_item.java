package com.amazon.pages;

import java.awt.AWTException;
import org.testng.asserts.*;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amazon.lib.Helper;
import com.amazon.lib.Scroll;
import com.amazon.lib.SelectDropdown;
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
	//By click_item=By.xpath("(//img[@data-image-index='1'])[1]");
	By click_item=By.xpath("//img[contains(@alt,'Authentic Aged')]");
	By add_to_cart=By.xpath("//input[@name='submit.add-to-cart']");
	By check_out=By.xpath("//h1[contains(.,'Added to Cart')]");
	By item_type=By.xpath("//*[@id=\\\"p_89/Kohinoor\\\"]/span/a/div/label/i");
	By quantity=By.xpath("//select[@name='quantity']");
	By lang_btn=By.xpath("//span[@class='icp-nav-globe-img-2']");
	By hindi_lang=By.xpath("(//div[@data-a-input-name='LOP']) [2] //i");
	By Eng_lang=By.xpath("(//div[@data-a-input-name='LOP']) [1] //i");
	By lang_save=By.xpath("//input[@aria-labelledby='icp-btn-save-announce']");
	String vtext="2";
	public WebDriver  searching_item(ExtentTest logger) throws InterruptedException, AWTException{
		
		//radio_button
		Helper.getElementByXpath(driver, lang_btn,5).click();
		Helper.getElementByXpath(driver, hindi_lang,5).click();
		Thread.sleep(3000);
		Helper.getElementByXpath(driver, Eng_lang,5).click();
		Thread.sleep(3000);
		Helper.getElementByXpath(driver,lang_save ,5).click();
		
		
		Helper.getElementByXpath(driver, enter_search, 5).click();
		Helper.getElementByXpath(driver, enter_search, 5).sendKeys("Rice");
		Helper.getElementByXpath(driver, enter_search, 5).sendKeys(Keys.ENTER);
	
		//check_box
		Assert.assertFalse(Helper.getElementByXpath(driver, item_type,5).isSelected());
		Helper.getElementByXpath(driver, item_type, 5).click();
		Thread.sleep(3000);
		Assert.assertTrue(Helper.getElementByXpath(driver, item_type,5).isSelected()); 
		
		
		//scroll
		WebElement item=Helper.getElementByXpath(driver,click_item ,5);
		Scroll.scroll_by_visible_element(driver,item);
		Thread.sleep(3000);
		Helper.getElementByXpath(driver, click_item, 5).click();
		Thread.sleep(3000);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    
	    //select functionality
	    WebElement ele=Helper.getElementByXpath(driver,quantity,5);
	    SelectDropdown.select_by_visibleText(ele,vtext);
	    Thread.sleep(3000);
	    
	    //comparing the value selected with desired 
	    WebElement Element_name=Helper.getElementByXpath(driver,quantity,5);
	    	String txt=Element_name.getText();
	    	if(txt.equals(vtext))
	    	{
	    		System.out.println("value verified");
	    	}
	    	else
	    	{
	    		System.out.println("data value mismatch error");
	    		logger.log(LogStatus.FAIL, "Data value mismatch");
	    		Utility.getScreenshot(driver);
	    	}
	    	
	    
	  //  Assert.assertEquals(Helper.getElementByXpath(driver, quantity,5).getText(),"2");
	    
		Helper.getElementByXpath(driver, add_to_cart, 20).click();
		Thread.sleep(4000);
		
		WebElement cart_add_check=Helper.getElementByXpath(driver, check_out, 5);
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
	
	
	
	
	

}
