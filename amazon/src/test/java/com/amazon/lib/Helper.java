package com.amazon.lib;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

        elementHighlight(driver, element);
        
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

public static void elementHighlight(WebDriver driver, WebElement Webelement) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String originalStyle = Webelement.getAttribute("style");
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
                                      Webelement);
        try {
                       Thread.sleep(100);
        } catch (Exception e) {

        }
        js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", Webelement);

}

public static String getXPathByContainsID(String id)
{
        String xpath="//*[contains(@id,'"+id+"')]";
        
        return xpath;
}

public static String getXPathByTagContainsID(String tag,String id)
{
        String xpath="//"+tag+"[contains(@id,'"+id+"')]";
        
        return xpath;
}

public static String getXPathByContainsClass(String id)
{
        String xpath="//*[contains(@class,'"+id+"')]";
        
        return xpath;
}


public static String getXPathByContainsText(String text)
{
        String xpath="//*[contains(@class,'"+text+"')]";
        
        return xpath;
}

public static void Check_Uncheck_CheckBox(String check_flag, WebDriver driver,By xpath) throws InterruptedException
{
	
	System.out.println("enyered cb");
	Thread.sleep(4000);
	WebElement element=driver.findElement(xpath);
	
	System.out.println("webelement status:"+element.isDisplayed());
	if (check_flag.equals("check")) {
		
		try {
			String text=element.getAttribute("class");
			System.out.println(text);
			System.out.println("verifying cb");
		   	 if (text.contains("Off"))
				{   
		   		System.out.println("entered try block if clause");
		   		
		   		Thread.sleep(8000);
					//check the checkbox
					element.click();
					Thread.sleep(8000);
					System.out.println("clicked off");
				}
		   	 }
   	 catch(Exception e)
   	 {  System.out.println("entered catch");
   		JavascriptExecutor je = (JavascriptExecutor) driver;		
   		WebElement element1=driver.findElement(xpath);
   		je.executeScript("window.scrollBy(0,250)", "");
   		je.executeScript("arguments[0].scrollIntoView(true);",element1);
   	    Thread.sleep(5000);
   	 System.out.println("srolled");
   	    String text=element1.getAttribute("class");
   	    if (text.contains("Off"))
		{
   	    	Thread.sleep(8000);
			//check the checkbox
			element1.click();
			Thread.sleep(8000);
			System.out.println("clicked");
		}
   	 }
   	 }
	
    
    if (check_flag.equals("uncheck")) {
		
		String text;
		try {
			text = driver.findElement(xpath).getAttribute("class");
			if (text.contains("On"))

			{
				//uncheck the check box
				Thread.sleep(8000);
				driver.findElement(xpath).click();
				Thread.sleep(8000);
				System.out.println("clicked on");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JavascriptExecutor je = (JavascriptExecutor) driver;	
			je.executeScript("window.scrollBy(0,250)", "");
	   		je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(xpath));
	   	    Thread.sleep(8000);
	   	    text=driver.findElement(xpath).getAttribute("class");
	   	    if (text.contains("On"))
			{
				//uncheck the checkbox
	   	    	Thread.sleep(8000);
	   	    	driver.findElement(xpath).click();
	   	    	Thread.sleep(8000);
				System.out.println("clicked on");
			}
		}
		}

		
	}
   
    public static void enable_disable_radio(String check_button, WebDriver driver, By xpath) throws InterruptedException {
    	
    	System.out.println("entered button");
    	Thread.sleep(4000);
    	WebElement element1=driver.findElement(xpath);
    	System.out.println("webelement status:"+element1.isDisplayed());
    	if (check_button.equals("enable")) {
    		String text=element1.getAttribute("class");
			System.out.println(text);
			System.out.println("verifying button");
		   	 if (text.contains("Off"))
				{   
		   		System.out.println("entered  if clause");
		   		
		   		Thread.sleep(8000);
					//check the checkbox
					element1.click();
					Thread.sleep(8000);
					System.out.println("clicked button");
				}
		   	 }
    	if (check_button.equals("disable")) {
    		String text=element1.getAttribute("class");
			System.out.println(text);
			System.out.println("verifying button");
		   	 if (text.contains("On"))
				{   
		   		System.out.println("entered  if clause");
		   		
		   		Thread.sleep(8000);
					//check the checkbox
					element1.click();
					Thread.sleep(8000);
					System.out.println("clicked button");
				}
		   	 }
    	}
    
    		
    	}

	

