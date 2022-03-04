package com.practicetestng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginBrowser {
	@Test
	public void loginToBrowser() throws IOException, InterruptedException {

		WebDriver driver = null;
		String baseDirectory = System.getProperty("user.dir");
		String driverPath = "\\src\\test\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", baseDirectory + driverPath);

		/*
		 * System.setProperty("webdriver.chrome.driver",baseDirctory+driverPath); String
		 * baseDirectory = System.getProperty("user.dir"); String driverPath =
		 * "\\src\\test\\resources\\chromedriver.exe"
		 * "C:\\Users\\DELL\\myRepos\\selenium3demo\\src\\test\\resources\\chromedriver.exe"
		 * http://speakenglish.co.uk/
		 */

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String fileRelativePath = "\\src\\test\\resources\\userdetails.properties";
		try {
			FileInputStream fis = new FileInputStream(baseDirectory + fileRelativePath);
			Properties pop = new Properties();
			pop.load(fis);
			System.out.println(pop.getProperty("appUrl")); // *http://speakenglish.co.uk/
			String URL = pop.getProperty("appUrl");
			driver.get(URL);
			String username = pop.getProperty("userID");
			String password = pop.getProperty("userPassword");

			driver.findElement(By.id("nav_login")).click();
			Thread.sleep(2000); //*Showing Exception
			driver.findElement(By.id("email_input")).sendKeys(username);
			Thread.sleep(2000);
			driver.findElement(By.id("password_input")).sendKeys(password);
			Thread.sleep(2000);
			driver.findElement(By.id("login_button")).click();

		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Please check the file path given");
		} catch (InterruptedException e) {
			throw new InterruptedException("Please check your Network connection");
			
		} finally {
			driver.quit();
		}

	}
}
