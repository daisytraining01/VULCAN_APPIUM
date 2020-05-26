package com.appium.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.appium.pageObjects.pageObjects;
import com.helper.DatabaseConnection;
import com.helper.ExcelUtil;
import com.helper.UserActions;
import com.listner.TestListener;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

@Listeners(TestListener.class)

public class EmiCalculatorKevin {
	
	UserActions user;
	AndroidDriver driver;
	private boolean tenure;
    private String accessKey = "eyJ4cC51Ijo0NTU2OTcsInhwLnAiOjQ1NTY4OSwieHAubSI6Ik1UVTRPVE0yTnprMU1EQXlNdyIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE5MDQ3Mjc5NTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.9PEKvslTXNVQjibm_oLIBni8iknsIwo1etQfjBMQ8ME";
    private int count = 1;

    
    @Parameters({"Device"})		
	@BeforeTest
	public void setUp( String Device) throws MalformedURLException {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		System.out.println(Device);
		if (Device.contentEquals("Real_Device")) {
			System.out.println("Entering locl device");
		    desiredCapabilities.setCapability("platformName", "Android");
		    desiredCapabilities.setCapability("platformVersion", "11");
		    desiredCapabilities.setCapability("deviceName", "Redmi Note 7 Pro");
		    desiredCapabilities.setCapability("udid", "56b332f7");
		    desiredCapabilities.setCapability("appPackage", "com.avrapps.emicalculator");
		    desiredCapabilities.setCapability("appActivity", ".activities.EMICalculator");
		    desiredCapabilities.setCapability("automationName", "UiAutomator1");
		    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
			user= new UserActions(driver);
						
		} else if (Device.contentEquals("Cloud_Device")) {
			System.out.println("Entering Cloud device");
			//desiredCapabilities.setCapability("testName", "Mani");
			desiredCapabilities.setCapability("accessKey", accessKey);
			desiredCapabilities.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.avrapps.emicalculator");
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".activities.EMICalculator");
			driver = new AndroidDriver(new URL("https://demo.experitest.com/wd/hub"), desiredCapabilities);
			user= new UserActions(driver);
			
		}else if (Device.contentEquals("Emulator_Device")) {
			System.out.println("Entering Emulator");
			desiredCapabilities.setCapability("platformName", "Android");
		    desiredCapabilities.setCapability("platformVersion", "10");
		    desiredCapabilities.setCapability("deviceName", "Pixel_2");
		    desiredCapabilities.setCapability("udid", "emulator-5554");
		    desiredCapabilities.setCapability("appPackage", "com.avrapps.emicalculator");
		    desiredCapabilities.setCapability("appActivity", ".activities.EMICalculator");
		    desiredCapabilities.setCapability("automationName", "UiAutomator1");
		    tenure = true;
		    URL remoteUrl = new URL("http://localhost:4723/wd/hub"); 
		    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
			user= new UserActions(driver);
		}

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	
	@Test(dataProvider = "dp")
	public void sampleTest(String amount, String interest, String emi_name) throws IOException, InterruptedException {			
		
		user.pass("Application Opened Successfully..", driver);
		System.out.println(amount);
		String str = amount.replace(".0","");
		System.out.println(str);
		user.ClearAndSendKeys(pageObjects.amount,str);
		user.ClearAndSendKeys(pageObjects.interest, interest);
	    TouchAction action= new TouchAction(driver);
	    Thread.sleep(1000);
	    if(tenure==false)
	    	action.press(PointOption.point(388, 1143)).moveTo(PointOption.point(281, 740)).release().perform();
	    else
	    	action.press(PointOption.point(200, 740)).moveTo(PointOption.point(281, 650)).release().perform();	
		user.WaitAndClick(pageObjects.calculate, 20);
		Thread.sleep(2000);
		user.Click(pageObjects.save);
		user.SendKeys(pageObjects.emi_Name, emi_name);
		user.Click(pageObjects.ok_button);
	}
	
	@Test(dependsOnMethods = {"sampleTest"})
	public void sampleTest2() throws IOException, InterruptedException {
		for(int k=1;k<5;k++)
		{
		user.Click(pageObjects.Saved_Emi);
		Thread.sleep(1000);
		user.pass("Saved Successfully....", driver);
		if(count==1)
		{
			user.Click(pageObjects.Emi);
			count++;
			user.Click(pageObjects.Currency_Tab);
			user.Click(pageObjects.Currency);
			user.Click(pageObjects.Navigate_Tab);
			Thread.sleep(1000);
			user.Click(pageObjects.Emi_Cal);
			k++;
		}
		else if(count>=2 && count<6)
		{
			for(int j=2;j<6;j++)
			{
				MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout["+j+"]");
				el1.click();
				count++;
				user.Click(pageObjects.Currency_Tab);
				user.Click(pageObjects.Currency);
				user.Click(pageObjects.Navigate_Tab);
				Thread.sleep(1000);
				user.Click(pageObjects.Navigate_Tab);
				//user.Click(pageObjects.Emi_Cal);
				k++;
			}
		}
	}
	
	}
	  
	@Ignore
	@Test(dataProvider = "dp")
	public void sampleTest3() throws IOException, InterruptedException {			
		
		user.pass("Application Opened Successfully..", driver);
		user.ClearAndSendKeys(pageObjects.amount,"10000");
		user.ClearAndSendKeys(pageObjects.interest, "7.5");
	    TouchAction action= new TouchAction(driver);
	    Thread.sleep(1000);
	    if(tenure==false)
	    	action.press(PointOption.point(388, 1143)).moveTo(PointOption.point(281, 740)).release().perform();
	    else
	    	action.press(PointOption.point(200, 740)).moveTo(PointOption.point(281, 650)).release().perform();	
		user.WaitAndClick(pageObjects.calculate, 20);
		Thread.sleep(2000);
		user.Click(pageObjects.save);
		user.SendKeys(pageObjects.emi_Name,"Car Emi");
		user.Click(pageObjects.ok_button);
		user.pass("Saved successfully..", driver);
	}
	
	  @Ignore
	  @DataProvider
	  public Object[][] dp1() { 
			return ExcelUtil.getTestData("./testData.xlsx", "EMI");
	  }
	  
	    
      @DataProvider
      public Object[][] dp() throws SQLException {
          Object data[][]= DatabaseConnection.getDataFromDatabase("Kevin");      
          return data;
      }
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
