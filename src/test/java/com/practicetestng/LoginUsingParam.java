package com.practicetestng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginUsingParam {
	@Parameters("User")
	@Test
	public void openWebPageUsingParam(String paramValue) {
		WebDriver driver = null;
		String baseDirectory = System.getProperty("user.dir");
		String driverPath = "\\src\\test\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", baseDirectory + driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		if (paramValue.equalsIgnoreCase("Kumar")) {
			driver.get("https://facebook.com");
		} else if (paramValue.equalsIgnoreCase("Ajay")) {
			driver.get("http://speakenglish.co.uk/");
		} else {
			Assert.fail("Please pass correct User details");
		}
		driver.quit();
	}
}
