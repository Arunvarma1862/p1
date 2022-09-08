package com.selen.test;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestApache {
   public static void main(String[] args) throws Exception {
	   
	XSSFWorkbook workbook = new XSSFWorkbook();
//	XSSFSheet sheet =workbook.createSheet();
	XSSFSheet sheet =workbook.createSheet("testsheet");
	sheet.createRow(0);
	sheet.getRow(0).createCell(0).setCellValue("hello1");
	sheet.getRow(0).createCell(1).setCellValue("world2");
	
	
	sheet.createRow(1);
	sheet.getRow(1).createCell(0).setCellValue("hiiii");
	sheet.getRow(1).createCell(1).setCellValue("world");

	
	File file=new File("C:\\eclipse project\\test\\ExcelFile\\Test1.xlsx");
	FileOutputStream fos= new FileOutputStream(file);
	workbook.write(fos);
	workbook.close();
	
}
}
