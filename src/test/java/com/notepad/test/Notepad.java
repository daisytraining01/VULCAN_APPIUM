package com.notepad.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.helper.ExcelUtil;
import com.helper.UserActions;

import com.notepad.pageObjects.PageObjects;

public class Notepad {

	AndroidDriver driver;
	UserActions user;

	static String accesskey = null;

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
			driver = new AndroidDriver(new URL("http://localhost:4726/wd/hub"), desiredCapabilities);
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

		user.Click(PageObjects.newNote);
		user.SendKeys(PageObjects.editTitle, title);
		user.SendKeys(PageObjects.editContent, content);
		user.Click(PageObjects.saveNote);

		user.Click(PageObjects.newNote);
		user.SendKeys(PageObjects.editTitle, title);
		user.SendKeys(PageObjects.editContent, content);
		user.Click(PageObjects.saveNote);

		user.Click(PageObjects.SavedItems);
		user.Click(PageObjects.Delete);

		user.Click(PageObjects.Button);

	}

	@DataProvider
	public Object[][] dp() {

		return ExcelUtil.getTestData("./testData.xlsx", "Madhu");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
