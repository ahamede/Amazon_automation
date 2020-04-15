package com.amazon.lib;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Upload {
	
	public static void uploadFile(String path) throws Throwable
	{
		
		 StringSelection sel = new StringSelection(path);
		 
		   // Copy to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		 System.out.println("selection" +sel);
		 
		 Thread.sleep(2000);
		
		 
		 // Create object of Robot class
		 Robot robot = new Robot();
		 Thread.sleep(1000);
		      
		  // Press Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		 
		// Release Enter
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		  // Press CTRL+V
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 
		// Release CTRL+V
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
		 Thread.sleep(1000);
		        
		   
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		 
		 System.out.println("===========Following file >>"+path +"Uploaded Successfully");
	}

}
