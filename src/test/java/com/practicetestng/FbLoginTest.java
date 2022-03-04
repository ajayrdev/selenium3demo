package com.practicetestng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FbLoginTest {
	@Test(dataProvider = "login-Test") // ,dataProviderClass =ExcelPractice.class
	public void facebookLogin(String userId, String userPassword, String userName, String userRole) {
		System.out.println(userId + " " + userPassword + " " + userName + " " + userRole + " ");
		WebDriver driver = null;
		try {
			String baseDirectory = System.getProperty("user.dir");
			String driverPath = "\\src\\test\\resources\\chromedriver.exe"; // Getting data from ExcelDataForDataProvider																		 
			System.setProperty("webdriver.chrome.driver", baseDirectory + driverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			String excelRelativePath = "\\src\\test\\resources\\userdetails.properties";
			FileInputStream fis;
			fis = new FileInputStream(baseDirectory + excelRelativePath);

			Properties pop = new Properties();
			pop.load(fis);
			String Url = pop.getProperty("fbUrl");
			driver.get(Url);

			driver.findElement(By.id("email")).sendKeys(userId);
			driver.findElement(By.id("pass")).sendKeys(userPassword);
			driver.findElement(By.xpath("//button[@name='login']")).click();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	@DataProvider(name = "login-Test")
	public Object[][] testdata() {
		ExcelDataForDataProvider readData = new ExcelDataForDataProvider();
		Object[][] excelData = readData.readExcelData();
		System.out.println("excelData:\n" + excelData);
//	  ExcelPractice readData = new ExcelPractice();
//	  Object[][] excelData = readData.readExcel();
		return excelData;

	}
}
