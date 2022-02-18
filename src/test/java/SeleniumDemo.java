import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumDemo {

	@Test
	public void firstTest() {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\DELLA\\eclipse-workspace\\selenium3demo\\src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://facebook.com"); // if your url is invalid or spaces any or unwanted special chars

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Error(e);
		} 
		finally {
			try {
				driver.quit();
			} catch (Exception e) {
				
			}
		}
	}
}
