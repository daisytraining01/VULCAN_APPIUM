package com.appium.test;


	import io.appium.java_client.MobileElement;
	import io.appium.java_client.android.AndroidDriver;
	//import junit.framework.TestCase;
	//import org.junit.After;
	//import org.junit.Before;
	//import org.junit.Test;
	import java.net.MalformedURLException;
	import java.net.URL;
	import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class Gokuluniv {

	  private AndroidDriver driver;

	  @BeforeTest
	  public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("platformVersion", "10");
	    desiredCapabilities.setCapability("udid", "34af02ee");
	    desiredCapabilities.setCapability("deviceName", "DGGOKUL");
	    desiredCapabilities.setCapability("appPackage", "patel.krupesh.amazinguniversefactsapp");
	    desiredCapabilities.setCapability("appActivity", ".MainActivity");

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	  }

	  @Test
	  public void sampleTest() {
	    MobileElement el1 = (MobileElement) driver.findElementById("android:id/button3");
	    el1.click();
	    el1.click();
	    MobileElement el2 = (MobileElement) driver.findElementById("android:id/search_src_text");
	    el2.sendKeys("Titan");
	    MobileElement el3 = (MobileElement) driver.findElementById("patel.krupesh.amazinguniversefactsapp:id/title_lv_item");
	    el3.click();
	    MobileElement el4 = (MobileElement) driver.findElementById("android:id/search_src_text");
	    el4.sendKeys("satellites");
	    MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView[2]");
	    el5.click();
	    MobileElement el6 = (MobileElement) driver.findElementById("patel.krupesh.amazinguniversefactsapp:id/message");
	    el6.click();
	    MobileElement el7 = (MobileElement) driver.findElementById("patel.krupesh.amazinguniversefactsapp:id/title_content");
	    el7.click();
	  }

	  @AfterTest
	  public void tearDown() {
	    driver.quit();
	  }
	}



