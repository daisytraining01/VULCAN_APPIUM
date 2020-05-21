package com.appium.test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class NewTest {
	
	
	@BeforeSuite 
	public void BeforeSuite () {
		System.out.println("BeforeSuite ");
	}
	
	@BeforeMethod
	public void BeforeMethod () {
		System.out.println("@BeforeMethod ");
	}
	
	
	@BeforeClass 
	public void beoreclass() {
		System.out.println("Beore class");
	}
	
	@BeforeTest
	public void beoreTest() {
		System.out.println("Beore Test");
	}
	
	
	
	
	
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  
	  System.out.println(n+s);
  }
  
  
  
	@AfterTest
	public void aterTest () {
		System.out.println("Ater test");
	}
	
	
	
	@AfterClass 
	public void AfterClass() {
		System.out.println("After class");
	}
	
	@AfterMethod
	public void AfterMethod() {
		System.out.println("AfterMethod");
	}
	
	
	@AfterSuite
	public void AfterSuite() {
		System.out.println("AfterSuite");
	}
	
	
	
	
	
	
	
  

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
      new Object[] { 3, "C" },
      
    };
  }
}
