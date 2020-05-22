package com.appium.test;

import org.testng.annotations.Test;

import com.appium.pageObjects.pageObjects;
//import com.beust.jcommander.Parameter;
//import com.helper.ExcelUtil;
import com.helper.UserActions;
import com.listner.TestListener;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;


@Listeners(TestListener.class)



public class Univtestng  {
	

	UserActions user;
	AndroidDriver driver;
	
	static String accessKey = null;

	
	@Parameters({"Device"})		
	@BeforeTest
	public void setUp(String Device) throws MalformedURLException {
		
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		System.out.println(Device);
		if (Device.contentEquals("Real_Device")) {
			System.out.println("Entering Real device");

	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("platformVersion", "10");
	    desiredCapabilities.setCapability("udid", "34af02ee");
	    desiredCapabilities.setCapability("deviceName", "DGGOKUL");
	    desiredCapabilities.setCapability("appPackage", "patel.krupesh.amazinguniversefactsapp");
	    desiredCapabilities.setCapability("appActivity", ".MainActivity");

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
			driver = new AndroidDriver(remoteUrl, desiredCapabilities);
			user= new UserActions(driver);
			
		} 
		
		else if  (Device.contentEquals("Cloud_Device")){
		
		
			System.out.println("Entering Cloud device");
			desiredCapabilities.setCapability("testName", "SpaceFacts");
			accessKey = "eyJ4cC51Ijo0NTU2OTcsInhwLnAiOjQ1NTY4OSwieHAubSI6Ik1UVTRPVE0yTnprMU1EQXlNdyIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE5MDQ3Mjc5NTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.9PEKvslTXNVQjibm_oLIBni8iknsIwo1etQfjBMQ8ME";
			desiredCapabilities.setCapability("accessKey", accessKey);
			desiredCapabilities.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "patel.krupesh.amazinguniversefactsapp");
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
			desiredCapabilities.setCapability("unicodeKeyboard", "true");
			desiredCapabilities.setCapability("resetKeyboard", "true");
			driver = new AndroidDriver(new URL("https://demo.experitest.com/wd/hub"), desiredCapabilities);
			user= new UserActions(driver);
		
		}else if (Device.contentEquals("Emulator_Device")) {
			System.out.println("Entering Emulator");
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("platformVersion", "9");
			desiredCapabilities.setCapability("udid", "emulator-5554");
			desiredCapabilities.setCapability("deviceName", "Emulator");
			desiredCapabilities.setCapability("appPackage", "patel.krupesh.amazinguniversefactsapp");
			desiredCapabilities.setCapability("appActivity", ".MainActivity");
			desiredCapabilities.setCapability("unicodeKeyboard", "true");
			desiredCapabilities.setCapability("resetKeyboard", "true");
			URL remoteUrl = new URL("http://localhost:4723/wd/hub");
			 driver = new AndroidDriver(remoteUrl, desiredCapabilities);
			user= new UserActions(driver);
			
			
		}
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	
	
	@Test
	  public void sampleTest() {
	  
	  //		user.pass("Application launche successully", driver);
		  if(accessKey==null) {
		  
		  user.Click(pageObjects.confirmationButton1);}
		  
		  user.Click(pageObjects.search1);
		  user.SendKeys(pageObjects.search1, "Titan");
		  user.Click(pageObjects.search2);
		  //user.SendKeys(pageObjects.search1, "Titan");
		  user.Click(pageObjects.search3);
		  user.SendKeys(pageObjects.search3, "satellites");
		  user.Click(pageObjects.titan2);
		  user.Click(pageObjects.search4);
		  user.Click(pageObjects.search5);}
		  
		  

	  @AfterTest
	  public void tearDown() {
	    driver.quit();
	  }
	}


