import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumNullPointerException {
	WebDriver driver = null;

	@Test
	public void firstTestCase() {
		try {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\DELL\\eclipse-workspace\\selenium3demo\\src\\test\\resources\\chromedriver.exe");
			System.out.println(driver);
	         //driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://facebook.com");

		} catch (NullPointerException e) {
			// System.out.println("Exception: "+e);
			throw new NullPointerException("Please make sure you assign proper driver object reference");
		}

	}
}
