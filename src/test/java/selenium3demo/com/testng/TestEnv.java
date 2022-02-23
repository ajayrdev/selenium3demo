package selenium3demo.com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEnv {
	@Test
	public void verifyEnvIsNotEmpty() {
		String env = System.getProperty("Env");
		System.out.println(env);
		WebDriver driver = null;
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\DELL\\eclipse-workspace\\selenium3demo\\src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.manage().window().maximize();

			if (env.equalsIgnoreCase("qa"))
				driver.get("https://facebook.com");
			else if (env.equalsIgnoreCase("dev")) {
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
