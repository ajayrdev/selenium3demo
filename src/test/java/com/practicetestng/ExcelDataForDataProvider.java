package com.practicetestng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;


public class ExcelDataForDataProvider {
 public Object[][] readExcelData() {
		Object testData[][] = null;
		try {
			String baseDir = System.getProperty("user.dir");
			String excelFilePath = baseDir + "//src//test//resources//facebook.xlsx";
			FileInputStream fis = new FileInputStream(excelFilePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(1).getLastCellNum();
			
			testData = new Object[rows+1][cols];
			
			for (int r = 1; r <= rows; r++) {  
				XSSFRow row = sheet.getRow(r);
				for (int c = 0; c < cols; c++) {
					XSSFCell cell = row.getCell(c);

					switch (cell.getCellType()) {
					case STRING:
						String value  = cell.getStringCellValue();
						System.out.print(value+" ");
						testData[r][c] = value;
						break;
					case NUMERIC:
						String value1  = cell.getStringCellValue();
						System.out.print(value1+" ");
						testData[r][c] = value1;
						break;
					case BOOLEAN:
						String value2  = cell.getStringCellValue();
						System.out.print(value2+" ");
						testData[r][c] = value2;
						break;
					default:
					Assert.fail("Excel Sheet doesn't contain any data");
						break;
					}
				}
				System.out.println();

			}
			workbook.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	return testData;
	
  }
}
