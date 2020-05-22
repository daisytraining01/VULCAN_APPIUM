package com.notepad.pageObjects;

import org.openqa.selenium.By;

public class PageObjects {

	public static final By newNote = By.id("com.hilarywang29.notepad2:id/action_addNote");
	public static final By editTitle = By.id("com.hilarywang29.notepad2:id/editTitle");
	public static final By editContent = By.id("com.hilarywang29.notepad2:id/editContent");
	public static final By saveNote = By.id("com.hilarywang29.notepad2:id/action_saveNote");
	public static final By SavedItems = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout\r\n"
					+ "");
	public static final By Delete = By.id("com.hilarywang29.notepad2:id/action_deleteNote");
	public static final By Button = By.id("android:id/button1");

}
