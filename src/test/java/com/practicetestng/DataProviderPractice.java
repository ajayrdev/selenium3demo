package com.practicetestng;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class DataProviderPractice {
	@Test(dataProvider = "user-login")
	public void dataProviderTestCase1(String userId, String userPwd, String userRole, String userName) {
		WebDriver driver = null;
		String baseDirectory = System.getProperty("user.dir");
		String driverPath = "\\src\\test\\resources\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", baseDirectory + driverPath);
//		driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		String fileRelativePath = "\\src\\test\\resources\\userdetails.properties";
		try {
			FileInputStream fis = new FileInputStream(baseDirectory + fileRelativePath);
			Properties pop = new Properties();
			pop.load(fis);
			System.out.println(pop.getProperty("appUrl"));
			String Url = pop.getProperty("appUrl");
			driver.get(Url);

			/*
			 * site Url Taking from Properties file and userRoles taking from testng.xml
			 * file
			 */
//			String loggedInUser = "";
//			if (userRole.equalsIgnoreCase("Admin") || userRole.equalsIgnoreCase("User")) {
//				loggedInUser = userName;
//			} else {
//				Assert.fail("Please pass valid user role");
//			}

			Thread.sleep(2000);
			driver.findElement(By.id("nav_login")).click();

			Thread.sleep(1000);
			driver.findElement(By.id("email_input")).sendKeys(userId);

			Thread.sleep(1000);
			driver.findElement(By.id("password_input")).sendKeys(userPwd);

			Thread.sleep(1000);
			driver.findElement(By.id("login_button")).click();

//			String loggedInUserName = driver.findElement(By.xpath("//li[@id='nav_user']//a")).getText();
//
//			Assert.assertEquals(loggedInUserName.equalsIgnoreCase(loggedInUser), true, "Login verification failed");

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (InterruptedException e) {

			e.printStackTrace();

		} finally {
			driver.quit();
		}

	}

	@DataProvider(name = "user-login")
	public Object[][] testDataProvider() {
		return new Object[][] { { "kumar.thoudishetti@gmail.com", "Admin1011", "Admin", "Kumar" },
				{ "akreddy0415@gmail.com", "Admin1011", "User", "Ajay" },
				{ "invalidUser@gmail.com", "Admin1011", "Unauthorized", "InvalidUser" }

		};
	}
}
