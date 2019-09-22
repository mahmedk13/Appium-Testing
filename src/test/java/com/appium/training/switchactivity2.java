package com.appium.training;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class switchactivity2 {
	
	public static String dialerPkg = "com.google.android.dialer";
	public static String dialerActivity = ".extensions.GoogleDialtactsActivity";
	
	public static String msgPkg = "com.google.android.apps.messaging";
	public static String msgActivity = ".ui.ConversationListActivity";

	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		

		AndroidDriver<WebElement> driver = null;
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME	, "emulator-5554");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.dialer");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".extensions.GoogleDialtactsActivity");
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
		Thread.sleep(5000);
		driver.findElementByXPath("//android.widget.TextView[@text='Contacts']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='Create new contact']").click();
		Thread.sleep(8000);
		String user = "bbc";
		driver.findElementByXPath("//android.widget.EditText[@text='First name']").sendKeys(user);
		driver.hideKeyboard();
		driver.findElementByXPath("//android.widget.EditText[@text='Phone']").sendKeys("4444445555");
		driver.findElementByXPath("//android.widget.Button[@text='SAVE']").click();
		Thread.sleep(3000);

	
		String activity =driver.currentActivity();
		System.out.println(activity);


		
		driver.startActivity(new Activity(msgPkg, msgActivity));
		
	
		
		Thread.sleep(5000);
		driver.findElementByAccessibilityId("Start new conversation").click();
		Thread.sleep(5000);

		driver.findElementById("com.google.android.apps.messaging:id/recipient_text_view").sendKeys(user);
		Thread.sleep(3000);

		driver.findElementById("com.google.android.apps.messaging:id/contact_picker_create_group").click();
		Thread.sleep(3000);

		driver.findElementById("com.google.android.apps.messaging:id/compose_message_text").sendKeys("abc");
		driver.findElementById("com.google.android.apps.messaging:id/send_message_button_icon").click();
		
		String xyz =driver.getAutomationName();
		System.out.println(xyz);
		driver.startActivity(new Activity(dialerPkg,dialerActivity));
		
		Thread.sleep(5000);

		
		try {
		driver.findElementByXPath("//android.widget.TextView[@text='Contacts']").click();
		}catch(Exception e) {
			
		}
		Thread.sleep(2000);
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"bbc\"));").click();
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"bbc\"));").click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + user + "\").instance(0))")).click();;     

		

		Thread.sleep(3000);
		
		driver.findElementByClassName("android.widget.ImageButton").click();

		
		
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='Delete']").click();
		

		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.Button[@text='DELETE']").click();
		Thread.sleep(5000);


		driver.quit();

		
	}

}
