package com.amazon.lib;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {
	public static  void select_by_value(WebElement item,String option ) {
		try {
			Select s=new Select(item);
			Thread.sleep(3000);
			s.selectByValue(option);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static  void select_by_index(WebElement item,int ind ) {
		try {
			Select s=new Select(item);
			Thread.sleep(3000);
			s.selectByIndex(ind);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static  void select_by_visibleText(WebElement item,String vtext ) {
		try {
			Select s=new Select(item);
			Thread.sleep(3000);
			s.selectByVisibleText(vtext);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
