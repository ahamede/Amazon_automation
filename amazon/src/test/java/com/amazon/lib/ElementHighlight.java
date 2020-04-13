package com.amazon.lib;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementHighlight {
	
	
	
	public static void higtLight(WebDriver ldriver,String lxpath){
		
		  JavascriptExecutor js=(JavascriptExecutor)ldriver; 
		  
		  WebElement ele= ldriver.findElement(By.xpath(lxpath)); 
		  
		  String originalStyle = ele.getAttribute("style");
		  
		  js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
		  
		  WaitLib.sleep(500);
		  
		  js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", ele);
		  
		 
	}
	
	
	public static void higtLightElement(WebDriver ldriver,WebElement element){
		
		  JavascriptExecutor js=(JavascriptExecutor)ldriver; 
		  
		  String originalStyle = element.getAttribute("style");
		  
		  js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		  
		  WaitLib.sleep(500);
		  
		  js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);
		  
		 
	}

}
