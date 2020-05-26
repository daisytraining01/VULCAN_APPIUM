package com.appium.test;

import org.testng.annotations.Test;

import com.helper.UserActions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class GithubAutomation {
	
	WebDriver driver;
	
 
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	  
	  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	  		  	desiredCapabilities.setCapability("testName", "WordWeb");
		String accessKey = "eyJ4cC51Ijo0NTU2OTcsInhwLnAiOjQ1NTY4OSwieHAubSI6Ik1UVTRPVE0yTnprMU1EQXlNdyIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE5MDQ3Mjc5NTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.9PEKvslTXNVQjibm_oLIBni8iknsIwo1etQfjBMQ8ME";
		desiredCapabilities.setCapability("accessKey", accessKey);
		desiredCapabilities.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
		driver = new AndroidDriver<WebElement>(new URL("https://demo.experitest.com/wd/hub"), desiredCapabilities);
		desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  
  
  
  @Test
  public void browserGitHub() throws InterruptedException {
     

          driver.get("https://github.com/");
          WebElement drawer =  driver.findElement(By.xpath("//*[@text='Toggle navigation']"));
          drawer.click();
          
          WebElement signIn =  driver.findElement(By.xpath("//*[@text='          Sign in        ']"));
          signIn.click();
          
          WebElement userName =  driver.findElement(By.xpath("//*[@name='login']"));
          userName.sendKeys("daisyTraining01");
          WebElement password =  driver.findElement(By.id("password"));
          password.sendKeys("maveric@123");
          
          WebElement signInButton =  driver.findElement(By.xpath("//*[@name='commit']"));
          signInButton.click();
          Thread.sleep(30000);
  }
  

  @AfterTest
  public void afterTest() {
  }

}
