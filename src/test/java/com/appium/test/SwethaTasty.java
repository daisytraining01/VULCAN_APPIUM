package com.appium.test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.appium.pageObjects.pageObjects_Swetha;
import com.helper.ExcelUtil;
import com.helper.UserActions;
public class SwethaTasty {
	UserActions user;
   AndroidDriver driver;
   private String accessKey = "eyJ4cC51Ijo0NTU2OTcsInhwLnAiOjQ1NTY4OSwieHAubSI6Ik1UVTRPVE0yTnprMU1EQXlNdyIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE5MDQ3Mjc5NTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.9PEKvslTXNVQjibm_oLIBni8iknsIwo1etQfjBMQ8ME";

@Parameters({"Device"})		
  @BeforeTest
	public void setUp( String Device) throws MalformedURLException {
	  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	  if (Device.contentEquals("Emulator_Device")) {
	   System.out.println("Entering Emulator device");
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("platformVersion", "10");
	    desiredCapabilities.setCapability("deviceName", "Android SDK built for x86");
	    desiredCapabilities.setCapability("appPackage", "com.buzzfeed.tasty");
	    desiredCapabilities.setCapability("appActivity", "com.buzzfeed.tasty.LauncherActivity");
	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	    user= new UserActions(driver);
	  }
	   
	   else if (Device.contentEquals("Cloud_Device")) {
				System.out.println("Entering Cloud device");
				desiredCapabilities.setCapability("testName", "Quick Start Android Native Demo");
				desiredCapabilities.setCapability("accessKey", accessKey);
				desiredCapabilities.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
				desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.buzzfeed.tasty");
				desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.buzzfeed.tasty.LauncherActivity");
		        driver = new AndroidDriver<>(new URL("https://demo.experitest.com/wd/hub"), desiredCapabilities);
				user= new UserActions(driver);
	    }

	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  
}
  @BeforeClass
  public void login() throws IOException {
	user= new UserActions(driver);
	if(accessKey==null)
	{
		user.Click(pageObjects_Swetha.loginwithgoogle);
		user.Click(pageObjects_Swetha.displayname);
	}
    
  }
  @Test(dataProvider = "dp")
  public void sampleTest(String recepieName) {
	 user.Click(pageObjects_Swetha.SearchBox);
	 user.Click(pageObjects_Swetha.clicksearch);
	 user.ClearAndSendKeys(pageObjects_Swetha.clicksearch, recepieName);
	 user.Click(pageObjects_Swetha.Suggestion);
	 if(accessKey==null) {
		 user.Click(pageObjects_Swetha.ImageView);
	 }else {
		 user.Click(pageObjects_Swetha.selectItem);
	 }
	 
	 
	 user.Click(pageObjects_Swetha.AddtoReceipes);
	 user.Click(pageObjects_Swetha.MyReceipes);
	 user.Click(pageObjects_Swetha.Discover);
	 user.Click(pageObjects_Swetha.BackButton);
  }
	  
  @DataProvider
  public Object[] dp() {
	  
		return ExcelUtil.getTestData("./testData.xlsx", "Swetha")  ;
	  
  }
  

  @AfterClass
  public void tearDown() {
	  
    driver.quit();
  }
}