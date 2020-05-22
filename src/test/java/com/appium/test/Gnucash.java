package com.appium.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.appium.pageObjects.pageObjects;
import com.helper.ExcelUtil;
import com.helper.UserActions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class Gnucash {

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
			desiredCapabilities.setCapability("platformVersion", "7");
			desiredCapabilities.setCapability("deviceName", "Redmi");
			desiredCapabilities.setCapability("udid", "8b3f97190804");
			desiredCapabilities.setCapability("appPackage", "org.gnucash.android");
			desiredCapabilities.setCapability("appActivity", ".ui.account.AccountsActivity");
			URL remoteUrl = new URL("http://localhost:4723/wd/hub");
			driver = new AndroidDriver(remoteUrl, desiredCapabilities);
			
			user= new UserActions(driver);
			
		} else if (Device.contentEquals("Cloud_Device")) {
			System.out.println("Entering Cloud device");
			desiredCapabilities.setCapability("testName", "Suganth");
			accessKey = "eyJ4cC51Ijo0NTU2OTcsInhwLnAiOjQ1NTY4OSwieHAubSI6Ik1UVTRPVE0yTnprMU1EQXlNdyIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE5MDQ3Mjc5NTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.9PEKvslTXNVQjibm_oLIBni8iknsIwo1etQfjBMQ8ME";
			desiredCapabilities.setCapability("accessKey", accessKey);
			desiredCapabilities.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.gnucash.android");
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ui.account.AccountsActivity");
			driver = new AndroidDriver(new URL("https://demo.experitest.com/wd/hub"), desiredCapabilities);
			user= new UserActions(driver);
		}else if (Device.contentEquals("Emulator_Device")) {
			System.out.println("Entering Emulator");
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("platformVersion", "9");
			desiredCapabilities.setCapability("udid", "emulator-5554");
			desiredCapabilities.setCapability("deviceName", "Emulator");
			desiredCapabilities.setCapability("appPackage", "org.gnucash.android");
			desiredCapabilities.setCapability("appActivity", ".ui.account.AccountsActivity");

			URL remoteUrl = new URL("http://localhost:4725/wd/hub");
			 driver = new AndroidDriver(remoteUrl, desiredCapabilities);
			user= new UserActions(driver);
			
			
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/*
	  @DataProvider
	  public Object[][] dp() {
		  
			return ExcelUtil.getTestData("./testData.xlsx", "data")  ;
	  }
	  
	  @Test(dataProvider="dp")
		public void withDataProvider(String Description,String amount) throws IOException {
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			user.Click(pageObjects.Next);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			user.Click(pageObjects.Next);
			user.Click(pageObjects.Next);
			user.Click(pageObjects.checkbox);
			user.Click(pageObjects.Next);
			user.Click(pageObjects.Next);
			user.Click(pageObjects.button1);
			TouchAction action = new TouchAction(driver);
			action.tap(PointOption.point(522, 1280)).perform();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			user.Click(pageObjects.salary1);
			user.SendKeys(pageObjects.salaryDescription,Description);
			user.SendKeys(pageObjects.salaryAmount1, amount);
			user.Click(pageObjects.salaryType1);
			user.Click(pageObjects.salaryDropDown1);
			user.Click(pageObjects.salaryDropDownValue1);
			user.Click(pageObjects.salarySave1);
			user.Click(pageObjects.bonus1);
			user.SendKeys(pageObjects.bonusDescription1,"My Bonus");
			user.SendKeys(pageObjects.bonusAmount1,"2000");
			user.Click(pageObjects.bonusType1);
			user.Click(pageObjects.bonusSave1);
			
			driver.navigate().back();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
			user.Click(pageObjects.Expenses1);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			user.Click(pageObjects.addExpenses1);
			user.SendKeys(pageObjects.accountName1,"KKBK");
			user.SendKeys(pageObjects.accountDescription1,"My Expense");
			user.Click(pageObjects.placeholderAccount1);
			user.Click(pageObjects.Expensesave1);
			driver.navigate().back();
		}
	*/
	@Test
	public void withoutDataProvider() throws IOException {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		user.Click(pageObjects.Next);
		user.Click(pageObjects.Next);
		user.Click(pageObjects.Next);
		user.Click(pageObjects.checkbox);
		user.Click(pageObjects.Next);
		user.Click(pageObjects.Next);
		user.Click(pageObjects.button1);
		TouchAction action = new TouchAction(driver);
		action.tap(PointOption.point(522, 1280)).perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		user.Click(pageObjects.salary1);
		user.SendKeys(pageObjects.salaryDescription,"My Salary");
		user.SendKeys(pageObjects.salaryAmount1, "2000");
		user.Click(pageObjects.salaryType1);
		user.Click(pageObjects.salaryDropDown1);
		user.Click(pageObjects.salaryDropDownValue1);
		user.Click(pageObjects.salarySave1);
		user.Click(pageObjects.bonus1);
		user.SendKeys(pageObjects.bonusDescription1,"My Bonus");
		user.SendKeys(pageObjects.bonusAmount1,"2000");
		user.Click(pageObjects.bonusType1);
		user.Click(pageObjects.bonusSave1);
		
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		user.Click(pageObjects.Expenses1);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		user.Click(pageObjects.addExpenses1);
		user.SendKeys(pageObjects.accountName1,"KKBK");
		user.SendKeys(pageObjects.accountDescription1,"My Expense");
		user.Click(pageObjects.placeholderAccount1);
		user.Click(pageObjects.Expensesave1);
		driver.navigate().back();
	}
	
	
	  
	 
	 @AfterTest
		public void afterTest() {
			driver.quit();
		}
}
