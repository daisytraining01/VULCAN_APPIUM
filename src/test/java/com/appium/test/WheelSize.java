package com.appium.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.appium.pageObjects.WheelSizePageObject;
import com.helper.DatabaseConnection;
import com.helper.ExcelUtil;
import com.helper.UserActions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class WheelSize {
	UserActions user;
	AndroidDriver driver;
	DesiredCapabilities desiredCapabilities;
	static String accessKey = null;
	
@BeforeSuite
private void beforeSuite() {
	// TODO Auto-generated method stub

}



	@Parameters({"Device"})
	@BeforeTest
	public void setUp(String device) throws MalformedURLException {
		 desiredCapabilities = new DesiredCapabilities();
		if (device.contentEquals("Real_Device")) {
			System.out.println("Entering local device");
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("platformVersion", "7");
			desiredCapabilities.setCapability("deviceName", "ASUS_X008DA");
			desiredCapabilities.setCapability("udid", "H2AXJA0037824HB");
			desiredCapabilities.setCapability("appPackage", "com.wheelsize");
			desiredCapabilities.setCapability("appActivity", ".presentation.container.AppContainer");
			/*URL remoteUrl = new URL("http://localhost:4723/wd/hub");
			driver = new AndroidDriver(remoteUrl, desiredCapabilities);
			user = new UserActions(driver);*/
		} else if (device.contentEquals("Cloud_Device")){
			System.out.println("Entering Cloud device");
			desiredCapabilities.setCapability("testName", "WordWeb");
			accessKey = "eyJ4cC51Ijo0NTU2OTcsInhwLnAiOjQ1NTY4OSwieHAubSI6Ik1UVTRPVE0yTnprMU1EQXlNdyIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE5MDQ3Mjc5NTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.9PEKvslTXNVQjibm_oLIBni8iknsIwo1etQfjBMQ8ME";
			desiredCapabilities.setCapability("accessKey", accessKey);
			desiredCapabilities.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.wheelsize");
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.wheelsize.presentation.container.AppContainer");
			desiredCapabilities.setCapability("unicodeKeyboard", "true");
			desiredCapabilities.setCapability("resetKeyboard", "true");
			/*driver = new AndroidDriver(new URL("https://demo.experitest.com/wd/hub"), desiredCapabilities);
			user= new UserActions(driver);*/
		}
		
	}
	@BeforeClass
	private void beforeClass() {
		// TODO Auto-generated method stub

	}
	@Parameters({"Device"})
	@BeforeMethod
	private void beforeMethod(String device) throws MalformedURLException {
		if(device.contentEquals("Cloud_Device")) {
			driver = new AndroidDriver(new URL("https://demo.experitest.com/wd/hub"), desiredCapabilities);
			user= new UserActions(driver);
		}
		else if(device.contentEquals("Real_Device")){
			URL remoteUrl = new URL("http://localhost:4723/wd/hub");
			driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		}
		user= new UserActions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	//@Ignore
	@Test(priority=0,dataProvider = "dp")
	public void searchWheelSize(String maker, String year, String model, String trim) throws IOException {
		user.pass("Application Launch successfull", driver);
		user.SendKeys(WheelSizePageObject.maker, maker);
		user.SendKeys(WheelSizePageObject.year, year);
		user.SendKeys(WheelSizePageObject.model, model);
		user.SendKeys(WheelSizePageObject.trim, trim);
		user.Click(WheelSizePageObject.searchBtn);
		user.pass("Wheel Search successfull", driver);
	}
	@Ignore
	  @Test(priority=1)
	  public void rateTestExecution() throws IOException {
		  user.pass("Application Launch successfull", driver);
		 
		  user.Click(WheelSizePageObject.wheelImage);
		  user.Click(WheelSizePageObject.setting);
		  user.Click(WheelSizePageObject.rateUs);
		  user.Click(WheelSizePageObject.cancelBtn);
		  user.Click(WheelSizePageObject.settingBack);
		  user.Click(WheelSizePageObject.searchMain);
		user.pass("Search successfull", driver);
	  }
	@DataProvider
	public Object[][] dp() throws SQLException {
		//return ExcelUtil.getTestData("./testData.xlsx", "Wheel");
		//return new Object [][] {{"Apollo"},{"2020"},{"AZ05"},{"Grip"}};
		
		 Object data[][]= DatabaseConnection.getDataFromDatabase("Shambhu");     
         return data;
	}
	@AfterMethod
	private void afterMethod() throws IOException {
		user.pass("Logout successfull", driver);
		//driver.quit();

	}
	
	@AfterClass
	private void afterClass() {
		// TODO Auto-generated method stub

	}
	@AfterTest
	public void tearDown() throws IOException {
		
	}
	@AfterSuite
	private void afterSuite() {
		// TODO Auto-generated method stub

	}

}
