package com.selen.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestApache2 {

	public static void main(String[] args) throws Exception {
		File file = new File("C:\\eclipse project\\test\\ExcelFile\\Test1.xlsx");
		FileInputStream fis= new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(1);
		
	   /* String cellValue=sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(cellValue);*/
		
		
		  int rowcount =sheet.getPhysicalNumberOfRows();
		  
		  for (int i = 0; i < rowcount; i++)
		  {
			  XSSFRow row = sheet.getRow(i);
			  
			  int cellcount = row.getPhysicalNumberOfCells();
			  
			  for (int j = 0; j < cellcount; j++) {
				  
				  XSSFCell cell = row.getCell(j);
				  String cellValue= getCellValue(cell);
				  System.out.print("||"+cellValue);
				  
				
			}
			  System.out.println();
			
		}
		
		workbook.close();
		fis.close();

	}
	public static String getCellValue(XSSFCell cell) {
		switch (cell.getCellType()) {
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());	
		case STRING:
			return cell.getStringCellValue();


		default:
			return cell.getStringCellValue();
		}
	}

}
