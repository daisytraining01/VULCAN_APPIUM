package com.notepad.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.helper.ExcelUtil;
import com.helper.UserActions;

import com.notepad.pageObjects.PageObjects;

public class Notepad {

	AndroidDriver driver;
	UserActions user;

	static String accesskey = null;

	@BeforeClass

	public void LaunchApp() {
		System.out.println("Launch the App");
	}

	@Parameters({ "Device" })
	@BeforeTest
	public void setUp(String Device) throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		System.out.println(Device);

		if (Device.contentEquals("Emulator_Device")) {

			System.out.println("Accessing Emulator Device");

			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("PlatformVersion", "10");
			// desiredCapabilities.setCapability("PlatformVersion", "8.1.0");
			desiredCapabilities.setCapability("deviceName", "Android SDK built for x86");
			// desiredCapabilities.setCapability("deviceName", "Redmi Note 5");
			desiredCapabilities.setCapability("udid", "emulator-5554");
			// desiredCapabilities.setCapability("udid", "fecf9b340005");
			desiredCapabilities.setCapability("appPackage", "com.hilarywang29.notepad2");
			desiredCapabilities.setCapability("appActivity", "com.hilarywang29.notepad2.MainActivity");
			desiredCapabilities.setCapability("automationName", "UiAutomator1");

			URL remoteUrl = new URL("http://localhost:4726/wd/hub");
			driver = new AndroidDriver(remoteUrl, desiredCapabilities);

			user = new UserActions(driver);

		} else if (Device.contentEquals("Cloud_Device")) {

			System.out.println("Accessing Cloud Device");

			desiredCapabilities.setCapability("testName", "Cloud");
			accesskey = "eyJ4cC51Ijo0NTU2OTcsInhwLnAiOjQ1NTY4OSwieHAubSI6Ik1UVTRPVE0yTnprMU1EQXlNdyIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE5MDQ3Mjc5NTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.9PEKvslTXNVQjibm_oLIBni8iknsIwo1etQfjBMQ8ME";
			desiredCapabilities.setCapability("accessKey", accesskey);
			desiredCapabilities.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.hilarywang29.notepad2");
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
					"com.hilarywang29.notepad2.MainActivity");
			driver = new AndroidDriver(new URL("https://demo.experitest.com/wd/hub"), desiredCapabilities);
			user = new UserActions(driver);

		} else if (Device.contentEquals("Real_Device")) {
			System.out.println("Accessing Real Device");
			desiredCapabilities.setCapability("platformName", "Android");
			// desiredCapabilities.setCapability("PlatformVersion", "10");
			desiredCapabilities.setCapability("PlatformVersion", "8.1.0");
			// desiredCapabilities.setCapability("deviceName", "Android SDK built for x86");
			desiredCapabilities.setCapability("deviceName", "Redmi Note 5");
			// desiredCapabilities.setCapability("udid", "emulator-5554");
			desiredCapabilities.setCapability("udid", "fecf9b340005");
			desiredCapabilities.setCapability("appPackage", "com.hilarywang29.notepad2");
			desiredCapabilities.setCapability("appActivity", "com.hilarywang29.notepad2.MainActivity");
			desiredCapabilities.setCapability("automationName", "UiAutomator1");

			URL remoteUrl = new URL("http://localhost:4726/wd/hub");
			driver = new AndroidDriver(remoteUrl, desiredCapabilities);
			user = new UserActions(driver);

		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test(dataProvider = "dp")
	public void sampleTest(String title, String content) throws IOException {

		/*
		 * @Test public void sampleTest() { MobileElement el1 = (MobileElement)
		 * driver.findElementByAccessibilityId("New Note"); el1.click(); MobileElement
		 * el2 = (MobileElement)
		 * driver.findElementById("com.hilarywang29.notepad2:id/editTitle");
		 * el2.sendKeys("SIT"); MobileElement el3 = (MobileElement)
		 * driver.findElementById("com.hilarywang29.notepad2:id/editContent");
		 * el3.sendKeys("SIT-System Integration Testing"); MobileElement el4 =
		 * (MobileElement) driver.findElementByAccessibilityId("Save"); el4.click(); }
		 * 
		 */

		/*
		 * @Test public void sampleTest() { MobileElement el1 = (MobileElement)
		 * driver.findElementByAccessibilityId("New Note"); el1.click(); MobileElement
		 * el2 = (MobileElement)
		 * driver.findElementById("com.hilarywang29.notepad2:id/editTitle");
		 * el2.sendKeys("UAT"); MobileElement el3 = (MobileElement)
		 * driver.findElementById("com.hilarywang29.notepad2:id/editContent");
		 * el3.sendKeys("User Acceptance Testing"); MobileElement el4 = (MobileElement)
		 * driver.findElementByAccessibilityId("Save"); el4.click(); MobileElement el5 =
		 * (MobileElement) driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout"
		 * ); el5.click(); MobileElement el6 = (MobileElement)
		 * driver.findElementByAccessibilityId("Delete Note"); el6.click();
		 * MobileElement el7 = (MobileElement)
		 * driver.findElementById("android:id/button1"); el7.click();
		 * 
		 */

		user.Click(PageObjects.newNote);
		user.SendKeys(PageObjects.editTitle, title);
		user.SendKeys(PageObjects.editContent, content);
		user.Click(PageObjects.saveNote);

	}

	// @Ignore
	@Test(dataProvider = "dp1", dependsOnMethods = { "sampleTest" })

	public void sampleTest1(String title1, String content1) {

		user.Click(PageObjects.newNote);
		user.SendKeys(PageObjects.editTitle, title1);
		user.SendKeys(PageObjects.editContent, content1);
		user.Click(PageObjects.saveNote);
		user.Click(PageObjects.frame);
		user.Click(PageObjects.deleteNote);
		user.Click(PageObjects.button);

	}

	@DataProvider
	public Object[][] dp() {

		return ExcelUtil.getTestData("./testData.xlsx", "Madhu");

	}

	@DataProvider
	public Object[][] dp1() {

		return ExcelUtil.getTestData("./testData.xlsx", "Madhu1");

	}

	@AfterClass

	public void TerminateApp() {
		System.out.println("Terminate the App");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
