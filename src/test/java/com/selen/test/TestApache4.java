package com.selen.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestApache4 {
	public static void main(String[] args) throws Exception {

		//	  File file = new File("C:\\eclipse project\\test\\ExcelFile\\Test1.xlsx");

		FileInputStream fis = new FileInputStream(new File("C:\\eclipse project\\test\\ExcelFile\\Test1.xlsx"));

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet=  workbook.getSheetAt(1);

		int rows=	 sheet.getPhysicalNumberOfRows();
		int colm=  sheet.getRow(0).getLastCellNum();

		for (int i =1 ; i < rows; i++) {

			for (int j = 0; j < colm; j++) {
				
		 

				DataFormatter df = new DataFormatter();
				
				System.out.print(  "||"+	  df.formatCellValue(sheet.getRow(i).getCell(j)));

			}
			System.out.println();
			workbook.close();
			fis.close();  

		}




	}

}
