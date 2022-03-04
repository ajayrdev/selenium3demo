package com.practicetestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Locators {
  @Test
  public void testLocators() {
	  WebDriver driver = null;
	  String baseDirectory = System.getProperty("user.dir");
	  String driverPath = "\\src\\test\\resources\\chromedriver.exe";
	  System.setProperty("webdriver.chrome.driver", baseDirectory+driverPath);
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://speakenglish.co.uk");
	  
	  /*//img[@alt='Speak Languages']
	   * //input[@name='q'] 
	   * By.linkText("Log in")
	   * //input[@id ='email_input']
	   * //input[@id = 'password_input']
	   * //input[@id = 'login_button']
	   * //li[@id ='nav_user']
	   * //*[@id="nav_user"]/a
	   * //li[@class= 'profile_button']
	   * linkText("Ajay")
	   */
//  driver.findElement(By.xpath("//img[@alt='Speak Languages'])")).click();
//  driver.findElement(By.xpath("//input[@name='q']")).click();
	  
  driver.findElement(By.linkText("Log in")).click();
  driver.findElement(By.xpath("//input[@id ='email_input']")).sendKeys("akreddy0415@gmail.com");
  driver.findElement(By.xpath("//input[@id = 'password_input']")).sendKeys("Admin1011");
 
  driver.findElement(By.xpath("//input[@id = 'login_button']")).click();
//  driver.findElement(By.xpath("//*[@id=\"nav_user\"]/a")).click();
  
//  driver.findElement(By.xpath("//img[@alt='Messages']")).click();
  
//driver.findElement(By.xpath("//li[@id=\'nav_messages\']/a/img")).click();
  
  driver.findElement(By.xpath("//img[@alt = 'Settings']")).click();


//  driver.findElement(By.xpath("//li[@id ='nav_user']")).click();
//  driver.findElement(By.partialLinkText("Ajay")).click();
//  driver.findElement(By.xpath("//li[@class= 'profile_button']")).click();
  }
}
