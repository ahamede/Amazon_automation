package com.amazon.lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WaitLib {
	
	
	public static WebElement fluentWaitID(WebDriver driver,final String lid){
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(30, TimeUnit.SECONDS)
	            .pollingEvery(5, TimeUnit.SECONDS)
	            .ignoring(NoSuchElementException.class);

	    WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver driver) {
	            return driver.findElement(By.id(lid));
	        }
	    }  		
	   );

	    return  element;
	}
	
public static WebElement fluentWaitXpath(WebDriver driver,final String lxpath){
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(200, TimeUnit.SECONDS)
	            .pollingEvery(5, TimeUnit.SECONDS)
	            .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);

	    WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver driver) {
	            return driver.findElement(By.xpath(lxpath));
	        }
	    }  		
	   );

	    return  element;
	}
	
	
	public static void sleep(int time){
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void waitUntil(WebDriver driver, WebElement element, long timeOutInSeconds) {
	    new WebDriverWait(driver, timeOutInSeconds)
	            .ignoring(NoSuchElementException.class)
	            .ignoring(StaleElementReferenceException.class).ignoring(TimeoutException.class)
	            .until(ExpectedConditions.visibilityOf(element));
	}
	
	public static WebElement explicitWaitID(WebDriver driver,int time,final String lid){
	
		WebDriverWait wait=new WebDriverWait(driver, time);
		
       WebElement element=	wait.until(ExpectedConditions.presenceOfElementLocated(By.id(lid)));
       
       return element;
	}
	
	public static WebElement explicitWaitXpath(WebDriver driver,int time,final String xpath){
	
		WebDriverWait wait=new WebDriverWait(driver, time);
		
       WebElement element=	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
       
       return element;
	}
	
  public static WebElement explicitWaitXpath_new(WebDriver driver,int time,final String xpath){
				
		WebDriverWait wait=new WebDriverWait(driver, time);
		
       WebElement element=	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
       
       return element;
	}

}
