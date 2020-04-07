package com.amazon.lib;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Helper {

	public static void checkElement(WebDriver driver, By xpath, int time)
	{
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(time, TimeUnit.SECONDS)
                                      .pollingEvery(1, TimeUnit.SECONDS).ignoring(Throwable.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
        wait.until(ExpectedConditions.visibilityOfElementLocated((xpath)));
        wait.until(ExpectedConditions.elementToBeClickable((xpath)));
}
	
	public static void checkElementNew(WebDriver driver,String xpath, int time)
	{
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(time, TimeUnit.SECONDS)
                                      .pollingEvery(1, TimeUnit.SECONDS).ignoring(Throwable.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
       // wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(xpath))));
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath(xpath))));
}

	public static WebElement WaitAndfindElementNew(WebDriver driver, String xpath_wait, int time) 
	{
	        checkElementNew(driver, xpath_wait, time);
	        return driver.findElement(By.xpath(xpath_wait));
	}
	
public static WebElement WaitAndfindElement(WebDriver driver, By xpath_wait, int time) 
{
        checkElement(driver, xpath_wait, time);
        return driver.findElement(xpath_wait);
}

public static List<WebElement> WaitAndfindElements(WebDriver driver, By xpath_wait, int time) 
{
        checkElement(driver, xpath_wait, time);
        return driver.findElements(xpath_wait);
}

public static WebElement getElementByXpath(WebDriver driver, By xpath_wait, int time) {
        WebElement element = WaitAndfindElement(driver, xpath_wait, time);


        
        try {
                       Thread.sleep(2000);
        } catch (InterruptedException e) {
        	
        
                       
        }
        
        //WebElement element1 = WaitAndfindElement(driver, xpath_wait, time);

        return element;

}

public static List<WebElement> getElementsByXpath(WebDriver driver, By xpath_wait, int time) {
        List<WebElement> element = WaitAndfindElements(driver, xpath_wait, time);

        
        
        //WebElement element1 = WaitAndfindElement(driver, xpath_wait, time);

        return element;

}
    	}
    
    		
    	

	

