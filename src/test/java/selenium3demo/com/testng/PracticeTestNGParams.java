package selenium3demo.com.testng;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PracticeTestNGParams {
	@Parameters("User")
	@Test (description = "Verifying the app with different roles")
	public void verifyLogin(String paramValue) {

		WebDriver driver = null;
		try {
			String baseDirectory = System.getProperty("user.dir");
			String driverPath = "\\src\\test\\resources\\chromedriver.exe";

			System.setProperty("webdriver.chrome.driver", baseDirectory + driverPath);
			driver = new ChromeDriver();
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

			String username = "";
			String password = "";
			String loggedInUser = "";

			if (paramValue.equalsIgnoreCase("Kumar")) {
				username = "kumar.thoudishetti@gmail.com";
				password = "Admin1011";
				loggedInUser = "Kumar";
			} else if (paramValue.equalsIgnoreCase("Ajay")) {
				username = "akreddy0415@gmail.com";
				password = "Admin1011";
				loggedInUser = "Ajay";
			} else {
				Assert.fail("Please pass valid user role");
			}

			Thread.sleep(1000);
			driver.findElement(By.id("email_input")).sendKeys(username);

			Thread.sleep(1000);
			driver.findElement(By.id("password_input")).sendKeys(password);

			Thread.sleep(1000);
			driver.findElement(By.id("login_button")).click();
			Thread.sleep(2000);

			String loggedInUserName = driver.findElement(By.xpath("//li[@id='nav_user']//a")).getText();
			System.out.println("Logged in username: " + paramValue);

			Assert.assertEquals(loggedInUserName.equalsIgnoreCase(loggedInUser), true, "Login verification failed");

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			driver.quit();
		}

	}
}
