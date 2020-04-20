package com.amazon.lib;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scroll {

	public static void scroll_by_pixel(WebDriver driver,int x,int y)
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(x,y)");
	}
	
	public static void scroll_by_visible_element(WebDriver driver,WebElement element)
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void scroll_bottom_page(WebDriver driver)
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public static void scroll_top_page(WebDriver driver)
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollTop)");
	}
	public static void scroll_left_page(WebDriver driver)
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollLeft)");
	}
}
