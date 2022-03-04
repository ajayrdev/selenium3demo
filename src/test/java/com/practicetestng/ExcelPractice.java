package com.practicetestng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExcelPractice {
//	@DataProvider(name = "login-Test")
public String[][] readExcel() throws IOException{
		String[][] testData = null;
		
		
		try {
			String excelFilePath = "C:\\Users\\DELL\\myRepos\\selenium3demo\\src\\test\\resources\\facebook.xlsx";
			FileInputStream fis = new FileInputStream(excelFilePath);
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workBook.getSheetAt(0);
			int rows = sheet.getLastRowNum();
			int columns = sheet.getRow(1).getLastCellNum();

			testData = new String[rows+1][columns];

			for (int r = 1; r <= rows; r++) {
				XSSFRow row = sheet.getRow(r);
				for (int c = 0; c < columns; c++) {
					XSSFCell cell = row.getCell(c);
//			  System.out.print(sheet.getRow(r).getCell(c).getStringCellValue()+" ");
					switch (cell.getCellType()) {
					case STRING:
						String value = cell.getStringCellValue();
						System.out.print(value);
						value = testData[r][c];
						break;
					case NUMERIC:
						String value1 = cell.getStringCellValue();
						System.out.print(value1);
						value1 = testData[r][c];
						break;
					case BOOLEAN:
						String value2 = cell.getStringCellValue();
						System.out.print(value2);
						value2 = testData[r][c];
//						break;
//				default:
//					Assert.fail("Excel Sheet doesn't contain any data");
//					break;

					}
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testData;
	}
}
