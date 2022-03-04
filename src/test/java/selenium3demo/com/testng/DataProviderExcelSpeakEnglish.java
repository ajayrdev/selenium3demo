package selenium3demo.com.testng;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.practicetestng.ReadDataFromExcelFile;

public class DataProviderExcelSpeakEnglish {
	@Test(dataProvider = "user-logins", description = "Verifying the app with different roles")
	public void testWithMutliUsers(String userId, String userPwd, String userRole, String userName) {
		System.out.println(userId + " " + userPwd + " " + userRole + " " + userName);
		WebDriver driver = null;
		if (userId != null) {
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

				driver.get(url); // get is used to launch the application. It takes aUrl as arameter and launches

				String loggedInUser = "";

				if (userRole.equalsIgnoreCase("Admin") || userRole.equalsIgnoreCase("User")) { // true OR false = true
					loggedInUser = userName;
				} else {
					Assert.fail("Please pass valid user role");
				}

				Thread.sleep(2000);
				driver.findElement(By.partialLinkText("Log in")).click();

				Thread.sleep(1000);
				driver.findElement(By.id("email_input")).sendKeys(userId);

				Thread.sleep(1000);
				driver.findElement(By.id("password_input")).sendKeys(userPwd);

				Thread.sleep(1000);
				driver.findElement(By.id("login_button")).click();
				Thread.sleep(2000);

				String loggedInUserName = driver.findElement(By.xpath("//li[@id='nav_user']//a")).getText();

				Assert.assertEquals(loggedInUserName.equalsIgnoreCase(loggedInUser), true, "Login verification failed");

			} catch (Exception e) {
			      System.out.println("Exception: " + e);
			} finally {
				driver.quit();
			}
		}
	}

	@DataProvider(name = "user-logins")
	public Object[][] testData() {
		/*
		 * return new Object[][] { { "kumar.thoudishetti@gmail.com", "Admin1011",
		 * "Admin", "Kumar" }, { "akreddy0415@gmail.com", "Admin1011", "User", "Ajay" },
		 * {"invalidUser@gmail.com", "Admin1011", "Unauthorized", "InvalidUser" } };
		 */
		ReadDataFromExcelFile readData = new ReadDataFromExcelFile();
		Object[][] excelData = readData.readDataFromExcel(0);
		System.out.println("excelData:\n" + excelData);
		return excelData;
	}

}
