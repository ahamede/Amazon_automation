package com.amazon.lib;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickEvents {
	

	public static void clickUsingJS(WebDriver ldriver,String lxpath){
		
		WebElement elem = ldriver.findElement(By.xpath(lxpath));
		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		((JavascriptExecutor)ldriver).executeScript(js, elem);
		 elem.click();
		 ElementHighlight.higtLight(ldriver, lxpath);
		 System.out.println("Click performed using JS");
	}
	
	public static void clickUsingJSID(WebDriver ldriver,String lid){
		
		WebElement elem = ldriver.findElement(By.id(lid));
		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		((JavascriptExecutor)ldriver).executeScript(js, elem);
		 elem.click();
		 System.out.println("Click performed using JS");
	}
	

}
