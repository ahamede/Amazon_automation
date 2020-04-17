package com.amazon.lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Write_Excel {
	 static String filepath="C:\\Users\\Admin\\Pictures\\testexcel.xlsx";
	  public static void read_data_excel() throws IOException{
		 try{
		  FileInputStream fs = new FileInputStream(filepath);
		  XSSFWorkbook wb=new XSSFWorkbook(fs);
		  XSSFSheet sh1= wb.getSheetAt(0);
		  System.out.println(sh1.getRow(0).getCell(0).getStringCellValue());
		  
		  System.out.println(sh1.getRow(0).getCell(1).getStringCellValue());
		  
		  System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
		  
		  System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());
		  
		  System.out.println(sh1.getRow(2).getCell(0).getStringCellValue());
		  
		  System.out.println(sh1.getRow(2).getCell(1).getStringCellValue());
	  }
		 catch(Exception e){
			 System.out.println(e.getMessage());
		 }
	  }
	  
	  public static void write_data_excel() throws IOException{
		  FileInputStream fs = new FileInputStream(filepath);
		  XSSFWorkbook wb1=new XSSFWorkbook(fs);
		  XSSFSheet sh1= wb1.getSheetAt(0);
		  sh1.getRow(0).createCell(2).setCellValue("2.41.0");
		  
		  sh1.getRow(1).createCell(2).setCellValue("2.5");
		  
		  sh1.getRow(2).createCell(2).setCellValue("2.39");
		  
	  }
	  

}
