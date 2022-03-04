package com.practicetestng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class PracTestNgAnnotations {
	@Test
	public void firstTestCase() {
		int i;
		int a = 1;
		int b = 2;
		i = a + b;
		System.out.println("Addition of A + B :" + i);

	}

	@Test
	public void secondTestCase() {
		System.out.println("Display my Second TestNG Testcase");

	}

	@Test
	public void thirdTestCase() {
		System.out.println("Display my Third TestNG Testcase");

	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Print beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Print afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Print beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Print afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Print beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Print afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Print beforeSuite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Print afterSuite");
	}

}
