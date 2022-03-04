package com.practicetestng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadFacebookLogin {
	@Test
	public void fbLoginTest() throws InterruptedException {
		WebDriver driver = null;
		String baseDirectory = System.getProperty("user.dir");
		String driverPath = "\\src\\test\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", baseDirectory + driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String fileRelativePath = "\\src\\test\\resources\\userdetails.properties";
		try {
			FileInputStream fis = new FileInputStream(baseDirectory + fileRelativePath);
			Properties pop = new Properties();
			pop.load(fis);
			String Url = pop.getProperty("fbUrl");
			System.out.println(Url);
			driver.get(Url);

			driver.findElement(By.id("email")).sendKeys("ajay.facebook.com");
			Thread.sleep(2000);
			driver.findElement(By.id("pass")).sendKeys("ajay123123");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@name='login']")).click();
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			throw new InterruptedException("Network issue: please check your Network connection");

		} finally {
			driver.quit();
		}
	}
}
