package com.practicetestng;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginFacebookUsingDataProviderExcel {
  @Test(dataProvider ="fb-login" )
  public void facebookLoginTest(String userId, String userPassword,String userRole, String userName) {
	  
	  WebDriver driver = null;
	  String baseDirectory = System.getProperty("user.dir");
	  String excelFilePath = "\\src\\test\\resources\\ReadUserData.xlsx";
	  String driverPath = "\\src\\test\\resources\\chromedriver.exe";
	  System.setProperty("webdriver.chrome.driver", baseDirectory+driverPath);
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  try {
		FileInputStream fis = new FileInputStream(baseDirectory+excelFilePath);
		Properties pop = new Properties();
		pop.load(fis);
		String Url = pop.getProperty("fbUrl");
		System.out.println(Url);
		
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys(userId);
		driver.findElement(By.id("pass")).sendKeys(userPassword);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		
	} catch (IOException | InterruptedException e) {
		
		e.printStackTrace();
	}
	  
  }
//  @DataProvider(name = "fb-login")
//  public Object[][] testData(){
//	  GetDataFromExcel readData = new GetDataFromExcel();
//	  Object[][] excelData = readData.loginFacebook(1);
//	  System.out.println(excelData);
//	return excelData;
	  
	  
  }
//}
