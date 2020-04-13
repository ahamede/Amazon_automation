package com.amazon.lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class ClickElements {
	
	
	
	public static void clickByXpath(WebDriver ldriver,String lxpath,String logMessage)
	{
		
		try 
		{
			ElementHighlight.higtLight(ldriver, lxpath);
			ldriver.findElement(By.xpath(lxpath)).click();
			Reporter.log(logMessage, true);
		} 
		catch (Exception e) 
		{
			ClickEvents.clickUsingJS(ldriver, lxpath);
			Reporter.log(logMessage, true);
		}
	}
	
	
	
	public static void clickById(WebDriver ldriver,String lid,String logMessage)
	{
		
		try 
		{
			ElementHighlight.higtLight(ldriver, lid);
			ldriver.findElement(By.id(lid)).click();
		} 
		catch (Exception e)
		{
			ClickEvents.clickUsingJSID(ldriver, lid);
			Reporter.log(logMessage, true);
		}
	}

}
