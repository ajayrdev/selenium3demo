package selenium3demo.com.testng;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTests {
	@Parameters("Browser")
	@Test( description = "Verifying the app with different browsers")
	public void testWithGivenBrowser(String browser) {

		WebDriver driver = null;
		try {
			String baseDirectory = System.getProperty("user.dir");
			String driverPath = "";
	
			switch(browser) {
			case "Chrome":
				driverPath = "\\src\\test\\resources\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", baseDirectory + driverPath);
				driver = new ChromeDriver();
				break;
			case "Firefox":
				driverPath = "\\src\\test\\resources\\geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", baseDirectory + driverPath);
				driver = new FirefoxDriver();
				break;
			}
	
			driver.manage().window().maximize();

			String fileRelativePath = "\\src\\test\\resources\\testfile.properties";

			FileInputStream fis = new FileInputStream(baseDirectory + fileRelativePath);
			Properties pop = new Properties();
			pop.load(fis);
			System.out.println(pop.getProperty("Url"));
			String url = pop.getProperty("Url");

			driver.get(url);
			
			Thread.sleep(2000);
			driver.findElement(By.id("nav_login")).click();

			Thread.sleep(1000);
			driver.findElement(By.id("email_input")).sendKeys("kumar.thoudishetti@gmail.com");

			Thread.sleep(1000);
			driver.findElement(By.id("password_input")).sendKeys("Admin1011");

			Thread.sleep(1000);
			driver.findElement(By.id("login_button")).click();
			Thread.sleep(2000);

			String loggedInUserName = driver.findElement(By.xpath("//li[@id='nav_user']//a")).getText();

			Assert.assertEquals(loggedInUserName.equalsIgnoreCase("Kumar"), true, "Login verification failed");

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			driver.quit();
		}
	}

}
