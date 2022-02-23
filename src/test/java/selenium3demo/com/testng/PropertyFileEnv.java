package selenium3demo.com.testng;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PropertyFileEnv {

	@Test
	public void fileEnv() {

		WebDriver driver = null;
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\DELL\\eclipse-workspace\\selenium3demo\\src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			String baseDirectory = System.getProperty("user.dir");
			String fileRelativePath = "\\src\\test\\resources\\fileenv.properties";

			FileInputStream fis = new FileInputStream(baseDirectory + fileRelativePath);
			Properties pop = new Properties();
			pop.load(fis);
			
			System.out.println(pop.getProperty("User"));
			String userName = pop.getProperty("User");

			if (userName.equalsIgnoreCase("QA"))
				driver.get("https://facebook.com");
			else if (userName.equalsIgnoreCase("DEV")) {
				driver.get("https://developers.facebook.com/");
			} else {
				Assert.fail("Please pass valid environment");
			}
			driver.quit();

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}

	}
}
