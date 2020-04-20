package com.amazon.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_Excel_Data {
	
	public void writeexcel(int rownum, int colnum, String setvalue){
		try{
			File src=new File(System.getProperty("user.dir")+"\\resources\\testexcel.xlsx");
			FileInputStream fis=new FileInputStream(src);
			XSSFWorkbook wbk=new XSSFWorkbook(fis);
			XSSFSheet sh1=wbk.getSheetAt(0);
			sh1.createRow(rownum).createCell(colnum).setCellValue(setvalue);
			FileOutputStream fout=new FileOutputStream(src);
			 wbk.write(fout);
			 fout.close();
			 

		}catch (Exception e) {
			   System.out.println(e.getMessage());
			  }
		
	}

}
