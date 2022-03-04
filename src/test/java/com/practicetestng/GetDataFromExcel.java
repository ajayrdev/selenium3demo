package com.practicetestng;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class GetDataFromExcel {
	@Test
	public Object[][] loginFacebook() {
		Object testData[][] = null;
		String baseDirectory = System.getProperty("user.dir");
		String excelSheetPath = "\\src\\test\\resources\\ReadUserData.xlsx";
		try {
			FileInputStream fis = new FileInputStream(baseDirectory + excelSheetPath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(1);
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(1).getLastCellNum();

			testData = new Object[rows + 1][cols];

			for (int r = 0; r <= rows; r++) { // 0-->start with column name 1--> only data
				XSSFRow row = sheet.getRow(r);
				for (int c = 0; c < cols; c++) {
					XSSFCell cell = row.getCell(c);

					switch (cell.getCellType()) {
					case STRING:
//						System.out.print(cell.getStringCellValue()+"|");
						String value = cell.getStringCellValue();
						System.out.print(value + "|");
//						testData[r][c] = value;
						break;
					case NUMERIC:
//						System.out.print(cell.getStringCellValue()+"|");
						String value1 = cell.getStringCellValue();
						System.out.print(value1 + "|");
//						testData[r][c] = value1;
						break;
					case BOOLEAN:
//						System.out.print(cell.getStringCellValue()+"|");
						String value2 = cell.getStringCellValue();
						System.out.print(value2 + "|");
//						testData[r][c] = value2;

					}

				}
				System.out.println();
			}

		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return testData;
	}
}
