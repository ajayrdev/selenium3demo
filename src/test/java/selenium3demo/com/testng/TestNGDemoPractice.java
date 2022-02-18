package selenium3demo.com.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGDemoPractice {
	
  @Test
  public void firstTest() {
	  System.out.println("I am firstTest");
  }
  
  @Test
  public void secondTest() {
	  String name  = "AjayReddy";
	  char myChar = 'H';
	  System.out.println("I am secondTest");
	  Assert.assertEquals(200 == 100, true);
	  Assert.assertEquals(name.contains("Reddy"), true);
	  Assert.assertEquals(myChar == 'Z', true);
	  Assert.fail("failed as we are tesing the apps with invalid data");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("I am beforeMethod()");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("I am afterMethod()");
  }


  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("I am beforeSuite()"); // Suite level method executes before all the annotations
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("I am afterSuite()");
  }

}
