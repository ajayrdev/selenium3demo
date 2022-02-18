import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumCustomExceptions {
  @Test
  public void firstTest() {
	  

		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\DELL\\eclipse-workspace\\selenium3demo\\src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("  ://facebook.com"); // if your url is invalid or spaces any or unwanted special chars

		} catch (IllegalStateException e) {
			//System.out.println("Exception: "+e);
			throw new  IllegalStateException("Please make sure driver file  exists in the path provided");
		} 
		 catch (InvalidArgumentException e) {
				//System.out.println("Exception: "+e);
				throw new  InvalidArgumentException("Please make sure the valid url is provided");
			}
		finally {
			try {
				driver.quit();
			} catch (Exception e) {
				
			}
		}
	
  }
}
