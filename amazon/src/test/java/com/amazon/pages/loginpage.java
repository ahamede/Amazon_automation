package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.amazon.lib.Helper;

public class loginpage {
	
	public WebDriver driver;
	public loginpage(WebDriver driver){
		this.driver=driver;		
	}
	
	By clicksignin=By.xpath("//span[contains(.,'Hello.')]");
	By signinbutton=By.xpath("//span[contains(.,'Sign in')][2]");
	By enter_email=By.xpath("//input[@type='email']");
	By continue1=By.xpath("//input[@type='submit']");
	By enter_password=By.xpath("//input[@type='password']");
	By login1=By.xpath("//input[@id='signInSubmit']");
	public void loginbyemail(String email, String password){
		Helper.getElementByXpath(driver, clicksignin, 5).click();;
//		Helper.getElementByXpath(driver, signinbutton, 5).click();
		Helper.getElementByXpath(driver, enter_email, 5).click();
		Helper.getElementByXpath(driver, enter_email, 5).sendKeys(email);
		Helper.getElementByXpath(driver, continue1, 5).click();
		Helper.getElementByXpath(driver, enter_password, 5).click();
		Helper.getElementByXpath(driver, enter_password, 5).sendKeys(password);
		Helper.getElementByXpath(driver, login1, 5).click();		 
	}

	
	
}
