package com.amazon.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.amazon.lib.Read_Write_Excel;

public class ReadWriteExcel  {

		 public static void main(String []args) throws IOException{
		Read_Write_Excel.read_data_excel();
		 }
		 
}
