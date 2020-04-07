package com.amazon.lib;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class switchframes 
	{

		public static void switchUsingIndex(WebDriver driver,int index)
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);

			wait.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(index));
		}
		
		public static void switchUsingNameOrId(WebDriver driver,String nameId)
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);

			wait.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(nameId));
		}
		
		
		public static void switchUsingWebElement(WebDriver driver,WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);

			wait.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(element));
		}
		
		public static void switchToParentframe(WebDriver driver) throws InterruptedException
		{
			
				driver.switchTo().defaultContent();
				Thread.sleep(1700);
			
				
			}
		}
						
	


