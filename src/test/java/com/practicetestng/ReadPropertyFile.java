package com.practicetestng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadPropertyFile {
	@Test
	public void firstTestCase() throws IOException {
		WebDriver driver = null;

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\DELL\\myRepos\\selenium3demo\\src\\test\\resources\\chromedriver.exe");

		/*
		 * System.setProperty("webdriver.chrome.driver",baseDirctory+driverPath); String
		 * baseDirectory = System.getProperty("user.dir"); String driverPath =
		 * "\\src\\test\\resources\\chromedriver.exe"
		 */

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String baseDirectory = System.getProperty("user.dir");
		String fileRelativePath = "\\src\\test\\resources\\userdetails.properties";
		try {
			FileInputStream fis = new FileInputStream (baseDirectory+fileRelativePath);
			Properties pop = new Properties();
			pop.load(fis);
			System.out.println(pop.getProperty("appUrl")); //*https://facebook.com
			String URL = pop.getProperty("appUrl");
			driver.get(URL);
			
	
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Please check the file path given");
		}
		
		
		
	}
}
