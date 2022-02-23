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

public class TestNGDemo {
	
  @Test
  public void firstTest() {
	  System.out.println("I am firstTest");
  }
  
  @Test (enabled = false)
  void secondTest() {
	  System.out.println("I am secondTest");
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

  @BeforeClass
  public void beforeClass() {
	  System.out.println("I am beforeClass()");
	  //
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("I am afterClass()");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("I am beforeTest()");
	  //Executes before all tests
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("I am afterTest()");
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
