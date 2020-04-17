package com.amazon.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amazon.lib.Helper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AccessGridValues {
	public static WebDriver driver;
	public static ExtentTest logger;
	public static ExtentReports report;
	int row,column;
	List<WebElement> row_table;
	List<WebElement> column_table;
	int c;
	String celltext;
	

	public AccessGridValues(WebDriver driver){
		this.driver=driver;		
	}
	

	public int getnumberofColumns(){
	           
		       WebElement mytable=driver.findElement(By.xpath("//th[contains(.,'Company')]"));
			  column_table=mytable.findElements(By.xpath("//th"));
		      column=column_table.size();
		      return column;
	} 
	
	public int getnumberofrows(){
        
	       WebElement mytable=driver.findElement(By.xpath("//th[contains(.,'Company')]"));
	       row_table=mytable.findElements(By.xpath("//tr"));
	      row=row_table.size();
	      return row;
} 
	
	public void readgridvalues(int rown){
		for (int r = 0; r < row; r++){
		 List<WebElement> cellrc=row_table.get(r).findElements(By.xpath("//tr"));
		 int cellrc_count=cellrc.size();
		 if(r==rown){
		 for ( c = 0; c < cellrc_count; c++){
			
			  celltext = cellrc.get(c).getText();
			 }
		    System.out.println("Cell Value Of row number " + rown + " and column number " + c + " Is " + celltext);

		 }

	}
	}
}
