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

public class wordpressAutomation {
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
  }
  @Test
  public void browserTestGoogleSearch() throws InterruptedException {
     

          driver.get("https://wordpress.com/wp-login.php");
          new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("usernameOrEmail")));
          WebElement userName = driver.findElement(By.id("usernameOrEmail"));
          userName.sendKeys("daisytraining01");

          driver.findElement(By.xpath("//*[@id='primary']/div/main/div/div/form/div[1]/div[2]/button")).click();  
          
        
          WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
          JavascriptExecutor js = (JavascriptExecutor) driver;
          try{
           
//              js.executeScript("window.scrollBy(" + 0 + "," + 100 + ")", "");
              
//              JavascriptExecutor jse = (JavascriptExecutor) driver;
              js.executeScript("arguments[0].setAttribute('value', arguments[1])", password, "Daisy@training");
              
          }catch(Exception e){
             System.out.println(e);
          } 

       
//          password.sendKeys("Daisy@training");
          Thread.sleep(1000);
          driver.findElement(By.xpath("//*[@text='Log In' and @nodeName='BUTTON']")).click();

          
          WebElement NewPostButton =driver.findElement(By.xpath("(//*[@id='header' and @nodeName='HEADER']/*/*/*/*[@nodeName='use' and @width>0 and ./parent::*[./parent::*[@nodeName='A' and ./parent::*[@nodeName='DIV']]]])[1]"));
          NewPostButton.click();
          
          WebElement PostTitle = driver.findElement(By.id("post-title-0"));
          PostTitle.click();
          PostTitle.sendKeys("My new Post");
          
          WebElement PostBOdy = driver.findElement(By.id("block-cfde46b9-fb90-427e-b147-c7c421399e4f"));
          PostBOdy.click();
          PostTitle.sendKeys("My new Post Content");
          
          
          WebElement PublishButton = driver.findElement(By.xpath("//*[@text='Publish' and @class='android.widget.Button']"));
          PublishButton.click();
          
          WebElement confirmPublish = driver.findElement(By.xpath("//*[@text='Publish' and @class='android.widget.Button' and (./preceding-sibling::* | ./following-sibling::*)[@text='Close panel']]"));
          confirmPublish.click();
  }
  

  @AfterTest
  public void afterTest() {
  }

}
