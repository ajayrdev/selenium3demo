package com.practicetestng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserCheckPractice {
	@Parameters("Browser")
	@Test
	public void crossBrowserCheck(String paramValue) {
		WebDriver driver = null;
		String baseDirectory = System.getProperty("user.dir");

		if (paramValue.equalsIgnoreCase("Chrome")) {
			String driverPath = "\\src\\test\\resources\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", baseDirectory + driverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://facebook.com");

		} else if (paramValue.equalsIgnoreCase("Firefox")) {
			String driverPath = "\\src\\test\\resources\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", baseDirectory + driverPath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://facebook.com");
		}
		
		/*driver.findElement(By.id("email")).sendKeys("ajayreddy.potu@facebook.com");
		driver.findElement(By.id("pass")).sendKeys("ajay11111");
		driver.findElement(By.id("u_0_d_Jh")).click();
		*
		* Not working
		* always password id is updated when we open new Facebook page
		*/
		
		driver.quit();

		
	}
}
