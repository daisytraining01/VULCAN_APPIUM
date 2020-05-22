package com.appium.test;

import org.testng.annotations.Test;

import com.appium.pageObjects.pageObjects_Mohan;
import com.beust.jcommander.Parameter;
import com.helper.ExcelUtil;
import com.helper.UserActions;
import com.listner.TestListener;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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



public class wordweb_Mohan  {
	

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
			desiredCapabilities.setCapability("appPackage", "com.wordwebsoftware.android.wordweb");
			desiredCapabilities.setCapability("appActivity", "com.wordwebsoftware.android.wordweb.activity.WordWebActivity");
			desiredCapabilities.setCapability("unicodeKeyboard", "true");
			desiredCapabilities.setCapability("resetKeyboard", "true");
			URL remoteUrl = new URL("http://localhost:4723/wd/hub");
			driver = new AndroidDriver(remoteUrl, desiredCapabilities);
			user= new UserActions(driver);
			
		} else if (Device.contentEquals("Cloud_Device")) {
			System.out.println("Entering Cloud device");
			desiredCapabilities.setCapability("testName", "WordWeb");
			accessKey = "eyJ4cC51Ijo0NTU2OTcsInhwLnAiOjQ1NTY4OSwieHAubSI6Ik1UVTRPVE0yTnprMU1EQXlNdyIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE5MDQ3Mjc5NTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.9PEKvslTXNVQjibm_oLIBni8iknsIwo1etQfjBMQ8ME";
			desiredCapabilities.setCapability("accessKey", accessKey);
			desiredCapabilities.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.wordwebsoftware.android.wordweb");
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.wordwebsoftware.android.wordweb.activity.WordWebActivity");
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
			desiredCapabilities.setCapability("appPackage", "com.wordwebsoftware.android.wordweb");
			desiredCapabilities.setCapability("appActivity", "com.wordwebsoftware.android.wordweb.activity.WordWebActivity");
			desiredCapabilities.setCapability("unicodeKeyboard", "true");
			desiredCapabilities.setCapability("resetKeyboard", "true");
			URL remoteUrl = new URL("http://localhost:4723/wd/hub");
			 driver = new AndroidDriver(remoteUrl, desiredCapabilities);
			user= new UserActions(driver);
			
			
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	
	
	@BeforeClass
	public void loadDatabase() throws IOException {
		if(accessKey==null) {
			user.Click(pageObjects_Mohan.clikCheckatabase);
		}
		
		
		
	}
	
	
	
	@Test(dataProvider = "dp")
	public void Wordweb(String searchText, String wordType) throws IOException {
		System.out.println("Enter");

	    
	    
		
		user.ClearAndSendKeys(pageObjects_Mohan.searchText, searchText);
		user.Click(pageObjects_Mohan.clickFirstResult);
		
		user.pass("Tetxt search result", driver);
		user.Click(pageObjects_Mohan.bookMark);
		user.Click(pageObjects_Mohan.backButton);
		
		
		user.Click(pageObjects_Mohan.searchTab);
		System.out.println(wordType);
		
//		System.out.println(Integer.parseInt( wordType.split(".")[0]));
		
		
		switch (Integer.parseInt( wordType)) {
		case 1:
			user.Click(pageObjects_Mohan.noun);
			break;
		case 2:
			user.Click(pageObjects_Mohan.verb);
			break;
		case 3:
			user.Click(pageObjects_Mohan.adverb);
			break;
		case 4:
			user.Click(pageObjects_Mohan.adjuctive);
			break;

		default:
			user.Click(pageObjects_Mohan.noun);
		}
		
		
		
		
		user.ClearAndSendKeys(pageObjects_Mohan.searchText, searchText);
		
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		user.Click(pageObjects_Mohan.clickFirstResultType);
		
		user.pass("Tetxt search result", driver);
		user.Click(pageObjects_Mohan.bookMark);
		user.Click(pageObjects_Mohan.backButton);
		user.Click(pageObjects_Mohan.lookup);
		  


	}
	
	
	  @DataProvider
	  public Object[][] dp() {
		  
			return ExcelUtil.getTestData("./testData.xlsx", "Mohan")  ;

	  }
	
	
	@AfterClass
	public void logout() throws IOException {

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
