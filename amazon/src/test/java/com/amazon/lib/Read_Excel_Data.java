package com.amazon.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel_Data {
	
	String s;

	public String readexceldata(int rownum, int colnum){
		try{
			File src=new File(System.getProperty("user.dir")+"\\resources\\testexcel.xlsx");	
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wbk=new XSSFWorkbook(fis);
		XSSFSheet sh1=wbk.getSheetAt(0);
		CellType type=sh1.getRow(rownum).getCell(colnum).getCellType();
		if(type==CellType.NUMERIC){
	    System.out.println(sh1.getRow(rownum).getCell(colnum).getNumericCellValue());
		}else if(type==CellType.STRING){
		    System.out.println(sh1.getRow(rownum).getCell(colnum).getStringCellValue());

		}
		else{
			System.out.println("Invalid data type");
		}
		
		}catch (Exception e) {

			   System.out.println(e.getMessage());

			  }
		return s;
	}


}
