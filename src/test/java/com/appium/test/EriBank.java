package com.appium.test;

import org.testng.annotations.Test;

import com.appium.pageObjects.pageObjects;
import com.beust.jcommander.Parameter;
import com.helper.ExcelUtil;
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



public class EriBank  {
	

	UserActions user;
	AndroidDriver driver;
	
	static String accessKey = null;

	
	@Parameters({"Device"})		
	@BeforeTest
	public void setUp( String Device) throws MalformedURLException {
		
	
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		System.out.println(Device);
		if (Device.contentEquals("Real_Device")) {
			System.out.println("Entering locl device");
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("platformVersion", "10");
			desiredCapabilities.setCapability("udid", "RZ8M90DTVRN");
			desiredCapabilities.setCapability("deviceName", "Samsung");
			desiredCapabilities.setCapability("appPackage", "com.experitest.ExperiBank");
			desiredCapabilities.setCapability("appActivity", ".LoginActivity");
			URL remoteUrl = new URL("http://localhost:4723/wd/hub");
			driver = new AndroidDriver(remoteUrl, desiredCapabilities);
			user= new UserActions(driver);
			
		} else if (Device.contentEquals("Cloud_Device")) {
			System.out.println("Entering Cloud device");
			desiredCapabilities.setCapability("testName", "Mani");
			accessKey = "eyJ4cC51Ijo0NTU2OTcsInhwLnAiOjQ1NTY4OSwieHAubSI6Ik1UVTRPVE0yTnprMU1EQXlNdyIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE5MDQ3Mjc5NTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.9PEKvslTXNVQjibm_oLIBni8iknsIwo1etQfjBMQ8ME";
			desiredCapabilities.setCapability("accessKey", accessKey);
			desiredCapabilities.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
			driver = new AndroidDriver(new URL("https://demo.experitest.com/wd/hub"), desiredCapabilities);
			user= new UserActions(driver);
		}else if (Device.contentEquals("Emulator_Device")) {
			System.out.println("Entering Emulator");
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("platformVersion", "9");
			desiredCapabilities.setCapability("udid", "emulator-5554");
			desiredCapabilities.setCapability("deviceName", "Emulator");
			desiredCapabilities.setCapability("appPackage", "com.experitest.ExperiBank");
			desiredCapabilities.setCapability("appActivity", ".LoginActivity");

			URL remoteUrl = new URL("http://localhost:4725/wd/hub");
			 driver = new AndroidDriver(remoteUrl, desiredCapabilities);
			user= new UserActions(driver);
			
			
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	
	
	@BeforeClass
	public void login() throws IOException {
//		user.pass("Application launche successully", driver);
		   user.Click(pageObjects.userName);
		    user.SendKeys(pageObjects.userName, "company");
		    user.Click(pageObjects.password);
		    user.SendKeys(pageObjects.password, "company");
  		    user.Click(pageObjects.loginButton);
  		    
  		    
	}
	
	
	
	@Test(dataProvider = "dp")
	public void sampleTest(String mobileNumber, String name) throws IOException {
		
		user.pass("Loin successul", driver);
		
	    user.Click(pageObjects.makePaymentButton);
	    
	    user.SendKeys(pageObjects.phoneTextField, mobileNumber);
	    user.SendKeys(pageObjects.nameTextField, name);
		if (accessKey == null) {
			TouchAction action = new TouchAction(driver);
			action.press(PointOption.point(386, 718)).moveTo(PointOption.point(506, 718)).release().perform();

		} else {
			TouchAction action = new TouchAction(driver);
			action.press(PointOption.point(390, 736)).moveTo(PointOption.point(506, 736)).release().perform();
		}

		  user.Click(pageObjects.country);
		  user.Click(pageObjects.India);
		  
		  user.Click(pageObjects.sendPaymentButton);
		  user.Click(pageObjects.confirmationButton);
		  
		  user.pass("Payment successul", driver);

	}
	
	
	  @DataProvider
	  public Object[][] dp() {
		  
			return ExcelUtil.getTestData("./testData.xlsx", "data")  ;
//		    return new Object[][] {
//	      new Object[] { "9786986811", "mohan" },
//	      new Object[] { "9786986812", "Goutham" },
//	      new Object[] { "9786986813", "Kevin" },
//	      
//	    };
	  }
	
	
	@AfterClass
	public void logout() throws IOException {
		user.Click(pageObjects.Logout);
		user.pass("Logout successul", driver);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
