package com.appium.pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class pageObjectSugan{
	/*
	 * public static final By save = By.id("org.gnucash.android:id/btn_save");
	 * 
	 * public static final By check_view = By.xpath(
	 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.ListView/android.widget.CheckedTextView[1]"
	 * );
	 * 
	 * public static final By button1 = By.id("android:id/button1");
	 * 
	 * public static final By RelativeLayout=By.xpath(
	 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.RelativeLayout"
	 * );
	 * 
	 * public static final By create_transaction =
	 * By.id("org.gnucash.android:id/create_transaction");
	 * 
	 * public static final By transaction_name =
	 * By.id("org.gnucash.android:id/input_transaction_name");
	 * 
	 * public static final By transaction_amount=
	 * By.id("org.gnucash.android:id/input_transaction_amount");
	 * 
	 * public static final By save_menu = By.id("org.gnucash.android:id/menu_save");
	 * 
	 */

	public static final By Next = By.id("org.gnucash.android:id/btn_save");

	public static final By checkbox = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.ListView/android.widget.CheckedTextView[1]");

	public static final By button1 = By.id("android:id/button1");

	public static final By salary1 = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[5]/android.widget.RelativeLayout/android.widget.ImageView[1]");

	public static final By salaryDescription = By.id("org.gnucash.android:id/input_transaction_name");

	public static final By salaryAmount1 = By.id("org.gnucash.android:id/input_transaction_amount");

	public static final By salaryType1 = By.id("org.gnucash.android:id/input_transaction_type");

	public static final By salaryDropDown1 = By.id("android:id/text1");

	public static final By salaryDropDownValue1 = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]");

	public static final By salarySave1 = By.id("org.gnucash.android:id/menu_save");

	public static final By bonus1 = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.ImageView[1]");

	public static final By bonusDescription1 = By.id("org.gnucash.android:id/input_transaction_name");

	public static final By bonusAmount1 = By.id("org.gnucash.android:id/input_transaction_amount");

	public static final By bonusType1 = By.id("org.gnucash.android:id/input_transaction_type");

	public static final By bonusSave1 = By.id("org.gnucash.android:id/menu_save");

	public static final By Expenses1 = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[3]/android.widget.RelativeLayout");

	public static final By addExpenses1 = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[7]/android.widget.RelativeLayout/android.widget.ImageView[3]");

	public static final By accountName1 = By.id("org.gnucash.android:id/input_account_name");

	public static final By accountDescription1 = By.id("org.gnucash.android:id/input_account_description");;

	public static final By placeholderAccount1 = By.id("org.gnucash.android:id/checkbox_placeholder_account");

	public static final By Expensesave1 = By.id("org.gnucash.android:id/menu_save");

}
