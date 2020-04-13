package com.amazon.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyPageTitle {
	
	
	public static void verifyTitle(WebDriver driver,String title){
		
		new WebDriverWait(driver, 120).until(ExpectedConditions.titleContains(title));
		
		System.out.println("Title Verified");
		
	}

}
