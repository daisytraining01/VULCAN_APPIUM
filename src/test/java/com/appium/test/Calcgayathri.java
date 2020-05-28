package com.appium.test;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.helper.UserActions;	

	public class Calcgayathri {
    private AndroidDriver driver;
    UserActions user ;
    @Parameters({"Device"})   
	@BeforeTest
	public void setUp(String Device) throws MalformedURLException {
	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	if (Device.contentEquals("Cloud_Device")) {
		System.out.println("Entering Cloud device");
		desiredCapabilities.setCapability("testName", "Gayathri");
    String accessKey="eyJ4cC51Ijo0NTU2OTcsInhwLnAiOjQ1NTY4OSwieHAubSI6Ik1UVTRPVE0yTnprMU1EQXlNdyIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE5MDQ3Mjc5NTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.9PEKvslTXNVQjibm_oLIBni8iknsIwo1etQfjBMQ8ME";
    desiredCapabilities.setCapability("accessKey", accessKey);
    desiredCapabilities.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
    desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.dencreak.dlcalculator");
    desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.dencreak.dlcalculator.DLCalculatorActivity");
    driver = new AndroidDriver<MobileElement>(new URL("https://demo.experitest.com/wd/hub"), desiredCapabilities);
   
    user= new UserActions(driver);
	}
    }

    

	@Test
	public void sampleTest() {
	MobileElement el1 = (MobileElement) driver.findElement(By.xpath("//*[@text='8']"));
	el1.click();
	MobileElement el2 = (MobileElement) driver.findElement(By.id("2131297093"));
	el2.click();
	MobileElement el3 = (MobileElement) driver.findElement(By.xpath("//*[@text='5']"));
	el3.click();
	MobileElement el4 = (MobileElement) driver.findElement(By.id("2131297097"));
	el4.click();
	MobileElement el5 = (MobileElement) driver.findElement(By.id("2131296760"));
	el5.click();
	
	
	}


	@AfterTest
	public void tearDown() {
	driver.quit();
	}
	} 
