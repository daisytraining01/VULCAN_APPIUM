package com.appium.pageObjects;

import org.openqa.selenium.By;



public class pageObjects_Swetha  {
	
	
 public static final	By loginwithgoogle = By.id("com.buzzfeed.tasty:id/login_google");
 public static final	By displayname = By.id("com.google.android.gms:id/account_display_name");
 public static final	By SearchBox = By.id("com.buzzfeed.tasty:id/searchBoxContainer");
 
 
 
 public static final	By clicksearch = By.id("com.buzzfeed.tasty:id/searchBoxContainer");
 public static final	By EnterSeach = By.id("com.buzzfeed.tasty:id/searchEditTextView");
 
 
 public static final	By Suggestion = By.id("com.buzzfeed.tasty:id/searchSuggestionRowText");
 public static final	By ImageView = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[2]/android.widget.ImageView");
 public static final	By AddtoReceipes= By.xpath("//android.widget.TextView[@content-desc=\"Like/Un-like\"]");
 public static final	By MyReceipes = By.xpath("//android.widget.FrameLayout[@content-desc=\\\"My Recipes\\\"]/android.widget.ImageView");
 public static final    By Discover = By.xpath("//android.widget.FrameLayout[@content-desc=\"Discover\"]");
public static final     By BackButton=By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
public static final    By selectItem=By.id("thumbnail");
		
 		
 	
 
}
