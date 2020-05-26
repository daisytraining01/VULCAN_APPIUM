package com.appium.pageObjects;

import org.openqa.selenium.By;

public class WheelSizePageObject {
	public static final	By maker = By.id("com.wheelsize:id/etMake");
	public static final	By year = By.id("com.wheelsize:id/etYear");
	public static final	By model = By.id("com.wheelsize:id/etModel");
	public static final	By trim = By.id("com.wheelsize:id/etTrim");
	public static final	By searchBtn = By.id("com.wheelsize:id/btnSearch");
	
	public static final By wheelImage=By.xpath("//android.widget.FrameLayout[@content-desc=\"Main\"]/android.widget.ImageView");
	public static final	By setting = By.id("com.wheelsize:id/ibSettings");
	public static final	By rateUs = By.id("com.wheelsize:id/tvRateUs");
	public static final	By cancelBtn = By.id("com.wheelsize:id/btnCancel");
	public static final	By settingBack = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.ImageButton");
	public static final	By searchMain = By.xpath("//android.widget.FrameLayout[@content-desc=\"Search\"]/android.widget.ImageView");
}
